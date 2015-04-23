package baeggot;

import robocode.BulletMissedEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Ggobot extends Robot {
	@Override
	public void run() {
		while(true) {
			turnRight(90);
		}
	}
	
	/*
	 * 적이 내 레이더망에 들어왔다
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		// float : 0.1 ~ 3.0
		// 나도 에너지가 닿아진다...?
		fire(1);
			
	}
	
	/*
		벽에 붙었을 때
	 */
	@Override
	public void onHitWall(HitWallEvent event) {
		// TODO Auto-generated method stub
		super.onHitWall(event);
	}
	
	@Override
	public void onHitRobot(HitRobotEvent event) {
		// TODO Auto-generated method stub
		super.onHitRobot(event);
	}
	
	@Override
	public void onBulletMissed(BulletMissedEvent event) {
		// TODO Auto-generated method stub
		super.onBulletMissed(event);
	}
	
	
	
}
