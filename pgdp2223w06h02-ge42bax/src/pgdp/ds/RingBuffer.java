package pgdp.ds;

import java.util.Arrays;

public class RingBuffer {

    private int[] mem;
    private int in;
    private int out;
    private int stored;

    RingBuffer(int capacity) {
        mem = new int[capacity];
        in = 0;
        out = 0;
        stored = 0;
    }

    public boolean isEmpty() {
        if (mem.length == 0) {
            return true;
        }

        for (int i = 0; i < mem.length; i++) {
            if (mem[i] != 0) {
                return false;
            }

        }
        return true;

//        if (in == 0 && out == 0 && mem==null) {
//            return true;
//        }
//        return false;
    }

    public boolean isFull() {
//        for (int i = 0; i < mem.length; i++) {
//            if (mem[i] == 0) {
//                return false;
//            }
//        }
//        return true;
        if (mem.length == 0) {
            return true;
        }
        if (mem[in % mem.length] != 0 || in >= mem.length) {
            if ((in % mem.length) == ((out) % mem.length)) {
                return true;
            }
        }

        return false;
    }

    public boolean put(int value) {
        if (isFull()) {
            return false;
        }
        mem[in % mem.length] = value;
        in++;
        stored++;
        return true;
    }

    public int get() {
        if(out>= mem.length && out% mem.length==0){
            return Integer.MIN_VALUE;
        }
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int a = mem[out % mem.length];
        // mem[out % mem.length] = 0;
        out++;
        stored--;
        return a;
    }

    // TODO implement missing methods

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RingBuffer := { capacity = ").append(mem.length).append(", out = ").append(out).append(", in = ").append(in).append(", stored = ").append(stored).append(", mem = ").append(Arrays.toString(mem)).append(", buffer = [");
        if (!isEmpty()) {
            if (in >= 0 || in < mem.length) {
                int i = out;
                do {
                    sb.append(mem[i]).append(", ");
                    i = (i + 1) % mem.length;
                } while (i != in);
                sb.setLength(sb.length() - 2);
            } else {
                sb.append("Error: Field 'in' is <").append(in).append(">, which is out of bounds for an array of length ").append(mem.length);
            }
        }
        sb.append("] }");
        return sb.toString();
    }

    public static void main(String[] args) {
        RingBuffer rb = new RingBuffer(100);
      //  12, 13, 14, 15, 16, 6, 7, 8, 10, 11
        rb.put(12);
        rb.put(13);
        rb.put(14);
        rb.put(15);
        rb.put(16);
        rb.put(6);
        rb.put(7);
        rb.put(8);
        rb.put(10);
        rb.put(11);
        rb.put(12);
        rb.put(13);
        rb.put(14);
        rb.put(15);
        rb.put(16);
        rb.put(6);
        rb.put(7);
        rb.put(8);
        rb.put(10);
        rb.put(11);
        System.out.println(rb.in);


       // System.out.println(rb.get());
      //  System.out.println(rb.toString());
       // System.out.println(rb.put(3));
       // System.out.println(rb);
        //System.out.println(rb.isEmpty());
        //final var rb = createRB(2);

       // System.out.println(rb);


    }
}
