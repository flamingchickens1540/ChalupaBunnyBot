package org.usfirst.frc.team1540.robot;

/*
 * Robot Utilities by @author Nate Sales
 */

public class Utils {
	
	public static double deadzone(double value) {
		if(Math.abs(value) <= 0.2) {
			return 0;
		}else { 
			return value;
		}
	}
	
	
}
