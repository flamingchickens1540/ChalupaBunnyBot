package org.usfirst.frc.team1540.robot.subsystems;
import org.usfirst.frc.team1540.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	PowerDistributionPanel pdp = new PowerDistributionPanel(0);
	private Talon intakeTalon = new Talon(RobotMap.intake);
	//public Intake() {}
	
	public double getCurrent() {
		return pdp.getCurrent(1);
	}
	
	public void start_intake() { //Just spin both motors at full speed
		intakeTalon.set(1.0);
	}
	
	public void rev_intake() {
		intakeTalon.set(-1.0);
	}
	
	public void stop_intake() {
		intakeTalon.set(0);
	}
	
		// Put methods for controlling this subsystem
		// here. Call these from Commands.
	
	public void initDefaultCommand() {
		
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
}
