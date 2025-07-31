package pgdp.convexhull;

import java.util.Arrays;
import java.util.Objects;

public class QuickHull {
    static boolean firstTime = true;
    static boolean secondTime = true;
    static boolean existsFromPR = false;
    static int index = 0;
    static int[] r;
    static int[][] arrays;
    static boolean r_Value = true;

    //HELPER
    static int[][] helper;
    static boolean exitsFromPR=false;
    static int a = 0;
    static boolean firsttime = true;
    static boolean rValue = true;
    static boolean secondtime = true;


    /* ================ Zu implementierende Methoden ================ */


    // Returns hull as {p, ..., q, ..., p}, where p is the leftmost point
    public static int[][] quickHull(int[][] points) {

        int[] p = findLeftmostPoint(points);
        int[] q = findRightmostPoint(points);
        int[][] hull1 = quickHullLeftOf(points, q, p);
        firstTime = true;
        secondTime = true;
        existsFromPR = false;
        index = 0;
        r_Value = true;

        //HELPER

        a = 0;
        firsttime = true;
        rValue = true;
        secondtime = true;
        exitsFromPR=false;

        int[][] hull2 = quickHullLeftOf(points, p, q);


        return combineHulls(hull1, hull2);
//        int[][] hull;
//        int[] p;
//
//        int[] min;
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i; j < points.length; j++) {
//                if (points[i][0] > points[j][0]) {
//                    min = points[j];
//                    points[j] = points[i];
//                    points[i] = min;
//                }
//            }
//        }
//        //LEFT POINT
//        int value1 = helperForQuickHullLeftOf(points, points[0], points[points.length - 1]);
//        System.out.println(value1);
//        //RIGHT POINT
//        int value2 = helperForQuickHullLeftOf(points, points[points.length - 1], points[0]);
//        System.out.println(value2);
//        int length = value1 + value2 ;
//        hull=new int[length][2];
//
//        int [][] hull1=new int[value2][2];
//        hull1=quickHullLeftOf(points,points[points.length - 1], points[0]);
//        System.out.println(Arrays.deepToString(hull1));
////        for (int i = 0; i < hull1.length; i++) {
////            hull[i][0]=hull1[i][0];
////            hull[i][1]=hull1[i][1];
////        }
//
//        int [][] hull2=new int[value1][2];
//        hull2=quickHullLeftOf(points, points[0], points[points.length - 1]);
//        System.out.println(Arrays.deepToString(hull2));
//        int index=hull1.length;
////        for (int i = 0; i < hull2.length-1; i++) {
////            hull[index][0]=hull2[i][0];
////            hull[index][1]=hull2[i][1];
////            index++;
////        }
//       hull= combineHulls(hull1,hull2);
//        return hull;
    }

    public static int helperForQuickHullLeftOf(int[][] points, int[] p, int[] q) {

        if (firsttime) {
           firstTime = true;
           secondTime = true;
            existsFromPR = false;
            r_Value = true;
             index = 0;
             exitsFromPR=false;
             a = 0;
            firsttime = true;
            rValue = true;
             secondtime = true;
            //int value=helperForQuickHullLeftOf(points,p,q);
            helper = new int[2 * points.length][2];

            helper[a] = q;
            a++;
            helper[a] = p;
            a++;

            boolean exitsFromP = existsPointLeftOf(points, p, q);
            if (!exitsFromP) {
                return a;
            }
            // IF R EXISTS
            else {
                r = new int[2];
                r = findPointFurthestLeftFrom(points, p, q);
                boolean exitsFromPR = existsPointLeftOf(points, p, r);

                    if (exitsFromPR) {
                        helper[a] = findPointFurthestLeftFrom(points, p, r);
                        a++;
                    }

//             else{
//                    return a;
//                }
            }
            //index--;
        }
        firsttime = false;

        boolean exitsFromP = existsPointLeftOf(points, p, helper[a - 1]);
        if (exitsFromP && rValue && exitsFromPR) {
            helper[a] = findPointFurthestLeftFrom(points, p, helper[a - 1]);
            a++;
        } else {
            if (secondtime) {
                secondtime = false;
                helper[a] = r;
                a++;
                rValue = false;
                // index--;
                boolean exitsFromQ = existsPointLeftOf(points, r, q);
                if (exitsFromQ ) {
                    helper[a] = findPointFurthestLeftFrom(points, r, q);
                    a++;

                } else {
                    return a;
                }
            } else {
                boolean exitsFromQ = existsPointLeftOf(points, helper[a - 1], q);
                if (exitsFromQ) {
                    helper[a] = findPointFurthestLeftFrom(points, helper[a - 1], q);
                    a++;
                } else return a;
            }

        }
//        if(index==0){
//            return arrays;
//        }

        helperForQuickHullLeftOf(points, p, q);


        return a;
    }

