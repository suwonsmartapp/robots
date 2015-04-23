package jsoh;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import sampleteam.RobotColors;

public class JsOh extends AdvancedRobot {
	@Override
	public void run() {
		
		init();
		
		while (true) {
			setAhead(40000);
			setTurnRight(90);
			execute();
		}
	}
	
	private void init() {
		RobotColors colors = new RobotColors();
		colors.bodyColor = Color.BLACK;
		colors.gunColor = Color.YELLOW;
		colors.radarColor = Color.GREEN;
		colors.bulletColor = Color.YELLOW;
		colors.scanColor = Color.CYAN;
		
		setColors(colors.bodyColor,
				colors.gunColor,
				colors.radarColor,
				colors.bulletColor,
				colors.scanColor);
	}
	
	Random random = new Random();
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		if (getEnergy() > 50) {
			double power = random.nextDouble() * 3;
			fire(power);
		} else {
			fire(1);
		}
	}
	
	@Override
	public void onHitRobot(HitRobotEvent event) {
		setAhead(100);
		setTurnLeft(60);
		execute();
	}
	
	@Override
	public void onHitWall(HitWallEvent event) {
	}
}
