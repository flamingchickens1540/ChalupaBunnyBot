package org.usfirst.frc.team1540.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int intakeTalonNumber = 7;
	public static final int armMoveNumber = 8;
	
	public static final int left1 = 1; //Left drive train TALON numbers
	public static final int left2 = 2;
	
	public static final int right1 = 3; //Right drive train TALON numbers
	public static final int right2 = 4;
	
	public static final int noid = 5;
	public static final int shifting_noid = 9;

	public static final int intake = 6;
}
