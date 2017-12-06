package org.usfirst.frc.team1540.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

/*
 * Button Mapping
 * X: 3
 * Y: 4
 * A: 1
 * B: 2
 * Back: 7
 * Start: 8
 * LB: 5
 * RB: 6
 * Right joystick center: 9
 * Left joystick center: 10
 * 
 * Axis Mapping:
 * Left analog trigger: 2 (Only positive)
 * Right analog trigger: 3 (Only positive)
 * 
 * Left joystick:
 * Up/Down: 1 (Up is negative)
 * Left/Right: 0 (Left is negative)
 * 
 * Right joystick:
 * Up/Down: 5 (Up is negative)
 * Left/Right: 4 (Left is negative)
 */

public class OI {
	
	private static final int rightJoystickUpDown = 5;
	private static final int rightJoystickLeftRight = 4;
	
	private static final int leftJoystickUpDown = 1;
	private static final int leftJoystickLeftRight = 0;
	
	private static final int intakeRevButton = 2;//B
	private static final int intakeStartButton = 4;//Y
	
	private static final int shiftingButton = 6; //Right Bumper
	
	
	private static final int ArmUpButtonNumber = 3; //X
	private static final int ArmDownButtonNumber = 4; //Y
	
	private static final int leftTrigger = 3;
	private static final int rightTrigger = 2;
	
	/* CONTROLS
	 * 
	 * Co-Pilot:
	 * Intake (Hold to spin): Y
	 * Intake Rev (Hold to spin): B
	 * 
	 * Rotate Arm: left thumbstick
	 */
	
	public static Joystick driver = new Joystick(0);
	public static Joystick copilot = new Joystick(1);

	static Button intake_rev = new JoystickButton(copilot, intakeRevButton);
	static Button intake = new JoystickButton(copilot, intakeStartButton);
	static Button shift = new JoystickButton(driver, shiftingButton);

	static Button armUpButton = new JoystickButton(copilot, ArmUpButtonNumber);
	static Button armDownButton = new JoystickButton(copilot, ArmDownButtonNumber);

	public static double getDriverLeftStickUpDown() {
		return driver.getRawAxis(leftJoystickUpDown);
	}
	
	public static double getDriverLeftStickLeftRight() {
		return driver.getRawAxis(leftJoystickLeftRight);
	}
	
	public static double getDriverRightStickUpDown() {
		return driver.getRawAxis(rightJoystickUpDown);
	}
	
	public static double getDriverRightStickLeftRight() {
		return driver.getRawAxis(rightJoystickLeftRight);
	}


	//Copilot Axis

	public static double getCopilotLeftStickUpDown() {
		return copilot.getRawAxis(leftJoystickUpDown);
	}
	
	public static double getCopilotLeftStickLeftRight() {
		return copilot.getRawAxis(leftJoystickLeftRight);
	}
	
	public static double getCopilotRightStickUpDown() {
		return copilot.getRawAxis(rightJoystickUpDown);
	}
	
	public static double getCopilotRightStickLeftRight() {
		return copilot.getRawAxis(rightJoystickLeftRight);
	}
	
	//Pilot Triggers
	
	public static double getDriverLeftTrigger() {
		return driver.getRawAxis(leftTrigger);
	}

	public static double getDriverRightTrigger() {
		return driver.getRawAxis(rightTrigger);
	}

	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
