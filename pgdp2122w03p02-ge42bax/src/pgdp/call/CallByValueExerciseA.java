package pgdp.call;

public class CallByValueExerciseA {

    public static void main(String[] args) {
        foo();
    }

    // Was tut folgender Code? Erkläre das Ergebnis.
    public static void foo() {
        int n = 1;
        A a1 = new A(1);
        A a2 = new A(1);

        setNumber(n);
        setAttribute(a1);
        setObject(a2);

        System.out.println(n);
        System.out.println(a1.n);
        System.out.println(a2.n);
    }

    static void setNumber(int n) {
        n = 2;
    }
    static void setAttribute(A a) {
        a.n = 2;
    }
    static void setObject(A a) {
        a = new A(2);
    }
}

class A {
    int n;

    public A(int n) {
        this.n = n;
    }
}
