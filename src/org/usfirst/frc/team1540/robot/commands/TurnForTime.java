package org.usfirst.frc.team1540.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1540.robot.Robot;

public class TurnForTime extends TimedCommand {
	
	private String direction;
	
	public TurnForTime(double seconds, String direction) {
		super(seconds);
		this.direction = direction;
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain); //The object initialized in robot.java
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		if(direction == "L") {
			Robot.drivetrain.left1.set(0.5);
			Robot.drivetrain.right1.set(0.5);
		}else if(direction == "R"){
			Robot.drivetrain.left1.set(-0.5);
			Robot.drivetrain.right1.set(-0.5);
		}else {
			throw new java.lang.Error("Team1540 Chalupa: Direction Error.");
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drivetrain.left1.set(0);
		Robot.drivetrain.right1.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
