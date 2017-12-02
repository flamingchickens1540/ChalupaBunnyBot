package org.usfirst.frc.team1540.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team1540.robot.OI;
import org.usfirst.frc.team1540.robot.Robot;

/**
 *
 */
public class ArmUp extends Command {
	public ArmUp() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.bucket_arm); //The object initialized in robot.java
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		while(Robot.bucket_arm.getEncoderRate() < 10) {
			Robot.bucket_arm.moveUp();
		}
		
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
