package org.usfirst.frc.team1540.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	Compressor c = new Compressor(0);
	//c.setClosedLoopControl(true); //needs pressure switch
	
	public boolean isEnabled() {
		boolean enabled = c.enabled();
		return enabled;
	}
	
	public boolean IspressureSwitch() {
		boolean pressureSwitch = c.getPressureSwitchValue();
		return pressureSwitch;
	}
	
	public float GetCompCurrent() {
		float current = (float) c.getCompressorCurrent();
		return current;
	}
	
	
	


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
