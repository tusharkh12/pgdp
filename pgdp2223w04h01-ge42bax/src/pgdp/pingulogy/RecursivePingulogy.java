package pgdp.pingulogy;


public class RecursivePingulogy {
    static long n_0;
    static long n_1;
    static long n_2;
    static int ZE = 0;

    private static long n_3;

    static String answer = "";


    // task 1
    public static long pinguSequenceRec(int n, int p0, int p1, int p2) {
        if (n > 145 || n < -122) {
            return -1;
        }
        if (p0 == 0 && p1 == 0 && p2 == 0) {
            return 0;
        }
        if (n < 0) {
            return 2 * pinguSequenceRec(-n, p0, p1, p2);
        } else {
            if (n == 0) {
                return p0;
            } else if (n == 1) {
                return p1;
            } else if (n == 2) {
                return p2;
            }
                n_0 = p0;
                n_1 = p1;
                n_2 = p2;
                n_3 = n_2 - n_1 + (2 * n_0);
                //return value;
                return helperForPinguSequenceRec(n-3);
                //long value = pinguSequenceRec(n - 1, p0, p1, p2) - pinguSequenceRec(n - 2, p0, p1, p2) + 2 * pinguSequenceRec(n - 3, p0, p1, p2);
            }
        }

        public static long helperForPinguSequenceRec(int n){
        if (n == 0){
            return n_3;
        }else {
            n_0 = n_1;
            n_1 = n_2;
            n_2 = n_3;
            n_3 = n_2 - n_1 + (2 * n_0);
            return helperForPinguSequenceRec(n-1);
        }
        }



    // task 2
    // Hint: pinguF and pinguM are not static (and must not be changed to it!)
    // more information in the main-method below
    public int pinguF(int n) {
        int value;
        if (n == 0) {
            value = 1;
        } else {
            value = n - pinguM(pinguF(n - 1));
        }
        // TODO
        return value;
    }

    public int pinguM(int n) {
        int value;
        if (n == 0) {
            value = 0;
        } else {
            value = n - pinguF(pinguM(n - 1));
        }
        // TODO
        return value;
    }


    //HELPER FOR PINGU CODE
    public static int helperForPinguCode(int n, int m, int i) {

        int variable;
        if (n == 0) {
            return m + ZE;
        } else {
            if ((n + ZE) % 2 == 0) {
                variable = m;
                m = (int) Math.floor(n / 2);
                n = variable;
                ZE = ZE + m;

                return helperForPinguCode(n, m, ZE);
            } else {
                ZE = ZE + m;
                n = n - 1;
                m = (int) Math.floor(m / 2);
                return helperForPinguCode(n, m, ZE);

            }
            // return m + i;


        }
        //


        // TODO
        //  i=i+m;

    }

    // task 3
    public static int pinguCode(int n, int m) {
        ZE = 0;
        return helperForPinguCode(n, m, ZE);

        //int result;
//        int variable;
//        if (n == 0) {
//            return m + ZE;
//        } else {
//            if ((n + ZE) % 2 == 0) {
//                variable = m;
//                m = (int) Math.floor(n / 2);
//                n = variable;
//                ZE = ZE + m;
//
//             return   pinguCode(n,m);
//            } else {
//                ZE = ZE + m;
//                n = n - 1;
//                m = (int) Math.floor(m / 2);
//              return   pinguCode(n,m);
//
//            }
//           // return m + i;
//
//
//        }
//        //


    }


