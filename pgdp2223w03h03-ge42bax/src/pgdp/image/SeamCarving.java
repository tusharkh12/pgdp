package pgdp.image;

import java.util.Arrays;

public class SeamCarving {

    public int computeGradientMagnitude(int v1, int v2) {
        // CALCULATE GBR VALUES FOR V1
        //THANKS TO ERA IT'S SO EASYILY DONE:)
        int red1 = v1 & 255;
        //System.out.println(red1);
        int blue1 = (v1 >> 8) & 255;
        //System.out.println(blue1);
        int green1 = (v1 >> 16) & 255;
        //System.out.println(green1);

        // CALCULATE GBR VALUES FOR V2
        int red2 = v2 & 255;
        int blue2 = (v2 >> 8) & 255;
        int green2 = (v2 >> 16) & 255;

        double value = (double) ((red1 - red2) * (red1 - red2)) + ((blue1 - blue2) * (blue1 - blue2)) + ((green1 - green2) * (green1 - green2));

        int value_Int = (int) value;


        return value_Int;
    }

    public void toGradientMagnitude(int[] picture, int[] gradientMagnitude, int width, int height) {
        for (int i = 0; i < gradientMagnitude.length; i++) {
            if (i < width || i % width == 0 || (i % width == (width - 1)) || (i + width) >= picture.length) {
                gradientMagnitude[i] = Integer.MAX_VALUE;
            } else {
                gradientMagnitude[i] =
                        computeGradientMagnitude(picture[i - width], picture[i + width]) +
                                computeGradientMagnitude(picture[i - 1], picture[i + 1]);
            }

        }
    }

    public void combineMagnitudeWithMask(int[] gradientMagnitude, int[] mask, int width, int height) {
        for (int i = 0; i < gradientMagnitude.length; i++) {
            //ERA :)
            if ((mask[i] & 0X00FFFFFF) == 0) {
                gradientMagnitude[i] = Integer.MAX_VALUE;
            }

        }

    }

