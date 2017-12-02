package org.usfirst.frc.team1540.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1540.robot.Robot;
import org.usfirst.frc.team1540.robot.OI;

public class JoystickDrive extends Command{

	public JoystickDrive() {
		requires(Robot.bucket_arm);
	}

	double deadzone(double value) {
		if(Math.abs(value) <= 0.4) {
			return 0;
		}else { 
			return value;
		}
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.bucket_arm.armTalon.set(0.006 * deadzone(OI.getCopilotLeftStickUpDown())); //Negate with -OI.*
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
