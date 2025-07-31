package pgdp.megamerge;


import java.util.Arrays;

public class MegaMergeSort {
    int[] mergeArray;
    int[] resultArray;
    //int from1;
//    //int i = 0;
//    int to1;
    boolean firstTime = true;



    int count = 2;

    //MEGA SORT VARIABLES
    int megaIndex = 0;
    int innerIndex = 0;
    int megaCount = 0;
    int[][] arrays1;
    int[][] arrays11;
    int[][] arrays2;
    int[][] arrays22;
    int IndexCount = 0;
    boolean MegafirstTime = true;
    boolean loop1 = true;
    boolean loop2 = true;
    boolean secondTime = false;

    boolean restArray=false;

    /**
     * Sorts the array using mega merge sort with div splits
     *
     * @param array the array to be sorted
     * @param div   the split factor
     * @return the sorted array
     */
    protected int[] megaMergeSort(int[] array, int div) {
        return megaMergeSort(array, div, 0, array.length);
    }

    /**
     * Sorts the array using mega merge sort with div splits in the defined range
     *
     * @param array the array to be sorted
     * @param div   the split factor
     * @param from  the lower bound (inclusive)
     * @param to    the upper bound (exclusive)
     * @return the sorted array
     */
    protected int[] megaMergeSort(int[] array, int div, int from, int to) {
        if(array.length==0){
            return new int[]{};
        }


        if (loop1) {
            int answer = array.length / div;
            int rest = array.length % div;
            if (MegafirstTime) {
                if (answer < div && rest != 0) {
                    answer = answer + 1;
                    restArray=true;
                    arrays1 = new int[div][answer];
                    arrays1[div-1]=new int [answer-1];
                } else if (rest == 0) {
                    arrays1 = new int[div][answer];
                } else {
                    arrays1 = new int[div][answer];
                    int i;
                    for (i = 0; i < div; i++) {
                        if (rest == 0) {
                            break;
                        }
                        rest = rest - 1;
                        arrays1[i] = new int[answer + 1];
                    }
                }
               arrays11=new int[arrays1.length][];
               // arrays11=arrays1;
            }
            MegafirstTime = false;


            arrays1[megaIndex][innerIndex] = array[megaCount];
            megaCount++;
            innerIndex++;
            if (arrays1[megaIndex].length == innerIndex) {
                // arrays11[megaIndex ]=megaMergeSort(array,div);
                megaIndex++;
                innerIndex = 0;


            }
            if (array.length == megaCount) {
                loop1 = false;
                secondTime = true;
                megaCount = 0;
                megaIndex = 0;
                innerIndex = 0;
            }

           int[]res= megaMergeSort(array, div);
           // System.out.println(Arrays.toString(res));
            //System.out.println(Arrays.toString(arrays1[megaIndex]));
        }
      // System.out.println(Arrays.deepToString(arrays1));

        if (loop2) {

            int answer;
            int rest;

            if (secondTime) {
                arrays2 = new int[array.length][1];
                megaCount=0;
                megaIndex=0;
//                if(restArray){
//                    arrays2=new int[array.length+1][1];
//                }
            }secondTime=false;
            //answer = arrays1[megaIndex].length / div;
           // rest = arrays1[megaIndex].length % div;
            arrays2[IndexCount][0] = array[IndexCount];
            megaCount++;
            IndexCount++;
            if (arrays1[megaIndex].length == megaCount) {
               // arrays2[IndexCount]=megaMergeSort(array,div);
                megaIndex++;
                megaCount = 0;


            }
            if (IndexCount == array.length){
                loop2=false;
            }

           int[] rr= megaMergeSort(array, div);
          //  System.out.println(Arrays.toString(rr));
            //System.out.println(Arrays.toString(arrays2[megaIndex]));

        }
      // System.out.println(Arrays.deepToString(arrays2));

        return merge(arrays2,from,to);
        //  System.out.println(Arrays.deepToString(arrays1));


        // TODO

    }

