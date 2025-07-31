package pgdp.array;

import java.util.Arrays;

public class Array {

    private static ArrayInterface arrayImplementation = new ArrayInterface() {
    };

    public static void print(int[] a) {
        arrayImplementation.print(a);
    }

    public static void minAndMax(int[] a) {
        arrayImplementation.minAndMax(a);
    }

    public static void invert(int[] a) {
        arrayImplementation.invert(a);
    }

    public static int[] intersect(int[] a, int length) {
        return arrayImplementation.intersect(a, length);
    }

    public static int[] linearize(int[][] a) {
        return arrayImplementation.linearize(a);
    }

    public static void bubbleSort(int[] a) {
        arrayImplementation.bubbleSort(a);
    }

    public static void setArrayImplementation(ArrayInterface arrayImplementation) {
        Array.arrayImplementation = arrayImplementation;
    }

//	public static void main(String[] args) {
//		//print(new int[]{1,2,3});
//		//minAndMax(new int[]{0,0,0});
//		//invert(new int[]{1,2,3});
//		//System.out.println(Arrays.toString(intersect(new int[]{}, 0)));
//		System.out.println(Arrays.toString(linearize(new int[][]{{}})));
//
//	}
}
