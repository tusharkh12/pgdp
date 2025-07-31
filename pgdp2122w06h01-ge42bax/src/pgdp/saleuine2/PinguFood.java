package pgdp.saleuine2;

public class PinguFood {

    private int age;
    private int weight;


    public PinguFood(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public boolean isEdible() {
//        if (this instanceof Anchovie) {
//           // if (this.getAge() >= ((Anchovie) this).getMinAge() &&
//             //       this.getWeight() >= ((Anchovie) this).getMinWeight()) {
//                return this.getAge() >= ((Anchovie) this).getMinAge() &&
//                        this.getWeight() >= ((Anchovie) this).getMinWeight();
//            }
//
//
//        else if (this instanceof Crustacean) {
//            return true;
//        }
//        else if(this instanceof Sardine) {
////            if(this.getAge()>=((Sardine)this).getMinAge() && getWeight()>= ((Sardine)this).getMinWeight() &&
////                    ((Sardine)this).getLength() >=((Sardine)this).getMinLength()){
//
//            return this.getAge() >= ((Sardine) this).getMinAge() && getWeight() >=
//                    ((Sardine) this).getMinWeight() && ((Sardine) this).getLength() >= ((Sardine) this).getMinLength();
//        }
//        else {
            return false;
        }


    public String toString() {
//        if (this instanceof Anchovie) {
//            return "Sardelle(Alter: " + this.getAge() + " Jahre, Gewicht: " + this.getWeight() + "g)";
//        } else if (this instanceof Crustacean) {
//            return  "Krill("+ this.getWeight()  + "g)";
//
//        } else if (this instanceof Sardine) {
//            return "Sardine(Alter: " + this.getAge() + " Jahre, Gewicht: " + getWeight() + ", Länge: " + ((Sardine) this).getLength();  //why ??
//
//
//        } else {
            return "Älter: " + this.age + " Jahre, Gewicht: " + this.weight + "g";
        }



    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

//    public static void main(String[] args){
//        PinguFood p = new PinguFood(1,30);
//       // System.out.println(p);
//        PinguFood q = new PinguFood(2, 30);
//
//    }

}

