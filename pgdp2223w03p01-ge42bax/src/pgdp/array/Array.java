package pgdp.array;

public class Array {
    public static void print(int[] a) {
        System.out.print("{");

        if (a.length > 0) {
            System.out.print(a[0]);
            for (int i = 1; i < a.length; i++) {
                System.out.print(", " + a[i]);
            }
        }

        System.out.print("}");

    }

    public static void minAndMax(int[] a) {
        if (a.length == 0) {
            return;
        }

        int min = a[0];
        int max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
            if (a[i] > max)
                max = a[i];
        }

        System.out.println("Minimum = " + min + ", Maximum = " + max);
    }

    public static boolean isOrderedAscendingly(int[] a) {
        boolean ordered = true;
        for (int i = 0; i < a.length - 1; i++) {
            ordered &= a[i] <= a[i + 1];
        }
        return ordered;
    }

    public static void invert(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }

    public static int[] intersect(int[] a, int length) {
        if (length <= 0) {
            return new int[0];
        }

        int[] intersected = new int[length];

        for (int i = 0; i < length && i < a.length; i++) {
            intersected[i] = a[i];
        }

        return intersected;
    }

    public static int[] filterEvenNumbersFrom(int[] a) {

        int sizeOfNewArray = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                sizeOfNewArray++;
            }
        }

        int[] out = new int[sizeOfNewArray];
        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                out[j] = a[i];
                j++;
            }
        }

        return out;
    }

    public static int[] distinct(int[] a) {
        int[] outArrayWithPadding = new int[a.length];
        int firstUnusedPosition = 0;

        // Copy everything into 'outArrayWithPadding' that isn't already in there
        for (int i = 0; i < a.length; i++) {
            boolean isAlreadyInOut = false;
            for (int j = 0; j < firstUnusedPosition; j++) {
                if (a[i] == outArrayWithPadding[j]) {
                    isAlreadyInOut = true;
                    break;
                }
            }

            if (!isAlreadyInOut) {
                outArrayWithPadding[firstUnusedPosition] = a[i];
                firstUnusedPosition++;
            }
        }

        // Copy into new Array without any trailing zeros
        int[] outArray = new int[firstUnusedPosition];
        for (int i = 0; i < firstUnusedPosition; i++) {
            outArray[i] = outArrayWithPadding[i];
        }

        return outArray;
    }

}
