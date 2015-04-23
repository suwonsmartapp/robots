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
		c.bulletColor = Color.red;

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
		movingForward = true;
		reverseDirection();
	}
	
	// 다른 로봇과 부딪혔을때
	@Override
	public void onHitRobot(HitRobotEvent event) {
		movingForward = false;
		reverseDirection();
	}
	
	// 벽에 부딪혔을때
	@Override
	public void onHitWall(HitWallEvent event) {
		movingForward = false;
		reverseDirection();
	}
		
	
	
	public void reverseDirection() {
		if (movingForward) {
			setTurnLeft(30);
			setBack(200);
			setTurnGunLeft(90);
			movingForward = false;
		} else {
			setTurnRight(90);
			setAhead(200);
			setTurnGunRight(90);
			movingForward = true;
		}
	}
	

}
