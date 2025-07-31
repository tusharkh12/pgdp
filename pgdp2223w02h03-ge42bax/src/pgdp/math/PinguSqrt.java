package pgdp.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class PinguSqrt {

    public static void sqrt(double n) {
        if (n < 0) {
            System.out.println("Keine negativen Wurzeln!");
        } else if (n <= Integer.MAX_VALUE) {
//            NumberFormat formatter = new DecimalFormat("###.#####");
//
//            String f = formatter.format(n);
//            n= Double.parseDouble(f);
//            System.out.println(n);



            int intNumber = (int) n;
            //	System.out.println(intNumber);

            //BOOLEAN FOR THE LAST IF LOOP TO CHECK IF DECIMALARRAY >2
          //  boolean loop = false;

            float decimalPart = (float) (n - intNumber);
            //System.out.println(decimalPart);


            //dividing integer part in array

            int intTeil;


            String intString = String.valueOf(intNumber);
            if (intString.length() % 2 == 0) {
                intTeil = intString.length() / 2;
            } else {
                intTeil = (intString.length() / 2) + 1;
            }
            //System.out.println(intTeil);
            int[] intArray = new int[intTeil];
            // if()

            for (int i = intArray.length - 1; i >= 0; i--) {
                intArray[i] = intNumber % 100;
                intNumber = intNumber / 100;
                //System.out.println(intArray[i]);

            }


            //DIVIDING DECIMAL PART IN ARRAY
            String helper;


            int count = 0;
            if(n<0.001 && n>0.00001) {
                NumberFormat formatter = new DecimalFormat("###.####");

                helper = formatter.format(decimalPart);
               // System.out.println(helper);
            }

//            if(n<0.001) {
//
       else {

        helper = String.valueOf(decimalPart);
           // System.out.println(helper);
          }

            int[] decimalArray = new int[(helper.length() - 2)];


            for (int i = 2; i < helper.length(); i++) {
                if (decimalPart == 0) {
                    break;
                }
                decimalArray[count] = Character.digit(helper.charAt(i), 10);
                //System.out.println(helper.charAt(i));
                count++;
            }
            if (decimalArray.length == 1 && decimalArray[0] == 0) {
                decimalArray = null;
            }
            //  System.out.println(decimalArray.length);

            //GETTING FINAL ARRAY FOR DECIMAL PART


            int decimalTeil;
            int[] finalDecimalArray;


            if (decimalArray == null) {
                finalDecimalArray = null;
            } else {


                if (decimalArray.length % 2 == 0) {
                    decimalTeil = decimalArray.length / 2;
                } else {
                    decimalTeil = (decimalArray.length / 2) + 1;
                }
                //System.out.println(intTeil);
                finalDecimalArray = new int[decimalTeil];
                if (decimalTeil >= 3) {
                    finalDecimalArray = new int[2];
                }

                //  if()


                for (int i = 0; i < finalDecimalArray.length; i++) {

                    if (decimalArray.length == 1) {
                        finalDecimalArray[i] = 10 * decimalArray[i];
                    } else if (decimalArray.length == 3 && i == 1) {
                        finalDecimalArray[i] = 10 * decimalArray[i + 1];
                    } else {
                        if (i == 0) {
                            finalDecimalArray[i] = 10 * decimalArray[i] + decimalArray[i + 1];
                        } else {
                            finalDecimalArray[i] = 10 * decimalArray[i + 1] + decimalArray[i + 2];
                        }

                    }
                }

                // System.out.println(finalDecimalArray.length);


                //  System.out.println(finalDecimalArray[i]);

            }


//        int[] finalDecimalArray = new int[2];
//
//
//        if(decimalArray==null){
//           finalDecimalArray [0]= 00;
//           finalDecimalArray [0]= 00;
//
//        }
//
//        if(decimalArray.length<=2){
//             finalDecimalArray = new int[1];
//             finalDecimalArray[0] = 10 * decimalArray[0] + decimalArray[1];
//
//
//        }
//        if(decimalArray.length>2) {
//            finalDecimalArray = new int[2];
//            finalDecimalArray[0] = 10 * decimalArray[0] + decimalArray[1];
//            finalDecimalArray[1] = 10 * decimalArray[2] + decimalArray[3];
//        }


//        for (int i = 0; i < finalDecimalArray.length; i++) {
//            //System.out.println(finalDecimalArray[i]);
//        }


            // COPYING BOTH ARRAYS

            int[] finalArray;

            if (finalDecimalArray == null) {
                finalArray = new int[(intArray.length)];
                System.arraycopy(intArray, 0, finalArray, 0, (intArray.length));
            } else {

                finalArray = new int[(intArray.length) + finalDecimalArray.length];
                System.arraycopy(intArray, 0, finalArray, 0, (intArray.length));

                // +2 BCOZ IN CASE THERE IS A REMAINDER LEFT AND ANSWER NEEDS TO BE DECIMAL

                int index = 0;

                for (int i = intArray.length; i < finalArray.length; i++) {
                    finalArray[i] = finalDecimalArray[index];
                    index++;
                    //System.out.println(finalArray[i]);
                }
            }

//        if(finalDecimalArray.length<=1){
//            finalArray[intArray.length] = finalDecimalArray[0];
//        }else {
//            finalArray[intArray.length] = finalDecimalArray[0];
//            finalArray[intArray.length + 1] = finalDecimalArray[1];
//        }


            // CALCULATING SQUARE ROOT METHOD

            int subtrahend = 1;
            double value = 0;
            double result = 0;
            int divider = 10;
            int loopCount = 0;
            // System.out.println(finalArray.length);


            System.out.println("Wurzel aus " + n);
            System.out.println();

            for (int i = 0; i < finalArray.length; i++) {


                if (finalArray[0] == 0 && i == 0 || finalArray[0] == 0 && finalArray[i] == 0 && finalArray[i - 1] == 0) {
                    value = 0;
                    System.out.println(finalArray[i]);
                    System.out.println("--------");
                    System.out.println("--------");
                    //  System.out.println(value);
                } else {
                    if (i > 0) {
                        finalArray[i] = 100 * finalArray[i - 1] + finalArray[i];
                    }
                    System.out.println(finalArray[i]);
                    System.out.println("--------");
                    if (finalArray[i] - subtrahend < 0 || finalArray[i] == 0 && finalArray[i - 1] == 0) {
                        value = 0;
                        // break;
                    } else {


                        finalArray[i] = finalArray[i] - subtrahend;
                        value++;

                        System.out.println("-" + subtrahend);


                        // System.out.println(finalArray[0]);
                        while (finalArray[i] - subtrahend - 2 >= 0) {

                            subtrahend = subtrahend + 2;
                            System.out.println("-" + subtrahend);

                            finalArray[i] = finalArray[i] - subtrahend;

                            value++;


                            // System.out.println(finalArray[0]);

                        }
                        System.out.println("--------");


                    }


                    subtrahend = subtrahend + 1;
                    subtrahend = (subtrahend * 10) + 1;



                }

                System.out.println("Rest: " + finalArray[i]);

                System.out.println("neue Ergebnis Ziffer: " + (int) value);
                System.out.println();

                if (i < intTeil) {
                    result = 10 * result + value;
                } else {
                    result = result + (value / divider);
                    divider = divider * 10;
                }

                if (i == (finalArray.length - 1) && finalArray[i] != 0 && i < (intTeil + 1)) {
                    // assert

                    int[] newArray = new int[finalArray.length + 1];
                    System.arraycopy(finalArray, 0, newArray, 0, (finalArray.length));
                    finalArray = new int[newArray.length];
                    System.arraycopy(newArray, 0, finalArray, 0, finalArray.length);
                    loopCount++;


                }
                if (loopCount > 2) {
                    break;
                }


                value = 0;
            }
            System.out.println("Ergebnis: " + (float) result);


            // TODO
        }
    }

    public static void main(String[] args) {
      sqrt(42069.1337);

    }

}
