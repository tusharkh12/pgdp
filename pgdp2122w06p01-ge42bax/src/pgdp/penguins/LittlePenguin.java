package pgdp.penguins;

public class LittlePenguin extends Penguin {
    private int height;


    public LittlePenguin(int age , String name ,int height){
        super(age,name);
        this.height = height;

    }

    public int getHeight(){
        return height;
    }

    @Override
    public String toString(){
        return  super.toString()+ " Er/Sie ist leider nur "+ height+  "cm groß.";
    }


}
