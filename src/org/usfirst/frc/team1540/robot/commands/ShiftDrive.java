package org.usfirst.frc.team1540.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1540.robot.Robot;

public class ShiftDrive extends Command {
	public ShiftDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shifter); //The object initialized in robot.java
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shifter.shift();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
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
