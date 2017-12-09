package org.usfirst.frc.team1540.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommands extends CommandGroup {
	
	public AutoCommands() {
		//addSequential(new StraightForTime(2));
		//addSequential(new TurnWithGyro(90));
		addSequential(new TurnForTime(10, "R"));
	}	
}
