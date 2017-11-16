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
	
	//Controller Numbers
	private static final int rightAxisY = 5;
	private static final int leftAxisY = 1;
	
	private static final int armOpenButton = 3;
	private static final int armCloseButton = 1;
	
	private static final int intakeRevButton = 2;
	private static final int intakeStartButton = 4;
	
	private static final int shiftingButton = 6;
	
	/* CONTROLS
	 * 
	 * Co-Pilot:
	 * Arm open: X
	 * Arm close: A
	 * Intake start: Y
	 * Intake stop: B
	 */
	
	public static Joystick driver = new Joystick(0);
	public static Joystick copilot = new Joystick(1);
	
	static Button arm_close = new JoystickButton(copilot, armCloseButton);
	static Button intake_rev = new JoystickButton(copilot, intakeRevButton);
	static Button arm_open = new JoystickButton(copilot, armOpenButton);
	static Button intake_start = new JoystickButton(copilot, intakeStartButton);
	static Button shift = new JoystickButton(driver, shiftingButton);
	
	public static double getRightAxis() {
		return driver.getRawAxis(rightAxisY);
	}
	
	public static double getLeftAxis() {
		return driver.getRawAxis(leftAxisY);
	}
	
	public static double CoPilotgetRightAxis() {
		return copilot.getRawAxis(rightAxisY);
	}
	
	public static double CoPilotgetLeftAxis() {
		return copilot.getRawAxis(leftAxisY);
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
