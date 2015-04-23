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
	   turnGunRight(360); // 대포 오른쪽으로 360도 회전
	   fire(getEnergy());
		turnRight(90);
		setAdjustGunForRobotTurn(true);
		
	 }
	}
	 
	
	 // 적을 발견되면
	 public void onScannedRobot(ScannedRobotEvent e){
	  // 거리가 짧으면 강하게 발사
	  if (e.getDistance() < 20) {
	   fire(3);
	  } else
	  { fire(1);
	  }
	 }
	 // 우리가 포를 맞으면
	 public void onHitByBullet(HitByBulletEvent e) {
	  turnLeft(90);  // 탱크 왼쪽 90도로 꺽기
	  ahead(100);   // 탱크 전진
	 }
	
	
	@Override
	public void onMouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void ahead(double distance) {
		
	}
	
	@Override
	public void back(double distance) {
		
	}
	

	
	

}
