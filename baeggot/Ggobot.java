package baeggot;

import robocode.AdvancedRobot;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;

public class Ggobot extends AdvancedRobot {
	
	private boolean forward = true;
	
	
	@Override
	public void run() {
		while(true) {
			setAhead(40000);
			setTurnRight(90); // 방향 돌리기
			setTurnGunRight(10); // 총돌리기
			//setTurnRadarRight(10); // 레이더 돌리기
			execute();
			//waitFor(new TurnCompleteCondition(this));
		}
	}
	
	/*
		적이 내 레이더망에 들어왔다
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		// float : 0.1 ~ 3.0
		// 나도 에너지가 닳아진다...?
		fire(1.5);
	}
	
	/*
		벽에 붙었을 때
	 */
	@Override
	public void onHitWall(HitWallEvent event) {
		if (forward == true) {
			back(40000);
			forward = false;
		} else {
			ahead(40000);
			forward = true;
		}
	}
	
	/*
		내 로봇이 적을 쐈을 때
	 */
	@Override
	public void onHitRobot(HitRobotEvent event) {
		
		
	}
	
	/*
		로봇 맞췄을 때
	 */
	@Override
	public void onBulletHit(BulletHitEvent event) {

	}
	
	/*
		미사일이 빗나갔을 때
	 */
	@Override
	public void onBulletMissed(BulletMissedEvent event) {

	}
	
	
	
}
