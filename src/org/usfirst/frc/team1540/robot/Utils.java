package org.usfirst.frc.team1540.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;

public class Utils {
	static Timer timer = new Timer();
	
	private static Gyro gyro;
	
	public static double deadzone(double value) {
		if(Math.abs(value) <= 0.2) {
			return 0;
		}else { 
			return value;
		}
	}

	public static void delay(double seconds) {
		Timer.delay(seconds);
	}
	
	public static void initGyro() {
		gyro = new AnalogGyro(1);
	}
	
	public static double getAngle() {
		return gyro.getAngle();
	}
	
	public static double final_angle() {
		return -getAngle() * 0.03;
	}
	
	
	
//	public static void turn(double degrees) {
//		gyro.reset();
//		
//		double error = 100;
//		
//		while(Math.abs(error) > 5) {
//			error = degrees - gyro.getAngle(); //I want error to be as small as possible
//			System.out.println(error);
//			
//			if(error > 0) {
//				Robot.drivetrain.left1.set(0.5); //Turn left
//				Robot.drivetrain.right1.set(-0.5);
//				
//			}else {
//				Robot.drivetrain.left1.set(-0.5); //Turn right
//				Robot.drivetrain.right1.set(0.5);
//			}
//		}
//		Robot.drivetrain.left1.set(0);
//		Robot.drivetrain.right1.set(0);
//	}
	
	
	public static void turn_nopid(double degrees) {
		gyro.reset();
		
		double error = 10;
		
		while(Math.abs(error) > 5) {
			error = degrees - gyro.getAngle();
			
			if(getAngle() < degrees) {
				Robot.drivetrain.left1.set(-0.2);
				Robot.drivetrain.right1.set(0.2);
			}else {
				Robot.drivetrain.left1.set(0.2);
				Robot.drivetrain.right1.set(-0.2);
			}
		}
		Robot.drivetrain.left1.set(0);
		Robot.drivetrain.right1.set(0);
	}
	
	public static void straight(double time) {
		timer.reset();
		gyro.reset();
		
		while(timer.get() < time) {
			if(Math.abs(getAngle()) > 70) {
				
				if(getAngle() > 0) {
					Robot.drivetrain.left1.set(0.2);
				}else {
					Robot.drivetrain.right1.set(0.2);
				}
			}else {
				Robot.drivetrain.left1.set(0.2);
				Robot.drivetrain.right1.set(0.2);
			}
		}
		Robot.drivetrain.left1.set(0);
		Robot.drivetrain.right1.set(0);
	}
	
//	public static void straightPID() {
//		timer.reset();
//		gyro.reset();
//		
//		
//	}
	
}
