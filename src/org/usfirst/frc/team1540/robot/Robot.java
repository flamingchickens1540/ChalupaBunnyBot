package org.usfirst.frc.team1540.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1540.robot.commands.AutoCommands;
import org.usfirst.frc.team1540.robot.commands.RevIntake;
//import org.usfirst.frc.team1540.robot.commands.ShiftDrive;
import org.usfirst.frc.team1540.robot.commands.RightTurn;
import org.usfirst.frc.team1540.robot.commands.ShiftFalse;
import org.usfirst.frc.team1540.robot.commands.ShiftTrue;
import org.usfirst.frc.team1540.robot.commands.StartIntake;
//import org.usfirst.frc.team1540.robot.commands.Turn;
//import org.usfirst.frc.team1540.robot.commands.TurnOnLeds;
import org.usfirst.frc.team1540.robot.subsystems.Arm;
import org.usfirst.frc.team1540.robot.subsystems.DriveTrain;

import org.usfirst.frc.team1540.robot.subsystems.Intake;
//import org.usfirst.frc.team1540.robot.subsystems.LEDs;
import org.usfirst.frc.team1540.robot.subsystems.Shifter;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the IterativeRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the manifest file in the
 * resource directory.
 */

public class Robot extends IterativeRobot {

  public static final Shifter shifter = new Shifter();
  public static final DriveTrain drivetrain = new DriveTrain();
  public static final Arm bucket_arm = new Arm();
  public static final Intake intake = new Intake();
  //public static LEDs led = new LEDs();
  public static OI oi;

  Command autonomousCommand;
//	SendableChooser<Command> chooser = new SendableChooser<>(); //Smartdashboard radio button

  @Override
  public void robotInit() {
    oi = new OI();
//		chooser.addDefault("Default Auto", new Turn()); //Main auto command. addDefault is the one if nothing else is chosen
//		chooser.addObject("My Auto", new ExampleCommand()); //addObject is the one for adding the options.
//		SmartDashboard.putData("Auto mode", chooser);

    OI.intake_rev.whileHeld(new RevIntake());
    OI.intake.whileHeld(new StartIntake());

    //OI.shift.whenPressed(new ShiftDrive()); //IDK if works

    OI.shiftup.whenPressed(new ShiftTrue());
    OI.shiftdown.whenPressed(new ShiftFalse());

//		OI.armUpButton.whenPressed(new ArmUp());
//		OI.armDownButton.whenPressed(new ArmDown());

    //shifter.reset();
    bucket_arm.reset();
    //new TurnOnLeds();
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You can use it to reset
   * any subsystem information you want to clear when the robot is disabled.
   */
  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString code to get the auto name from the text box below the Gyro
   *
   * You can add additional auto modes by adding additional commands to the chooser code above (like
   * the commented example) or additional comparisons to the switch structure below with additional
   * strings & commands.
   */
  @Override
  public void autonomousInit() {
//		autonomousCommand = chooser.getSelected();
//
//		/*
//		 * String autoSelected = SmartDashboard.getString("Auto Selector",
//		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
//		 * = new MyAutoCommand(); break; case "Default Auto": default:
//		 * autonomousCommand = new ExampleCommand(); break; }
//		 */
//
//		// schedule the autonomous command (example)
//		if (autonomousCommand != null)
//			autonomousCommand.start();
//		autonomousCommand = new AutoCommands();

//		autonomousCommand.start();
    Scheduler.getInstance().add(new RightTurn());

  }

  /**
   * This function is called periodically during autonomous
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

//		if(OI.getCopilotRightStickUpDown() < 0.2) {
//			Robot.intake.start_intake();
//		}else {
//			Robot.intake.stop_intake();
//		}
//		
//		if(OI.getCopilotRightStickUpDown() < -0.2) {
//			Robot.intake.rev_intake();
//		}else {
//			Robot.intake.stop_intake();
//		}

    //System.out.println(bucket_arm.encoderGet());
    //System.out.println(Robot.intake.getCurrent());
  }

  /**
   * This function is called periodically during test mode
   */
  @Override
  public void testPeriodic() {
  }
}
