package pgdp.robot;

import static pgdp.PinguLib.write;

public class Robot {
    private String name;

    private Wheels wheels;
    private FishingRod fishingRod;
    private FishStorage fishStorage;

    public Robot(String name, int speed, String bait) {

        this.name = name;

        this.wheels = new Wheels(speed);
        this.fishingRod = new FishingRod(bait);
        this.fishStorage = new FishStorage();

        write("Der Pinguinroboter mit dem Namen " + name + " wurde initialisiert.");
    }

    public void move(int direction, int distance) {

        wheels.steer(direction);
        wheels.drive(distance);
    }

    public void fish() {

        fishingRod.reelOut();
        fishingRod.reelIn();

        fishStorage.storeFish();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public FishingRod getFishingRod() {
        return fishingRod;
    }

    public void setFishingRod(FishingRod fishingRod) {
        this.fishingRod = fishingRod;
    }

    public FishStorage getFishStorage() {
        return fishStorage;
    }

    public void setFishStorage(FishStorage fishStorage) {
        this.fishStorage = fishStorage;
    }

}
