package org.usfirst.frc.team1540.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1540.robot.OI;
import org.usfirst.frc.team1540.robot.Robot;
import org.usfirst.frc.team1540.robot.RobotMap;
import org.usfirst.frc.team1540.robot.Utils;
import org.usfirst.frc.team1540.robot.commands.TeleopDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class DriveTrain extends Subsystem{
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public CANTalon left1 = new CANTalon(RobotMap.left1);
	CANTalon left2 = new CANTalon(RobotMap.left2);
	
	public CANTalon right1 = new CANTalon(RobotMap.right1);
	CANTalon right2 = new CANTalon(RobotMap.right2);
	
	public DriveTrain() {
		
		left1.changeControlMode(TalonControlMode.PercentVbus);
		left2.changeControlMode(TalonControlMode.Follower);
		
		left1.reverseOutput(false);
		left2.reverseSensor(false);
		
		
		right1.changeControlMode(TalonControlMode.PercentVbus);
		right2.changeControlMode(TalonControlMode.Follower);
		
		right1.reverseOutput(true);
		right2.reverseSensor(false);

		
		left2.set(left1.getDeviceID());
		right2.set(right1.getDeviceID());

	}
	
	public void drive() {
		double triggerValue = OI.getDriverLeftTrigger() + -OI.getDriverRightTrigger();
		setRight(Utils.deadzone(-OI.getDriverLeftStickUpDown()) + triggerValue);
		setLeft(Utils.deadzone(-OI.getDriverRightStickUpDown()) + triggerValue);
	}
	
//	void triggerDrive(double trigger) {
//		Robot.drivetrain.left1.set(trigger);
//		Robot.drivetrain.left1.set(trigger);
//	}
	
	void setLeft(double value) {
		Robot.drivetrain.left1.set(-1 * value);
	}
	
	void setRight(double value) {
		Robot.drivetrain.right1.set(value);
	}
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new TeleopDrive());
		
	}
	
}


