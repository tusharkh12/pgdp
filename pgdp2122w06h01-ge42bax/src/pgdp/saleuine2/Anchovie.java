package pgdp.saleuine2;

public class Anchovie extends PinguFood {

    private static final int MIN_AGE = 1;
    private static final int MIN_WEIGHT = 5;

    public Anchovie(int age, int weight) {
        super(age, weight);
    }

    public static int getMinAge() {
        return MIN_AGE;
    }

    public static int getMinWeight() {
        return MIN_WEIGHT;
    }



    public  boolean isEdible(){
        if(super.getAge()>=MIN_AGE && super.getWeight()>= MIN_WEIGHT){
            return true;
        }

        return false;
    }

    public String toString(){
        return "Sardelle(Alter: "+getAge()+ " Jahre, Gewicht: "+getWeight()+"g)";
    }

}
