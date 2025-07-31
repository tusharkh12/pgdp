package pgdp.penguins;

public class KingPenguin extends Penguin {
     private int numberCastles;


     public KingPenguin(int age , String name, int numberCastles){
          super(age,name);
          this.numberCastles = numberCastles;

     }

     public int getNumberCastles(){
          return numberCastles;
     }

     @Override
     public String getName(){
          return "König(in) " + super.getName();
     }

     public String toString(){
          return super.toString() + " Sein/Ihr Reich umfasst " + numberCastles + " Anwesen.";
     }


}