    // Returns hull-points in counter-clockwise fashion: {q, ..., p}
    public static int[][] quickHullLeftOf(int[][] points, int[] p, int[] q) {

        if (firstTime) {
            int value = helperForQuickHullLeftOf(points, p, q);
            //System.out.println(value);
            arrays = new int[value][2];
            index = arrays.length - 1;
            arrays[0] = q;
            arrays[index] = p;
            index--;
            boolean existsFromP = existsPointLeftOf(points, p, q);
            if (!existsFromP) {
                return new int[][]{q, p};
            }else {
                r = new int[2];
                r = findPointFurthestLeftFrom(points, p, q);
                boolean existsFromPR = existsPointLeftOf(points, p, r);
                if (existsFromPR) {
                    arrays[index] = findPointFurthestLeftFrom(points, p, r);
                    index--;
//            } else {
//                return new int[][]{q, r, p};
                }
            }
            //index--;
        }
        firstTime = false;
        if (index == 0) {
            firstTime = true;
            secondTime = true;
            existsFromPR = false;
            r_Value = true;
            index = 0;
            exitsFromPR=false;
            a = 0;
            firsttime = true;
            rValue = true;
            secondtime = true;
            return arrays;
        }

        boolean existsFromP = existsPointLeftOf(points, p, arrays[index + 1]);
        // CHECKS IF A POINT B/W P AND R EXISTS TOO.
        if (existsFromP && r_Value && existsFromPR) {
            arrays[index] = findPointFurthestLeftFrom(points, p, arrays[index + 1]);
            index--;
        } else {

            if (secondTime) {
                secondTime = false;
                arrays[index] = r;
                index--;
                r_Value = false;
                boolean existsFromQ = existsPointLeftOf(points, r, q);
                if (existsFromQ) {
                    arrays[index] = findPointFurthestLeftFrom(points, r, q);
                    index--;

                } else {
                    return arrays;
                }
            } else {
                boolean existsFromQ = existsPointLeftOf(points, arrays[index + 1], q);
                if (existsFromQ) {
                    arrays[index] = findPointFurthestLeftFrom(points, arrays[index + 1], q);
                    index--;
                } else return arrays;
            }

        }


       return quickHullLeftOf(points, p, q);

       // return arrays;
    }

    public static int[][] combineHulls(int[][] firstHull, int[][] secondHull) {
        if (firstHull.length == 0 && secondHull.length == 0) {
            return new int[][]{};
        }
        int[][] hull = new int[firstHull.length + secondHull.length - 1][2];
        int index = 1;

        boolean found = false;

        if (firstHull.length == 0) {
            found = true;
            hull = new int[secondHull.length][2];
            index = 0;
        }
        if (secondHull.length == 0) {
            hull = new int[firstHull.length][2];
        }
        for (int i = 0; i < hull.length; i++) {
            if (i == firstHull.length - 1 && !found) {
                found = true;
                hull[i][0] = firstHull[i][0];
                hull[i][1] = firstHull[i][1];
                if (secondHull.length != 0) {
                    i++;
                } else {
                    break;
                }


            }
            if (!found) {
                hull[i][0] = firstHull[i][0];
                hull[i][1] = firstHull[i][1];
            } else {
                hull[i][0] = secondHull[index][0];
                hull[i][1] = secondHull[index][1];
                index++;
            }


        }
        return hull;
    }


