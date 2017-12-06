package org.usfirst.frc.team1540.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1540.robot.OI;
import org.usfirst.frc.team1540.robot.Robot;

public class RotateArm extends Command {
	public RotateArm() {
		requires(Robot.bucket_arm); //The object initialized in robot.java
	}

	@Override
	protected void initialize() {
	}
	
	double deadzone(double value) {
		if(Math.abs(value) <= 0.2) {
			return 0;
		}else { 
			return value;
		}
	}

	@Override
	protected void execute() {
		Robot.bucket_arm.rotate(Robot.bucket_arm.softStop(0.5 * deadzone(OI.getCopilotLeftStickUpDown())));
		SmartDashboard.putNumber("Encoder Count", Robot.bucket_arm.encoderGet());
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
