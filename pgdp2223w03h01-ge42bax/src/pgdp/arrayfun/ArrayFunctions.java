package pgdp.arrayfun;


import java.util.Arrays;

public class ArrayFunctions {

    protected ArrayFunctions() {
        throw new IllegalStateException("Don't create objects of type 'ArrayFunctions'!");
    }

    public static void main(String[] args) {
        //example call
//        int a =Integer.MAX_VALUE+3;
//        Math.addExact(a,1);
//        double a=(double) Integer.MAX_VALUE*Integer.MAX_VALUE;
//        System.out.println(a);
        //   System.out.println(Long.MAX_VALUE+1);

//        int[] array = new int[]{};
//
//
//       System.out.println((Arrays.toString(zip( new int[]{1, 3},
//               new int[]{2, 4,5,6}))));
//        int[][] arrays=new int[][]{   {1, 3},
//                {},
//                {-2},
//                {}};
//
//        System.out.println(Arrays.toString(zipMany(arrays)));
//        System.out.println(Arrays.toString(filter(  new int[]{2147483647, -2147483648, -5, 8, 10},
//                -2147483648,
//                2147483647)));
        //int[] arrayy=new int[]{1,3}
        // System.out.println(Arrays.toString(zip(new int[]{1, 3}, new int[]{2, 4})));
        //1, 2, 3, 4, 8, 2, 3, 8, 5, 6, 7,7,1

        // System.out.println(Arrays.deepToString(quantities(new int[]{1, 1, 2, 1, 3, 2, 1})));

        rotate(new int[]{1, 2, 3, 4, 5}, -10000002);
        //System.out.println(-1%4);
    }

    /**
     * Berechnet für das übergebene Array die Summe der Quadrate der Einträge.
     * Gibt dabei einen Fehler aus und -1 zurück, wenn ein Overflow entsteht.
     *
     * @param array Ein beliebiges Integer-Array.
     * @return Die Summe der Quadrate, wenn diese in einen 'long' passt, -1 sonst.
     */
    public static long sumOfSquares(int[] array) {

//        long[] arrayDouble =new long[array.length];
//        String[] aa=new String[array.length];
//        for (int i = 0; i < arrayDouble.length; i++) {
//            arrayDouble[i]=(long) array[i];
//            aa[i]=String.valueOf(array[i]);
//            System.out.println(aa[i]);
//
//        }

        // TODO
        long sum = 0;
        long square;
        if (array == null) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
//            if (array[i] > 0) {
//                try {
//                    int x = Math.addExact(array[i], 1);
//                } catch (ArithmeticException ex) {
//                    System.out.println("Overflow!");
//                    return -1;
//                }
//            } else {
//                try {
//                    int x = Math.addExact(array[i], -1);
//                } catch (ArithmeticException ex) {
//                    System.out.println("Overflow!");
//                    return -1;
//                }
//
//
//            }
            // square= (long) array[i] * array[i];
            sum = sum + ((long) array[i] * array[i]);
            if (sum < 0) {
                System.out.println("Overflow!");
                return -1;
            }

        }
//        for (int i = 0; i < array.length; i++) {
//            if ((long)sum < array[i]) {
//                System.out.println("Overflow!");
//                return -1;
//            }


