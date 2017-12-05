package org.usfirst.frc.team1540.robot.subsystems;
import org.usfirst.frc.team1540.robot.RobotMap;
import org.usfirst.frc.team1540.robot.commands.RotateArm;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	
	public Talon armTalon = new Talon(RobotMap.armMoveNumber);
	
	Encoder armEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	
	public Arm() {		
		armEncoder.setMaxPeriod(0.1);
		armEncoder.setMinRate(10);
		armEncoder.setDistancePerPulse(5);
		armEncoder.setReverseDirection(true);
		armEncoder.setSamplesToAverage(7);
	}
	
	public double softStop(double value) {
		if((armEncoder.get() < -700 && value < 0)  || (armEncoder.get() > -70 && value > 0)) {
			return 0;
		}else {
			return value;
		}
	}

	
	public void reset() {
		armEncoder.reset();
	}
	
	public int encoderGet() {
		int count = armEncoder.get();
		return count;
	}
	
	public boolean isStopped() {
		boolean stopped = armEncoder.getStopped();
		return stopped;
	}

	public boolean getDirection() {
		boolean direction = armEncoder.getDirection();
		return direction;
	}
	
	public double getEncoderRate() {
		double rate = armEncoder.getRate();
		return rate;
	}

	public void rotate(double value) {
		armTalon.set(value);
	}
	
	public void moveUp() {
		armTalon.set(-0.5);
	}
	
	public void moveDown() {
		armTalon.set(0.5);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new RotateArm());
	}
}