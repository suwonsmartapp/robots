package jsoh;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;
import sampleteam.RobotColors;

public class JsOh extends AdvancedRobot {
	@Override
	public void run() {

		init();

		while (true) {
			move();
			execute();
		}
	}

	private void move() {
		double distance = Math.random() * 40;
		if (distance % 2 == 0) {
			setAhead(distance);
		} else {
			setBack(distance);
		}
		setTurnRight(90);
	}

	private void init() {
		RobotColors colors = new RobotColors();
		colors.bodyColor = Color.BLACK;
		colors.gunColor = Color.YELLOW;
		colors.radarColor = Color.GREEN;
		colors.bulletColor = Color.YELLOW;
		colors.scanColor = Color.CYAN;

		setColors(colors.bodyColor, colors.gunColor, colors.radarColor, colors.bulletColor, colors.scanColor);
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		setTurnRight(event.getBearing());
		setAhead(event.getDistance() + 5);

		fire(3);

		scan();
	}

	@Override
	public void onHitRobot(HitRobotEvent event) {
		if (event.getEnergy() > 16) {
			fire(3);
		} else if (event.getEnergy() > 10) {
			fire(2);
		} else if (event.getEnergy() > 4) {
			fire(1);
		} else if (event.getEnergy() > 2) {
			fire(.5);
		} else if (event.getEnergy() > .4) {
			fire(.1);
		}
		setBack(40);
	}

}
