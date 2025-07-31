package pgdp.security;

public class Main {

    /**
     * Eine kleine main zum Testen. Das Ergebnis soll wie auf Artemis ausschauen.
     *
     * @param args
     */
    public static void main(String[] args) {
        SignalPost signalPost = new LightPanel(3);
        signalPost.setLevel(1);
        signalPost.setDepiction("blue");
        System.out.println(signalPost.up("blue"));
        Track track = new Track(10);
        track.printStatus();


        track.createHazardAt(3, 6);
        track.printStatus();

        track.removeHazardAt(3, 6);
        track.printStatus();

        track.setAll("[SC]", true);
        track.printStatus();

        track.setAll("clear", false);
        track.printStatus();

        track.setAll("end", true);
        track.printStatus();


//		track.setRange("green",false,1,5);
//		track.printStatus();
        //track.setRange("down", true, 2, 1);
        //	track.printStatus();

    }
}
