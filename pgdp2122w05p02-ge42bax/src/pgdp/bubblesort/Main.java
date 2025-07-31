package pgdp.bubblesort;

import java.util.Arrays;

import static pgdp.bubblesort.BubbleSort.bubbleSort;

public class Main {

    public static void main(String[] args) {

        int[] fischbestand = {6,1,6,8,9,1,9,1,5};

        bubbleSort(fischbestand);

        System.out.println(Arrays.toString(fischbestand));
    }
}
