package pgdp.saleuine2;

public class Crustacean extends PinguFood {

    public Crustacean(int weight){
        super(0,weight);


    }


    public  boolean isEdible(){
        return true;
    }

    public String toString(){
        return  "Krill("+ getWeight()  + "g)";
    }

}