    /**
     * Merges all arrays in the given range
     *
     * @param arrays to be merged
     * @param from   lower bound (inclusive)
     * @param to     upper bound (exclusive)
     * @return the merged array
     */
    protected int[] merge(int[][] arrays, int from, int to) {

//        if (firstTime) {
//            from1 = from;
//            to1 = to;
//        }
        if (to > arrays.length) {
            to = arrays.length;
        }
        if (from >= to) {
            return new int[]{};
        }
        if (from < 0) {
            from = 0;
        }
        if (to - from == 1) {
            return arrays[from];
        }

        if (to - count == (from - 1)) {
            return resultArray;
        }
        if (firstTime) {

            //mergeArray=new int[arrays[to-1].length];
            resultArray = new int[arrays[to - 1].length];
            System.arraycopy(arrays[to - 1], 0, resultArray, 0, resultArray.length);
        }
        firstTime = false;
//        else{
//            temp=new int [resultArray.length];
//            System.arraycopy(resultArray,0,temp,0,index);
//            resultArray=new int[index+arrays[to-x].length];
//            System.arraycopy(temp,0,resultArray,(resultArray.length-index),resultArray.length);
//        }
//
        resultArray = merge(arrays[to - count], resultArray);
        count++;
        // i++;

        return resultArray = merge(arrays, from, to);


    }

    /**
     * Merges the given arrays into one
     *
     * @param arr1 the first array
     * @param arr2 the second array
     * @return the resulting array
     */
    //EXCEPTIONS CHECKED
    protected int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int n=arr1.length;
        int m =arr2.length;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i += 1;
                k += 1;
            } else {
                result[k] = arr2[j];
                j += 1;
                k += 1;
            }
        }

        while (i < n) {  // Merging remaining
            // elements of a[] (if any)
            result[k] = arr1[i];
            i += 1;
            k += 1;
        }
        while (j < m) {   // Merging remaining
            // elements of b[] (if any)
            result[k] = arr2[j];
            j += 1;
            k += 1;
        }


//        int[] result = new int[arr1.length + arr2.length];
//        int index = 0;
//        for (int i = 0; i < result.length; i++) {
//            if (i >= arr1.length) {
//                result[i] = arr2[index];
//                index++;
//            } else {
//                result[i] = arr1[i];
//            }
//        }
//        // System.out.println(Arrays.toString(result));
//        int min = 0;
//        for (int i = 0; i < result.length; i++) {
//            for (int j = i; j < result.length; j++) {
//                if (result[i] > result[j]) {
//                    min = result[j];
//                    result[j] = result[i];
//                    result[i] = min;
//
//                }
//
//            }



        //arr2=new int[result.length];
        //System.arraycopy(result,0,arr2,0,result.length);
        return result;
    }

    public static void main(String[] args) {
        MegaMergeSort mms = new MegaMergeSort();
//        int[] arr = new int[]{1, 2, 6, 7, 4, 3, 8, 9, 0, 5};
//        int[] res = mms.megaMergeSort(arr, 4);
//        //nt [][] array=
//        //  System.out.println(Arrays.toString(mms.merge(new int[][]{{1}, {2}, {3}, {4}}, 0, 4)));
//
//        //System.out.println(Arrays.toString(mms.merge(new int[]{0,0}, new int[]{0,0,0})));
//        // System.out.println(Arrays.toString(res));
//        int[] array = new int[]{1, 2, 3, 4};
//        int div = 3;
//        int answer = array.length / div;
//        int rest = array.length % div;
//        int arrays1[][] = new int[][]{};
        System.out.println(Arrays.toString(mms.megaMergeSort(new int[] {  8, 24, 19, 1, 16, 25, 26, 13, 14, 9, 10, 21, 11, 12, 22, 20, 2, 3, 0, 6, 4,
                18, 15, 23, 17, 7, 5  }, 3, 0, 27)));
       // System.out.println(Arrays.toString(mms.megaMergeSort(new int[]{1,2,3,4,5,6,7,8}, 3, 0, 8)));
    }
}
