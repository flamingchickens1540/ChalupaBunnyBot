package org.usfirst.frc.team1540.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1540.robot.Robot;

public class ShiftTrue extends Command {
	boolean isItDoneYet = false;
	
	public ShiftTrue() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shifter); //The object initialized in robot.java
		//requires(Robot.led);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shifter.on();
		System.out.println("Shifter: True");
		//Robot.led.on();
		isItDoneYet = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isItDoneYet;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
