package pgdp.robot;

import static pgdp.PinguLib.write;

public class FishingRod {
    private String bait;

    public FishingRod(String bait) {
        this.bait = bait;
    }

    public void reelOut() {
        write("Der Pinguroboter wirft die Angel aus.");
        write("Es wird folgender Köder benutzt: " + bait);
    }

    public void reelIn() {
        write("Der Pinguroboter holt die Angel wieder ein.");
        write("Es wurde ein Fisch gefangen.");
    }

    public String getBait() {
        return bait;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }


}
