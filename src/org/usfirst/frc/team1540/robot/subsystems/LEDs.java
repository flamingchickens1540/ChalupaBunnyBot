package org.usfirst.frc.team1540.robot.subsystems;
import org.usfirst.frc.team1540.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LEDs extends Subsystem {
	
	public Talon ledController = new Talon(RobotMap.ledTalonPort); //Port is 3 right now.
	
	public LEDs() {
	}
	
	public void on() {
		ledController.set(1);
	}
	
	public void off() {
		ledController.set(0);
	}
	
	public void initDefaultCommand() {
		//setDefaultCommand(new RotateArm());
	}
}