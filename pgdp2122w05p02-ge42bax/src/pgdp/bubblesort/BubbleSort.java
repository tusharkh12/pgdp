package pgdp.bubblesort;

public class BubbleSort {

    public static void bubbleSort(int[] fish) {

        //  for (int i = 0 ; i <fish.length; i++)
        for (int i = fish.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                // for (int j = 0; j < fish.length-1; j++)
                if (fish[j] > fish[j + 1]) {
                    int temp = fish[j];
                    fish[j] = fish[j + 1];
                    fish[j + 1] = temp;
                }
            }
        }

    }
}