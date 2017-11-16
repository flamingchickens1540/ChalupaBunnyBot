package org.usfirst.frc.team1540.robot.subsystems;
import org.usfirst.frc.team1540.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem{
	
	static Solenoid shiftingNoid = new Solenoid(RobotMap.shifting_noid);
	
	public void shift() {
		int state = 0;

		if(state == 0) {
			shiftingNoid.set(true);
			state = 1;
		} else if(state == 1) {
			shiftingNoid.set(false);
			state = 0;
		}
	}
	
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}
