package pgdp.arrays;

import static pgdp.PinguLib.*;

public class Arrays {
    public static void print(int[] a) {
        writeConsole("{");
        if (a.length > 0) {
            writeConsole(a[0]);
            for (int i = 1; i < a.length; i++) {
                writeConsole(", " + a[i]);
            }
        }
        write("}");
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
        write("Minimum = " + min + ", Maximum = " + max);
    }

    public static int[] invert(int[] a) {
        int[] inverted = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            inverted[inverted.length - 1 - i] = a[i];
        }

        return inverted;
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

    public static int[] linearize(int[][] a) {
        int length = 0;

        for (int i = 0; i < a.length; i++) {
            length = length + a[i].length;
        }

        int[] linearized = new int[length];
        int linIndex = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                linearized[linIndex++] = a[i][j];
            }
        }

        return linearized;
    }
}