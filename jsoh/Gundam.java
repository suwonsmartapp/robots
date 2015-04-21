package jsoh;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Gundam extends Robot {
	@Override
	public void run() {
		while(true) {
			turnRight(90);
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(2);
	}
}