    public void buildSeams(int[][] seams, long[] seamWeights, int[] gradientMagnitude,
                           int width, int height) {
        int x = 0;
        int y = 0;
        int index = 0;
        int count = 0;
        long sum = 0;

        for (int i = 0; i < gradientMagnitude.length; i++) {
            //IF PIXEL IS AT BOTTOM ROW
            if (i + width > gradientMagnitude.length) {
                seamWeights[index] += gradientMagnitude[i];
                x = i % width;
                seams[index][count] = x;
                count++;
                // break;
            }

            //IF PIXEL IS AT LEFT RAND
            else if (i % width == 0 && (i + width) < gradientMagnitude.length) {
                // IF RIGHT LOWER AND CENTER HAVE SAME VALUES OR CENTER IS LESS THAN RIGHT
                if (gradientMagnitude[i + width] == gradientMagnitude[i + width + 1] || gradientMagnitude[i + width] < gradientMagnitude[i + width + 1]) {
                    seamWeights[index] += gradientMagnitude[i];
                    x = i % width;
                    seams[index][count] = x;
                    count++;
                    i = i + width - 1;

                } else {
                    // RIGHT IS LESS THAN CENTER
                    seamWeights[index] += gradientMagnitude[i];
                    x = i % width;
                    seams[index][count] = x;
                    count++;
                    i = i + width + 1 - 1;
                }

            }

            // IF PIXEL IS AT RIGHT RAND
            else if (i % width == (width - 1) && (i + width) < gradientMagnitude.length) {
                // IF LEFT LOWER AND CENTER HAVE SAME VALUES OR CENTER IS LESS THAN LEFT
                if (gradientMagnitude[i + width] == gradientMagnitude[i + width - 1] || gradientMagnitude[i + width] < gradientMagnitude[i + width - 1]) {
                    seamWeights[index] += gradientMagnitude[i];
                    x = i % width;
                    seams[index][count] = x;
                    count++;
                    i = i + width - 1;

                } else {
                    // LEFT IS LESS THAN CENTER
                    seamWeights[index] += gradientMagnitude[i];
                    x = i % width;
                    seams[index][count] = x;
                    count++;
                    i = i + width - 1 - 1;
                }

            }

            // 1) PIXEL WITH MINIMUM WEIGHT
            //RIGHT LOWEST
            else if (gradientMagnitude[i + width - 1] > gradientMagnitude[i + width + 1] &&
                    gradientMagnitude[i + width] > gradientMagnitude[i + width + 1]) {
                seamWeights[index] += gradientMagnitude[i];
                x = i % width;
                seams[index][count] = x;
                count++;
                i = i + width + 1 - 1;
                //  index++;
            }

            // LEFT LOWEST
            else if (gradientMagnitude[i + width + 1] > gradientMagnitude[i + width - 1] &&
                    gradientMagnitude[i + width] > gradientMagnitude[i + width - 1]) {
                seamWeights[index] += gradientMagnitude[i];
                x = i % width;
                seams[index][count] = x;
                count++;
                i = i + width - 1 - 1;
                //  index++;
            }

            //CENTER
            else if (gradientMagnitude[i + width + 1] >= gradientMagnitude[i + width] &&
                    gradientMagnitude[i + width - 1] >= gradientMagnitude[i + width]) {
                seamWeights[index] += gradientMagnitude[i];
                x = i % width;
                seams[index][count] = x;
                count++;
                i = i + width - 1;
                //  index++;
            }

            // 2) IF THE RIGHT AND LEFT PIXEL HAVE SAME WEIGHT
            else if (gradientMagnitude[i + width] > gradientMagnitude[i + width + 1] &&
                    gradientMagnitude[i + width] > gradientMagnitude[i + width - 1] &&
                    gradientMagnitude[i + width + 1] == gradientMagnitude[i + width - 1]) {
                seamWeights[index] += gradientMagnitude[i];
                x = i % width;
                seams[index][count] = x;
                count++;
                i = i + width - 1 - 1;
                //  index++;
            }

            // 3) IF ALL PIXELS HAVE SAME WEIGHT
            else if (gradientMagnitude[i + width] == gradientMagnitude[i + width + 1] &&
                    gradientMagnitude[i + width] == gradientMagnitude[i + width - 1] &&
                    gradientMagnitude[i + width + 1] == gradientMagnitude[i + width - 1]) {
                seamWeights[index] += gradientMagnitude[i];
                x = i % width;
                seams[index][count] = x;
                count++;
                // y = i / width;

                // seams[index][1] = y;
                i = i + width - 1;
                //  index++;
            }

            if (seams[index].length <= count) {
                count = 0;
                sum = 0;
                index++;
                i = index - 1;
                if (i == (width - 1)) {
                    break;
                }

            }


        }

    }

    public void removeSeam(int[] seam, int[] image, int height, int oldWidth) {
       // int index=0;
        int[] seam_Temp =new int[seam.length];
        seam_Temp[0]=seam[0];
        int sum=seam[0];
        //NEW SEAM ARRAY FOR CORRECT INDEXES
        for (int i = 1; i < seam.length; i++) {
            if(seam[i-1]>seam[i]){
                sum+=oldWidth-1;
                seam_Temp[i]=sum;
            } else if(seam[i-1]<seam[i]){
                sum+=oldWidth+1;
                seam_Temp[i]=sum;
            } else{
                sum+=oldWidth;
                seam_Temp[i]=sum;
            }
           // System.out.println(seam_Temp[i]);
        }

//        boolean found =false;
//        int index=0;
//        int[] image_Temp=new int[image.length-seam.length];
//        for (int i = 0; i < image.length; i++) {
//            for (int j = 0; j < seam_Temp.length; j++) {
//                if(i==seam_Temp[j]){
//                    found=true;
//                    break;
//                }
//            }
//            if(!found){
//                image_Temp[index]=image[i];
//                index++;
//
//            }
//
//            found=false;
//
//        }
//
//        System.arraycopy(image_Temp,0,image,0,image_Temp.length);

        boolean found =false;
        int index=0;
        int[] image_Temp=new int[image.length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < seam_Temp.length; j++) {
                if(i==seam_Temp[j]){
                    found=true;
                    break;
                }
            }
            if(!found){
                image_Temp[index]=image[i];
                index++;

            }

            found=false;

        }

