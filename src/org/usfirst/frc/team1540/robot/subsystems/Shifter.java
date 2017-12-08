package org.usfirst.frc.team1540.robot.subsystems;
import org.usfirst.frc.team1540.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem{
	
	static Solenoid shiftingNoid = new Solenoid(RobotMap.shifting_noid);
	int state;
	
	public Shifter() {
	}

	public void shift() {	
		if(state == 0) {
			shiftingNoid.set(true);
			state = 1;
		} else if(state == 1) {
			shiftingNoid.set(false);
			state = 0;
		}
	}
	
	public void on() {
		shiftingNoid.set(true);
	}
	
	public void off() {
		shiftingNoid.set(false);
	}

	public void reset() {
		state = 1;
		shiftingNoid.set(false);	
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}
