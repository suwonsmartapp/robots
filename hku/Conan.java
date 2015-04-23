package hku;

import robocode.HitByBulletEvent;
import robocode.JuniorRobot;

public class Conan extends JuniorRobot {
	int turnDirection = 1; // Clockwise or counterclockwise
	boolean movingForward;
	
	@Override
	public void run() {
		
		// Set colors
		movingForward = true;
//		setBodyColor(new Color(255, 125, 0));
//		setGunColor(new Color(59, 59, 59));
//		setRadarColor(new Color(0, 0, 0));
//		setBulletColor(new Color(255, 0, 0));
//		setScanColor(new Color(255, 255, 128));
				
		while(true) {
			ahead(100); // Move ahead 100
			turnLeft(100);
			turnGunRight(360); // Spin gun around
			back(100); // Move back 100
			turnRight(100);
			turnGunRight(360); // Spin gun around
			/*
			ahead(1000);
			turnGunRight(20);
			
			ahead(100);			
			turnLeft(100);
			
			ahead(100);
			turnGunLeft(20);
			
			ahead(100);			
			turnRight(100);
			
			turnGunRight(90);
			turnLeft(30);
			ahead(30);
			turnGunLeft(120);
			*/
			
		}
	}
	
	// 레이더 감지
	@Override
	public void onScannedRobot() {
		movingForward = false;
		turnGunTo(scannedAngle);

		// Fire!
		fire(1);
	}
	
	// 총알에 맞았을때
	public void onHitByBullet(HitByBulletEvent e) {
		movingForward = true;
		reverseDirection();
	}
	
	// 다른 로봇과 부딪혔을때
	@Override
	public void onHitRobot() {
		movingForward = true;
		turnAheadLeft(100, 90 - hitByBulletBearing);
	}
	
	// 벽에 부딪혔을때
	@Override
	public void onHitWall() {
		reverseDirection();
	}
	
	public void reverseDirection() {
		if (movingForward) {
			turnLeft(30);
			back(200);
			turnRight(60);
			ahead(100);
			turnGunLeft(90);
			movingForward = false;
		} else {
			turnRight(90);
			ahead(200);
			turnLeft(30);
			back(100);
			turnGunRight(90);
			movingForward = true;
		}
	}

	

}