        System.arraycopy(image_Temp,0,image,0,image.length);
    }
    // HELP METHOD TO FIND THE SEAM WITH THE LOWEST WEIGHT
    public int helper(long[] seam){
        int small_one =0;
        for (int a = 0;a<seam.length;a++){
            if (seam[a]<seam[small_one]){
                small_one = a;
            }
        }
        return small_one;
    }

    public int[] shrink(int[] image, int[] mask, int width, int height, int newWidth) {
       // int seamCount =  width-newWidth;
        int[] gradientMagnitude;
        for (int i = 0; i <width-newWidth ; i++) {
            gradientMagnitude= new int [(width-i)*height];
            toGradientMagnitude(image,gradientMagnitude,width-i,height);
            combineMagnitudeWithMask(gradientMagnitude,mask,width-i,height);
            int[][] seam = new int[width-i][height];
            long[] seamWeight =new long[width-i];
            buildSeams(seam, seamWeight,gradientMagnitude,width-i,height);
            removeSeam(seam[helper(seamWeight)],image,height,width-i);
            removeSeam(seam[helper(seamWeight)],mask,height,width-i);

        }
        int[] new_pic = new int [newWidth*height];
        for (int i = 0; i < new_pic.length; i++) {
            new_pic[i]= image[i];
        }
        return new_pic;
    }

    public static void main(String[] args) {
        SeamCarving seamCarving = new SeamCarving();
        // System.out.println(seamCarving.computeGradientMagnitude(10, 0));


//        int width = 3;
//        int height = 3;
//        int[] pic = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] result = new int[width * height];
//        seamCarving.toGradientMagnitude(pic, result, width, height);
//        System.out.println(Arrays.toString(result));

//        int width = 4;
//        int height = 3;
//        int[] pic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
//        int[] result = new int[width * height];
//        // new SeamCarving().toGradientMagnitude(pic, result, width, height);
//        //System.out.println(Arrays.toString(result));
//
//        int[] array = new int[]{2, -3, -5, 7, -11, 13,
//                -17, 19, 23, 29, -31, 37,
//                -41, 43, 47, 53, -59, 61,
//                -67, 71, 73, 79, -83, 97};
//        new SeamCarving().combineMagnitudeWithMask(array, new int[]{0, 1, 2, 3, 4, 5,
//                        6, 7, 2063597568, 0, 1, 1,
//                        0, -16777216, 0, 0, 0, 0,
//                        9, 9, 9, 9, 9, 9},
//                6,
//                4);
//        System.out.println(Arrays.toString(array));
//        int[][] seams = new int[6][5];
//        long[] seam = new long[6];
//        int[] mag = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 1, 1, 1, 1, 1, 69, 420, 42, 42, 42, 1337, 100, 10, 666, 20, 3, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//
//        int width = 6;
//        int height = 5;
//        seamCarving.buildSeams(seams, seam, mag, width, height);
//        for (int i = 0; i < seams.length; i++) {
//            System.out.println(Arrays.toString(seams[i]));
//        }
        seamCarving.removeSeam(new int[]{2,3,2,1},new int[16],4,4);

        int[] image = new int[]{255, 255, 255, 255,
                16711680, 1572992, 0, 8453888,
                16711680, 0, 8388672, 8453888,
                65280, 65280, 65280, 65280};
        int width = 4, height = 4, newWidth = 3;
        int[] mask = new int[]{0,0,1,1, 0,0,1,0, 1,1,1,0, 1,1,1,0};
       // int[] mask = new int[]{0,0,1,1, 0,0,1,0, 1,1,1,0, 1,1,1,0};

        System.out.println(Arrays.toString(seamCarving.shrink(image, mask, width, height, newWidth)));


      //  System.out.println(Arrays.toString(seam));

    }


}
