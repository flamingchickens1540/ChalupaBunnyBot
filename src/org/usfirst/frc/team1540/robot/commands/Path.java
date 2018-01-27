package org.usfirst.frc.team1540.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team1540.robot.Robot;

public class Path extends Command {

  // LOW
  // left: 25030, right: 25423... 25600?
  // (42/12)*(50/16)*1024 = 11200
  final int encoderTicksPerRev = 1;
  final double wheelDiameter = 0.1;
  final double wheelbaseWidth = 0.62;

  private boolean isFinished = false;

  private int lInitial = 0;
  private int rInitial = 0;

  EncoderFollower left, right;

  public Path() {
  }

  protected void initialize() {
    isFinished = false;

    // Create the Modifier Object
    TankModifier modifier = new TankModifier(PathfinderPlayground.getTrajectory());

    // Generate the Left and Right trajectories using the original trajectory
    // as the centre
    modifier.modify(wheelbaseWidth);

    left = new EncoderFollower(modifier.getLeftTrajectory());
    right = new EncoderFollower(modifier.getRightTrajectory());

    // Encoder Position is the current, cumulative position of your encoder. If you're using an SRX, this will be the
    // 'getEncPosition' function.
    // 1000 is the amount of encoder ticks per full revolution
    // Wheel Diameter is the diameter of your wheels (or pulley for a track system) in meters

    lInitial = -Robot.drivetrain.left1.getQuadraturePosition();
    rInitial = Robot.drivetrain.right1.getQuadraturePosition();

    left.configureEncoder(lInitial, encoderTicksPerRev, wheelDiameter);
    right.configureEncoder(rInitial, encoderTicksPerRev, wheelDiameter);

    // Choose the greater maxV
//    double maxV = (PathfinderPlayground.maxVelocity > PathfinderPlayground.robotMaxVelocity ?
//        PathfinderPlayground.maxVelocity : PathfinderPlayground.robotMaxVelocity);
    double maxV = 10000;

    // The first argument is the proportional gain. Usually this will be quite high
    // The second argument is the integral gain. This is unused for motion profiling
    // The third argument is the derivative gain. Tweak this if you are unhappy with the tracking of the trajectory
    // The fourth argument is the velocity ratio. This is 1 over the maximum velocity you provided in the
    //      trajectory configuration (it translates m/s to a -1 to 1 scale that your motors can read)
    // The fifth argument is your acceleration gain. Tweak this if you want to get to a higher or lower speed quicker
    left.configurePIDVA(0.1, 0.0, 0.0, 0, 0);
    right.configurePIDVA(0.1, 0.0, 0.0, 0, 0);

//    theTimer.start();
  }

  protected void execute() {
    // LOW GEAR
    Robot.shifter.on();

    Robot.drivetrain.left1.setControlMode(ControlMode.PercentOutput);
    Robot.drivetrain.right1.setControlMode(ControlMode.PercentOutput);

//  do {

      // Both encoders go up as the robot goes forward
      int lPos = -Robot.drivetrain.left1.getQuadraturePosition();
      int rPos = Robot.drivetrain.right1.getQuadraturePosition();

      double lOutput = -left.calculate(lPos);
      double rOutput = right.calculate(rPos);

      Robot.drivetrain.left1.set(lOutput);
      Robot.drivetrain.right1.set(rOutput);

      SmartDashboard.putNumber("lOutput", lOutput);
      SmartDashboard.putNumber("rOutput", rOutput);
      SmartDashboard.putNumber("lPos", lPos);
      SmartDashboard.putNumber("rPos", rPos);
      SmartDashboard.putNumber("lInital", lInitial);
      SmartDashboard.putNumber("rInital", rInitial);
      SmartDashboard.putNumber("lDelta", PathfinderPlayground.xDistance/(Math.PI*wheelDiameter)*encoderTicksPerRev - (lPos-lInitial));
      SmartDashboard.putNumber("rDelta", PathfinderPlayground.xDistance/(Math.PI*wheelDiameter)*encoderTicksPerRev - (rPos-rInitial));
//      SmartDashboard.putNumber("Timestamp", theTimer.get());
//    } while (lOutput > 0.001 && rOutput > 0.001);

//    isFinished = true;
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}
