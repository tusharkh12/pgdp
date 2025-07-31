package pgdp.robot;

import static pgdp.PinguLib.write;

public class FishStorage {

    private int numberOfFish = 0;

    public void storeFish() {
        write("Es wurde ein Fisch eingelagert.");
        numberOfFish += 1;
    }

    public int emptyFish() {

        int returnVal = numberOfFish;
        write("Das Fischlager wird geleert.");
        numberOfFish = 0;
        return returnVal;
    }

    public int getNumberOfFish() {
        return numberOfFish;
    }

    public void setNumberOfFish(int numberOfFish) {
        this.numberOfFish = numberOfFish;
    }
}