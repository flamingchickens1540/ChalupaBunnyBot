package org.usfirst.frc.team1540.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1540.robot.Robot;
import org.usfirst.frc.team1540.robot.OI;

public class TeleopDrive extends Command{

	public TeleopDrive() {
		requires(Robot.drivetrain);
	}

	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drivetrain.left1.set(OI.getLeftAxis());   //Negate with -OI.getRightAxis()
		Robot.drivetrain.right1.set(OI.getRightAxis()); // might be -OI.getRightAxis()
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
