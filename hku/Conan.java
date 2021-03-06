package hku;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import sampleteam.RobotColors;


public class Conan extends AdvancedRobot {
	boolean movingForward;
	/**
	 * run:  Leader's default behavior
	 */
	public void run() {
		movingForward = true;
		// Prepare RobotColors object
		RobotColors c = new RobotColors();

		c.bodyColor = Color.orange;
		c.gunColor = Color.black;
		c.radarColor = Color.magenta;
		c.scanColor = Color.yellow;
		c.bulletColor = Color.yellow;

		// Set the color of this robot containing the RobotColors
		setBodyColor(c.bodyColor);
		setGunColor(c.gunColor);
		setRadarColor(c.radarColor);
		setScanColor(c.scanColor);
		setBulletColor(c.bulletColor);


		while (true) {
			setTurnLeft(50);
			setAhead(500);
			setTurnGunRight(15);
			
			execute();
		}
	}

	// 레이더에 포착시
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(1);
	}
	
	// 총알에 맞았을때
	public void onHitByBullet(ScannedRobotEvent event) {
//		movingForward = false;
//		reverseDirection();
	}
	
	// 다른 로봇과 부딪혔을때
	@Override
	public void onHitRobot(HitRobotEvent event) {
		movingForward = true;
		reverseDirection();
	}
	
	// 벽에 부딪혔을때
	@Override
	public void onHitWall(HitWallEvent event) {
		movingForward = true;
		reverseDirection();
	}
		
	
	
	public void reverseDirection() {
		if (movingForward) {
			movingForward = false;
			turnRight(200);
			ahead(-100);
		} else {
			movingForward = true;
			turnLeft(200);
			back(-100);
		}
	}
	

}
