package org.usfirst.frc.team1540.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1540.robot.Robot;
import org.usfirst.frc.team1540.robot.Utils;

public class TurnWithGyro extends Command {
	double error = 100;
	boolean isItDoneYet = false;
	private double degrees;
	
	public TurnWithGyro(double degrees) {
		super(degrees);
		this.degrees = degrees;
		requires(Robot.drivetrain); //The object initialized in robot.java
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Utils.initGyro();
		Utils.gyro.reset();
//		Robot.drivetrain.left1.set(-0.5);
//		Robot.drivetrain.right1.set(0.5);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println(Utils.gyro.getAngle());
		if(Math.abs(error)*100 > 2) {
			error = degrees - Utils.gyro.getAngle();
			
			if(Utils.getAngle() < degrees) {
				System.out.println("angle is < than degrees");
//				Robot.drivetrain.left1.set(0.2);
//				Robot.drivetrain.right1.set(0.2);
				Robot.drivetrain.setLeft(-0.4);
				Robot.drivetrain.setRight(0.4);
				System.out.println("angle is < than degrees && done turning");
			}else {
				System.out.println("angle is !< than degrees");
//				Robot.drivetrain.left1.set(-0.2);
//				Robot.drivetrain.right1.set(-0.2);
				Robot.drivetrain.setLeft(0.4);
				Robot.drivetrain.setRight(-0.4);
			}
			
		}else {
			isItDoneYet = true;
			cancel();
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drivetrain.left1.set(0);
		Robot.drivetrain.right1.set(0);
	}

	@Override
	protected boolean isFinished() {
		return isItDoneYet;
	}
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