        return sum;

    }


    /**
     * Methode, die zwei Arrays zu einem verbindet, indem sie abwechselnd Einträge des ersten und des zweiten Input-
     * Arrays verwendet.
     *
     * @param a Ein beliebiges Integer-Array.
     * @param b Ein beliebiges Integer-Array.
     * @return 'a' und 'b' zusammengezipped.
     */
    public static int[] zip(int[] a, int[] b) {
        int[] array = new int[a.length + b.length];
        if (b.length == 0) {
//            for (int i = 0; i < a.length; i++) {
//                System.out.println(a[i]);
//            }
            return a;
        }
        if (a.length == 0) {
//            for (int i = 0; i < b.length; i++) {
//                System.out.println(b[i]);
//            }
            return b;
        } else {
            // IF ARRAY A IS BIGGER
            if (a.length > b.length) {
                int[] arrayAIntermediate = new int[b.length];
                for (int i = 0; i < arrayAIntermediate.length; i++) {
                    arrayAIntermediate[i] = a[i];

                }
                int indexEven = 0;

                for (int i = 0; i < b.length; i++) {
                    array[indexEven] = arrayAIntermediate[i];
                    indexEven = indexEven + 2;
                }
                int indexOdd = 1;
                //int index=0;
                for (int i = 0; i < b.length; i++) {
                    array[indexOdd] = b[i];
                    indexOdd = indexOdd + 2;

                }
                int count = 2 * b.length;


                for (int i = b.length; i < a.length; i++) {
                    array[count] = a[i];
                    count++;
                }


            } // IF ARRAY B IS BIGGER

            else if (b.length > a.length) {
                int[] arrayBIntermediate = new int[a.length];
                for (int i = 0; i < arrayBIntermediate.length; i++) {
                    arrayBIntermediate[i] = b[i];

                }
                int indexEven = 0;

                for (int i = 0; i < a.length; i++) {
                    array[indexEven] = a[i];
                    indexEven = indexEven + 2;
                }
                int indexOdd = 1;
                //int index=0;
                for (int i = 0; i < a.length; i++) {
                    array[indexOdd] = arrayBIntermediate[i];
                    indexOdd = indexOdd + 2;

                }
                int count = 2 * a.length;


                for (int i = a.length; i < b.length; i++) {
                    array[count] = b[i];
                    count++;
                }


            } else {
                int indexEven = 0;

                for (int i = 0; i < a.length; i++) {
                    array[indexEven] = a[i];
                    indexEven = indexEven + 2;
                }
                int indexOdd = 1;
                //int index=0;
                for (int i = 0; i < b.length; i++) {
                    array[indexOdd] = b[i];
                    indexOdd = indexOdd + 2;

                }
            }

//            for (int i = 0; i < array.length; i++) {
//                System.out.println(array[i]);
//            }
            return array;
        }
    }

    /**
     * Methode, die eine beliebige Zahl an Arrays (dargestellt als Array von Arrays) zu einem einzigen Array verbindet,
     * indem sie abwechselnd von jedem Array einen Eintrag nimmt, bis alle aufgebraucht sind.
     *
     * @param arrays Array von Integer-Arrays
     * @return Die Arrays in 'arrays' zusammengezipped
     */
    public static int[] zipMany(int[][] arrays) {
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum += arrays[i].length;
        }
        // System.out.println(sum);

        int[] array = new int[sum];

        int index = 0;
        if (index == array.length) {
            return array;
        }

        // FOR ARRAYS[i][0]

        for (int i = 0; i < arrays.length; i++) {
            while (arrays[i].length == 0) {
                i = i + 1;
                if (i >= arrays.length) {
                    break;
                }
                if (arrays[i].length != 0) {
                    break;
                }
            }
            if (i < arrays.length) {
                array[index] = arrays[i][0];
                index++;
            }
            if (index == array.length) {
                return array;
            }
        }


        // FOR REMAINING PART

        for (int i = 1; i < sum; i++) {
            for (int j = 0; j < arrays.length; j++) {
                while (true) {
                    if (arrays[j].length < i + 1) {
                        j++;
                        if (j >= arrays.length) {
                            break;
                        }

                    } else {
                        break;
                    }
                }

                // BCOZ INSIDE WHILE LOOP J++ CAN MAKE IT BIGGER THAN ARRAY'S LENGTH

                if (j < arrays.length) {

                    array[index] = arrays[j][i];
                    index++;
                }


            }
            if (index == (array.length)) {
                return array;

            }
        }


        return array;
    }

    /**
     * Behält aus dem übergebenen Array nur die Einträge, die innerhalb der übergebenen Grenzen liegen.
     * Gibt das Ergebnis als neues Array zurück.
     *
     * @param array Ein beliebiges Integer-Array
     * @param min   Ein beliebiger Integer
     * @param max   Ein beliebiger Integer
     * @return Das gefilterte Array
     */
    public static int[] filter(int[] array, int min, int max) {

        if (max < min) {
            return new int[]{};
        }
        int[] finalArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= min && array[i] <= max) {
                finalArray[index] = array[i];
                index++;
            }
        }
        int[] answer = new int[index];
        System.arraycopy(finalArray, 0, answer, 0, index);

        return answer;
    }

    /**
     * Rotiert das übergebene Array um die übergebene Anzahl an Schritten nach rechts.
     * Das Array wird In-Place rotiert. Es gibt keine Rückgabe.
     *
     * @param array  Ein beliebiges Integer-Array
     * @param amount Ein beliebiger Integer
     */
    public static void rotate(int[] array, int amount) {
        if (array.length == 0) {
            array = new int[]{};
        } else {
            if (amount < 0) {
                amount = -(amount%array.length);
                amount = array.length - amount;
            }

                int exceedingPart = amount % (array.length);
                int remainingPart = array.length - exceedingPart;
                int[] exceedingArray = new int[array.length];
                int[] remainingArray = new int[array.length];

                int index = 0;
                for (int i = remainingPart; i < array.length; i++) {
                    exceedingArray[index] = array[i];
                    index++;

                }
                //System.out.println(Arrays.toString(exceedingArray));

                int count = exceedingPart;
                for (int i = 0; i < remainingPart; i++) {
                    remainingArray[count] = array[i];
                    count++;

                }
                //System.out.println(Arrays.toString(remainingArray));

                for (int i = 0; i < array.length; i++) {
                    array[i] = exceedingArray[i] + remainingArray[i];

                }
                //System.out.println(Arrays.toString(array));


            }
        }


        /**
         * Zählt die Anzahl an Vorkommen jeder Zahl im übergebenen Array, die in diesem mindestens einmal vorkommt.
         * Die Rückgabe erfolgt über ein 2D-Array, bei dem jedes innere Array aus zwei Einträgen besteht: Einer Zahl,
         * die im übergebenen Array vorkommt sowie der Anzahl an Vorkommen dieser.
         * Für jede im übergebenen Array vorkommenden Zahl gibt es ein solches inneres Array.
         * Diese tauchen im Rückgabewert in der gleichen Reihenfolge auf, in der die jeweils ersten Vorkommen der Zahlen
         * im übergebenen Array auftauchen.
         *
         * @param array Ein beliebiges Integer-Array
         * @return Das Array mit den Vielfachheiten der einzelnen Zahlen, wiederum als Integer-Arrays mit zwei Einträgen dargestellt.
         */
        public static int[][] quantities ( int[] array){

            if (array.length == 0) {
                return new int[0][];
            }
            int index = 1;
            boolean found = false;
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (array[i] == array[j]) {
                        found = true;
                        break;
                    }

                }
                if (!found) {
                    index++;
                }
                found = false;

            }
            found = false;
            boolean nullValue = false;
            int count = 0;
            int index_array = 0;
            int[][] doubleArray = new int[index][2];

            for (int i = 0; i < array.length; i++) {
                for (int j = 1; j < array.length; j++) {
                    while (true) {
                        if (array[i] == 0 && !nullValue) {
                            // nullValue=true;
                            break;

                        } else {
                            for (int k = 0; k < index; k++) {
                                if (array[i] == doubleArray[k][0]) {
                                    found = true;
                                    break;
                                }
                            }

                        }
                        break;
                    }
                    if (array[i] == array[j] && !found) {
                        count++;
                    }

                }
                if (!found) {
                    if (i == 0) {
                        count = count + 1;
                    }
                    doubleArray[index_array][0] = array[i];
                    doubleArray[index_array][1] = count;
                    index_array++;
                    if (array[i] == 0) {
                        nullValue = true;
                    }

                }
                count = 0;
                found = false;

            }

            // System.out.println(index);


            return doubleArray;
        }
    }
