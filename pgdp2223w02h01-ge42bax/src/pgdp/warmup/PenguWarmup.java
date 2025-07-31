package pgdp.warmup;

public class PenguWarmup {

    protected PenguWarmup() {
        throw new UnsupportedOperationException();
    }

    public static void penguInfoOut(int penguin) {
        if (penguin >= 0) {
            if (penguin % 2 == 0) {
                System.out.println("Penguin: "+penguin);
                System.out.println("This penguin is a male.");
            } else {
                System.out.println("Penguin: "+penguin);
                System.out.println("This penguin is a female.");
            }
        } else {
            System.out.println("Penguin " + penguin + " is not a known penguin!");
        }

    }

    public static int penguEvolution(int penguin, int years) {

            int count = 0;
            boolean loop = false;
            boolean exponentOfTwo = false;
            int checkYears = penguin;
            if (years == 0) {
                return penguin;
            }
//        if(checkYears%2==0) {
//            for (int i = 0; i < penguin / 2; i++) {
//
//                checkYears = checkYears / 2;
//
//                if (checkYears == 1) {
//                    exponentOfTwo = true;
//                }
//                if(checkYears%2!=0){
//                    break;
//                }
//            }
//        }
        int xx=0;


            while (xx<years) {
                if (checkYears % 2 == 0) {
                    for (int i = 0; i < penguin / 2; i++) {

                        checkYears = checkYears / 2;

                        if (checkYears == 1) {
                            exponentOfTwo = true;
                            break;
                        }
                        if (checkYears % 2 != 0) {
                            break;
                        }
                    }

                }
               // System.out.println(exponentOfTwo);

                if (penguin % 2 == 0) {
                    if (exponentOfTwo) {
                        if (years == 1) {
                            return 1;
                        }
                        checkYears = 2;
                        for (int i = 1; i < years; i++) {
                            checkYears = checkYears * 2;

                        }
                        return checkYears;
                    } else {

                        penguin = penguin / 2;
                        count++;

                    }

                    loop = false;
                } else {
                    if (penguin % 7 == 0 & !loop) {
                        for (int i = 1; i < 7; i++) {
                            // penguin=7;
                            count++;
                            if (count == years) {
                                return penguin;
                            }
                            loop = true;

                        }

                    } else {
                        penguin = (3 * penguin) + 1;
                        count++;
                        loop = false;
                    }
                }

                if (count == years) {
                    return penguin;
                }
                xx++;

            }
            return penguin;


    }

    public static int penguSum(int penguin) {
        String length = String.valueOf(penguin);
        int sum = 0;
        int number;
        for (int i = 0; i < length.length(); i++) {
            number=penguin % 10;
            penguin=penguin/10;
            sum+=number;


        }
        return sum;
    }

    public static long penguPermutation(long n, long k) {
        double nominator=1;
        double denominator=1;
        long x=n;
        long y=k;

        for (int i = 0; i < x; i++) {
            nominator=nominator * n;
            n=n-1;
            
        }

        for (int i = 0; i < y; i++) {
            denominator=denominator * k;
            k=k-1;

        }
        long number= (long) (nominator/denominator);
        // TODO
        return number;
    }

    public static long penguPowers(int x, int i) {
        long number;
        long power;

        if(i==0){
            return 1;
        }

        if(i==1){
            return x;
        }
        if(x>0) {
            number =x;

            for (int j = 1; j < i; j++) {
                power = number;
                for (int k = 1; k < x; k++) {
                    number += power;
                }

            }
        }else{
            x=-x;
            number =x;

            for (int j = 1; j < i; j++) {
                power = number;
                for (int k = 1; k < x; k++) {
                    number += power;
                }
            }
                if (i % 2 != 0) {
                   return -number;
                }




        }


        return number;
    }

    /*	Die Inhalte der main()-Methode beeinflussen nicht die Bewertung dieser Aufgabe
     *	(es sei denn natürlich, sie verursachen Compiler-Fehler).
     */
    public static void main(String[] args){

        // Here is a place for you to play around :)
        //System.out.println(penguPowers(-2,3));
       // penguInfoOut(1);

       // System.out.println(penguPermutation(500000000000001L,500000000000000L));
        System.out.println(penguEvolution(32,10));
    }

}
