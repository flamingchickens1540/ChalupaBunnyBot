package org.usfirst.frc.team1540.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommands extends CommandGroup {
	String mode= "S";
	
	public AutoCommands() {
		if(mode == "S") {
			addSequential(new StraightForTime(4.7));
		}else if(mode == "S+T") {
			addSequential(new StraightForTime(4.7));
			addSequential(new TurnForTime(0.5, "L"));
		}else if(mode == "S+T+S") {
			addSequential(new StraightForTime(4.7));
			addSequential(new TurnForTime(0.5, "L"));
			addSequential(new StraightForTime(2));
		}else if(mode == "mess_everyone_up") {
			addSequential(new StraightForTime(4.7));
			addSequential(new TurnForTime(0.5, "L"));
			addSequential(new StraightForTime(2));
			addSequential(new TurnForTime(2, "L"));
			addSequential(new StraightForTime(2));
			
		}else {
			addSequential(new StraightForTime(4.7));
		}
	}	
}