    // task 4
    public static String helperForPinguDNA(int f, int m) {
        char[] f_Binary = Integer.toBinaryString(f).toCharArray();
        char[] m_Binary = Integer.toBinaryString(m).toCharArray();


        if (m == 0 && f == 0) {
            return answer;
        } else if (m == 0 || f == 0) {
            if (m == 0) {
                answer = "T" + answer;
                helperForPinguDNA(f / 2, m);
            } else {
                answer = "A" + answer;
                helperForPinguDNA(f, m / 2);
            }
        } else if (f_Binary[f_Binary.length - 1] == m_Binary[m_Binary.length - 1]) {
            if (f > m) {
                answer = "GT" + answer;
                //pinguDNA(f/2,m/2);
            } else if (f < m) {
                answer = "GA" + answer;
                //pinguDNA(f/2,m/2);
            } else {
                answer = "GC" + answer;
                //  pinguDNA(f/2,m/2);
            }
            helperForPinguDNA(f / 2, m / 2);

        } else {
            if (f_Binary[f_Binary.length - 1] == '1') {
                answer = "TC" + answer;
            } else {
                answer = "AC" + answer;
            }
            helperForPinguDNA(f / 2, m / 2);
        }
        return answer;
    }

    public static String pinguDNA(int f, int m) {
        answer = "";
        return helperForPinguDNA(f, m);
//        char[] f_Binary = Integer.toBinaryString(f).toCharArray();
//        char[] m_Binary = Integer.toBinaryString(m).toCharArray();
//
//
//        if (m == 0 && f == 0) {
//            return answer;
//        }
//        else if(m==0 || f==0) {
//            if (m == 0) {
//                answer = "T" + answer;
//            pinguDNA(f / 2, m);
//            } else {
//                answer = "A" + answer;
//               pinguDNA(f, m / 2);
//            }
//        }
//            else if (f_Binary[f_Binary.length-1] == m_Binary[m_Binary.length-1]) {
//                if(f>m){
//                    answer="GT"+answer;
//                    //pinguDNA(f/2,m/2);
//                } else if (f<m) {
//                    answer="GA"+answer;
//                    //pinguDNA(f/2,m/2);
//                }else {
//                    answer="GC"+answer;
//                  //  pinguDNA(f/2,m/2);
//                }
//               pinguDNA(f/2,m/2);
//
//        }
//            else {
//                if(f_Binary[f_Binary.length-1]=='1' ){
//                    answer="TC"+answer;
//                }else {
//                    answer="AC"+answer;
//                }
//                pinguDNA(f/2,m/2);
//        }
//        return answer;

    }
    // TODO


    public static void main(String[] args) {
        // switch value to test other tasks
        int testTask =  1;
        //System.out.println(pinguSequenceRec(4,1,1,2));
//        int f = 25;
//        char[] a = (Integer.toBinaryString(f / 8)).toCharArray();
//        //f=f/2;
//        System.out.println(a);
//        if (a[a.length-1]=='1') {
//            System.out.println("happy");
//    }


        // System.out.println(pinguCode(1, 3));

        switch (testTask) {
            case 1 -> {
                System.out.println("Task 1 example output");
                for (int i = 0; i < 145; i++) {
                    System.out.println(i + ": " + pinguSequenceRec(i, 1, 1, 2));
                }
            }
            case 2 -> {
                /**
                 * For better testing, pinguF and pinguM are not static.
                 * Hence, you have to initialize a new RecursivePingulogy Object and
                 * call the methods on that instance, as you can see below.
                 * You will learn more about object-oriented-programming in the lecture
                 * and week 05+.
                 */
                RecursivePingulogy rp = new RecursivePingulogy();
                System.out.print("Task 2 example output\npinguF: ");
                for (int i = 0; i < 10; i++) {
                    System.out.print(rp.pinguF(i) + ", ");
                }
                System.out.print("\npingM: ");
                for (int i = 0; i < 10; i++) {
                    System.out.print(rp.pinguM(i) + ", ");
                }
            }
            case 3 -> {
                System.out.println("Task 3 example output");
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(i + ", " + j + ": " + pinguCode(i, j));
                    }
                    System.out.println("----------");
                }
            }
            case 4 -> {
                System.out.println("Task 4 example output");
                System.out.println("pinguDNA(21, 25) = " + pinguDNA(21, 25));
            }
            default -> System.out.println("There are only 4 tasks!");
        }
    }
}
