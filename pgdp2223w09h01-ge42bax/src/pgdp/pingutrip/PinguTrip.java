package pgdp.pingutrip;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

final public class PinguTrip {

    // To hide constructor in utility class.
    private PinguTrip() {
    }

    public static Stream<WayPoint> readWayPoints(String pathToWayPoints) {

        try {
            List<String> readLines = Files.readAllLines(Path.of(pathToWayPoints));
            Stream<String> wayPoint = readLines.stream()
                    .takeWhile(line -> !line.startsWith("--"))
                    .filter(line -> !line.startsWith("//"));

            return wayPoint.map(WayPoint::ofString);

        } catch (IOException e) {
            return Stream.empty();

        }

    }

    public static Stream<OneWay> transformToWays(List<WayPoint> wayPoints) {
        Stream<OneWay> oneWayStream = IntStream.range(0, wayPoints.size() - 1)
                .mapToObj(i -> new OneWay(wayPoints.get(i), wayPoints.get(i + 1)));
        // TODO: Task 2
        return oneWayStream;
    }

    public static double pathLength(Stream<OneWay> oneWays) {
       double path = oneWays.mapToDouble(OneWay::getLength).sum();
        return path;
    }

    public static List<OneWay> kidFriendlyTrip(List<OneWay> oneWays) {
        double avg = oneWays.stream().mapToDouble(OneWay::getLength).average().orElse(0.0);

        return oneWays.stream()
                .takeWhile(oneWay -> oneWay.getLength() <= avg)
                .collect(Collectors.toList());


    }

    public static WayPoint furthestAwayFromHome(Stream<WayPoint> wayPoints, WayPoint home) {

        WayPoint wayPoint = wayPoints.map(way -> new OneWay(way, home))
                .max(Comparator.comparingDouble(OneWay::getLength))
                .map(OneWay::from)
                .orElse(home);
        // TODO: Task 5
        return wayPoint;
    }

    public static boolean onTheWay(Stream<OneWay> oneWays, WayPoint visit) {
        boolean onPath =oneWays.anyMatch(path-> path.isOnPath(visit));
        // TODO: Task 6
        return onPath;
    }

    public static String prettyDirections(Stream<OneWay> oneWays) {
        String result= oneWays.map(OneWay::prettyPrint).
                reduce((direction1, direction2) -> direction1 + "\n" + direction2)
                .orElse("");;
        return result;
    }

    public static void main(String[] args) {
        List<WayPoint> wayPoints = readWayPoints("test_paths/path.txt").toList();
        // List.of(new WayPoint(4.0, 11.5), new WayPoint(19.1, 3.2));

        List<OneWay> oneWays = transformToWays(wayPoints).toList();
        //System.out.println(oneWays);
        // List.of(new OneWay(new WayPoint(4.0, 11.5), new WayPoint(19.1, 3.2)));
//
        double length = pathLength(oneWays.stream());

//        // 17.230 ...
//
        List<OneWay> kidFriendly = kidFriendlyTrip(oneWays);

//        // List.of(new OneWay(new WayPoint(4.0, 11.5), new WayPoint(19.1, 3.2)));
//
        WayPoint furthest = furthestAwayFromHome(wayPoints.stream(), wayPoints.get(0));
        System.out.println(furthest);
        // new WayPoint(19.1, 3.2);
//
        boolean onTheWay = onTheWay(oneWays.stream(), new WayPoint(0.0, 0.0));
        System.out.println(onTheWay);
//        // false
//
        onTheWay = onTheWay(oneWays.stream(), new WayPoint(19.1, 3.2));
        System.out.println(onTheWay);
//        // true
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        System.out.println(list.stream().count());




        // IntStream.range(0, 3).forEach(System.out::println);
        //IntStream aa=IntStream.of(IntStream.range(0,(int) a.count()));


    }

}