    /* ================ Vorgegebene Methoden ================ */


    public static int[] findPointFurthestLeftFrom(int[][] points, int[] firstLinePoint, int[] secondLinePoint) {
        double maxDistance = 0.0;
        int[] leftmostPoint = null;
        for (int i = 0; i < points.length; i++) {
            double distance = Math.abs(signedDistance(points[i], firstLinePoint, secondLinePoint));
            if (isPointLeftOf(points[i], firstLinePoint, secondLinePoint) && distance > maxDistance) {
                maxDistance = distance;
                leftmostPoint = points[i];
            }
        }
        return leftmostPoint;
    }

    public static int[] findLeftmostPoint(int[][] points) {
        int[] currentLeftmost = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < currentLeftmost[0]) {
                currentLeftmost = points[i];
            }
        }
        return currentLeftmost;
    }

    public static int[] findRightmostPoint(int[][] points) {
        int[] currentRightmost = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentRightmost[0]) {
                currentRightmost = points[i];
            }
        }
        return currentRightmost;
    }

    public static boolean isPointLeftOf(int[] point, int[] firstLinePoint, int[] secondLinePoint) {
        double n = signedDistance(point, firstLinePoint, secondLinePoint);
        return n < 0;
    }

    public static boolean existsPointLeftOf(int[][] points, int[] firstLinePoint, int[] secondLinePoint) {
        for (int i = 0; i < points.length; i++) {
            if (isPointLeftOf(points[i], firstLinePoint, secondLinePoint)) {
                return true;
            }
        }
        return false;
    }

    public static double signedDistance(int[] point, int[] firstLinePoint, int[] secondLinePoint) {
        int det = (secondLinePoint[0] - firstLinePoint[0]) * (firstLinePoint[1] - point[1]) - (firstLinePoint[0] - point[0]) * (secondLinePoint[1] - firstLinePoint[1]);
        double len = Math.sqrt(Math.pow(secondLinePoint[0] - firstLinePoint[0], 2) + Math.pow(secondLinePoint[1] - firstLinePoint[1], 2));

        return det / len;
    }

    public static String pointsToPlotString(int[][] points) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(points).filter(Objects::nonNull).forEach(point -> sb.append("point(").append(point[0]).append("|").append(point[1]).append(")\n"));
        return sb.toString();
    }

    public static void main(String[] args) {
//         int[][] in = new int[][]{{0, 0}, {0, 2}, {2, 0}, {2, 2}, {1, 1}};
//        int[][] hull = quickHull(in);
//         System.out.println(pointsToPlotString(in));
//         System.out.println(pointsToPlotString(hull));
        // quickHullLeftOf(new int[][]{ {3, 5}, {1, 6}, {-2 ,5}},new int[]{-3, 2},new int[]{4,3})

        int[][] points= new int[][] {  {-3, 2},
                {-2, 1}, {-2, 3}, {-2, 5},
                {-1, 0}, {-1, 4},
                {0, 4},
                {1, 1}, {1, 4}, {1, 6},
                {2, 3}, {2, 5},
                {3, -1}, {3, 2}, {3, 5},
                {4, 3}};
        int[] p =new int[]{-3,2};
        int[] q = {4,3};


//        int[][] hull2 =quickHullLeftOf(points,p,q);
//       int[][] hull1 =quickHullLeftOf(points,q,p);

        //System.out.println(Arrays.deepToString(hull1));
       //System.out.println(Arrays.deepToString(hull2));
      // System.out.println(Arrays.deepToString(combineHulls(hull1, hull1)));

      System.out.println(Arrays.deepToString(quickHull(points)));






    }
}
