package pgdp.robot;

import static pgdp.PinguLib.write;

public class Wheels {

    private int speed;

    public Wheels(int speed) {
        this.speed = speed;
    }

    public void drive(int distance) {
        write("Der Pinguroboter fährt " + distance + " m.");
    }

    public void steer(int direction) {
        write("Der Pinguroboter richtet sich auf "+ direction + " Grad aus.");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
