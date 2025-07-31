package pgdp.saleuine2;

public class Sardine extends  PinguFood {

    private static final int MIN_AGE = 1;
    private static final int MIN_WEIGHT = 100;
    private static final int MIN_LENGTH = 14;
    private int length;

    public Sardine(int age, int weight, int length) {
        super(age, weight);
        this.length = length;
    }

    public int getLength() {
        return length;
    } //???

    public static int getMinAge() {
        return MIN_AGE;
    }

    public static int getMinWeight() {
        return MIN_WEIGHT;
    }

    public static int getMinLength() {
        return MIN_LENGTH;
    }




    public  boolean isEdible(){
        if(super.getAge()>=MIN_AGE && super.getWeight()>= MIN_WEIGHT && this.length >= MIN_LENGTH){
            return true;
        }

        return false;
    }


    public String toString() {
        return "Sardine(Alter: " + getAge() + " Jahre, Gewicht: " + getWeight() + ", Länge: " + getLength();

    }
}


