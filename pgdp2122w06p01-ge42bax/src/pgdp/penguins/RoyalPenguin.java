package pgdp.penguins;

public class RoyalPenguin extends Penguin {
    private String heroicDeed;

    public RoyalPenguin(int age, String name, String heroicDeed) {
        super(age, name);
        this.heroicDeed = heroicDeed;
    }

    @Override
    public String getName() {
        return "Sir/Lady " + super.getName();
    }

    @Override
    public String toString() {
        return super.toString() + " Durch diese Heldentat ist er/sie bekannt: " + heroicDeed;
    }
}