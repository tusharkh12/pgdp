package pgdp.robot;

import static pgdp.PinguLib.write;

public class Main {

	public static void main(String[] args) {


		//Die Pinguine erstellen einen neuen Roboter namens Johannes.
		//Es wird eine Made als Köder benutzt.
		Robot robot = new Robot("Johannes", 10, "Made");

		//Der Roboter wird an seine Angelstelle geschickt
		robot.move(10,0);

		//Der Roboter soll 3 mal fischen
		robot.fish();
		robot.fish();
		robot.fish();

		//Der Roboter soll zurück kommen
		robot.move(10,180);

		//Die Pinguine entleeren den Roboter.
		int fish = robot.getFishStorage().emptyFish();
		write(robot.getName() + " hat " + fish + " Fische gefangen.");
	}

}
