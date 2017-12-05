package org.usfirst.frc.team1540.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1540.robot.Robot;

public class StartIntake extends Command {
	public StartIntake() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake); //The object initialized in robot.java
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.intake.start_intake();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putNumber("Intake Current", Robot.intake.getCurrent());
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
		Robot.intake.stop_intake();
	}
}
