package org.usfirst.frc.team1540.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1540.robot.Robot;
import org.usfirst.frc.team1540.robot.Utils;

/**
 *
 */
public class Turn extends Command {
	boolean is_it_done_yet = false;
	
	public Turn() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain); //The object initialized in robot.java
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Utils.initGyro();
		//Utils.turn_nopid(45);
		Utils.straight(0.5);
		is_it_done_yet = true;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		//return false;
		return is_it_done_yet;
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
