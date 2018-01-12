package org.usfirst.frc.team1540.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.team1540.base.wrappers.ChickenTalon;
import org.usfirst.frc.team1540.robot.OI;
import org.usfirst.frc.team1540.robot.Robot;
import org.usfirst.frc.team1540.robot.RobotMap;
import org.usfirst.frc.team1540.robot.Utils;
import org.usfirst.frc.team1540.robot.commands.TeleopDrive;

public class DriveTrain extends Subsystem{
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public ChickenTalon left1 = new ChickenTalon(RobotMap.left1);
	ChickenTalon left2 = new ChickenTalon(RobotMap.left2);
	
	public ChickenTalon right1 = new ChickenTalon(RobotMap.right1);
	ChickenTalon right2 = new ChickenTalon(RobotMap.right2);
	
	public DriveTrain() {
		
		left1.setControlMode(ControlMode.PercentOutput);
		left2.setControlMode(ControlMode.Follower);
		
		left1.setInverted(false);
		left2.setSensorPhase(false);
		
		
		right1.setControlMode(ControlMode.PercentOutput);
		right2.setControlMode(ControlMode.Follower);
		
		right1.setInverted(true);
		right2.setSensorPhase(false);

		
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
	
	public void setLeft(double value) {
		Robot.drivetrain.left1.set(-1 * value);
	}
	
	public void setRight(double value) {
		Robot.drivetrain.right1.set(value);
	}
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new TeleopDrive());
		
	}
	
}


