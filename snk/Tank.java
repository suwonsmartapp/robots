package snk;

import java.awt.event.MouseEvent;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Tank extends Robot {
	@Override
	public void run() {
		while (true) {
			turnRight(90);
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(1);
	}
	
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		
	}
	
	@Override
	public void onHitWall(HitWallEvent event) {
		
	}
	
	@Override
	public void onMouseClicked(MouseEvent e) {
		
	}

}
