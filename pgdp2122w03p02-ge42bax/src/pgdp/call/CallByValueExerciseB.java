package pgdp.call;

public class CallByValueExerciseB{

    public static void main(String[] args) {
        foo();
    }


    public static void foo() {
        int a = 7;
        int b = 4;
        sumAndDifference(a, b);
        System.out.println("a == " + a);
        System.out.println("b == " + b);
    }

    public static void fooAlt1() {
        IntWrapper a = new IntWrapper(7);
        IntWrapper b = new IntWrapper(4);
        sumAndDifferenceAlt1(a, b);
        System.out.println("a == " + a);
        System.out.println("b == " + b);
    }

    public static void fooAlt2() {
        int a = 7;
        int b = 4;
        TwoInts ti = sumAndDifferenceAlt2(a, b);
        a = ti.n1;
        b = ti.n2;
        System.out.println("a == " + a);
        System.out.println("b == " + b);
    }


    public static void sumAndDifference(int a, int b) {
        int tmp = a;
        a = a + b;
        b = tmp - a;
    }


    public static void sumAndDifferenceAlt1(IntWrapper a, IntWrapper b) {
        int tmp = a.content;
        a.content = a.content + b.content;
        b.content = tmp - b.content;
    }


    public static TwoInts sumAndDifferenceAlt2(int a, int b) {
        return new TwoInts(a + b, a - b);
    }
}

class IntWrapper {
    int content;
    public IntWrapper(int content) {
        this.content = content;
    }
    public String toString() {
        return "" + content;
    }
}

class TwoInts {
    int n1;
    int n2;
    public TwoInts(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}