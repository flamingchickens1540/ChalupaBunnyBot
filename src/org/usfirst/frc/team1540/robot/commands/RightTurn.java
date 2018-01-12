package org.usfirst.frc.team1540.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import org.usfirst.frc.team1540.robot.Robot;

public class RightTurn extends Command {

  Waypoint[] points = new Waypoint[]{
      new Waypoint(-4, -1, Pathfinder.d2r(-45)),
      // Waypoint @ x=-4, y=-1, exit angle=-45 degrees
      new Waypoint(-2, -2, 0),                        // Waypoint @ x=-2, y=-2, exit angle=0 radians
      new Waypoint(0, 0, 0)                           // Waypoint @ x=0, y=0,   exit angle=0 radians
  };

  double wheelDiameter = 0.05;
  double wheelbaseWidth = 0.6;
  double maxVelocity = 1.7;
  double encoderTicksPerRev = 1023;

  private boolean isFinished = false;

  EncoderFollower left, right;

  public RightTurn() {

    // Create the Trajectory Configuration
    //
    // Arguments:
    // Fit Method:          HERMITE_CUBIC or HERMITE_QUINTIC
    // Sample Count:        SAMPLES_HIGH (100 000)
    //                      SAMPLES_LOW  (10 000)
    //                      SAMPLES_FAST (1 000)
    // Time Step:           0.05 Seconds
    // Max Velocity:        1.7 m/s
    // Max Acceleration:    2.0 m/s/s
    // Max Jerk:            60.0 m/s/s/s
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
        Trajectory.Config.SAMPLES_HIGH, 0.05, maxVelocity, 2.0, 60.0);

    // Generate the trajectory
    Trajectory trajectory = Pathfinder.generate(points, config);

    // Create the Modifier Object
    TankModifier modifier = new TankModifier(trajectory);

    // Generate the Left and Right trajectories using the original trajectory
    // as the centre
    modifier.modify(wheelbaseWidth);

    EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
    EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());
  }

  protected void execute() {
    isFinished = false;

    Robot.drivetrain.left1.setEncoderCodesPerRev(encoderTicksPerRev);
    Robot.drivetrain.right1.setEncoderCodesPerRev(encoderTicksPerRev);

    // Encoder Position is the current, cumulative position of your encoder. If you're using an SRX, this will be the
    // 'getEncPosition' function.
    // 1000 is the amount of encoder ticks per full revolution
    // Wheel Diameter is the diameter of your wheels (or pulley for a track system) in meters
    left.configureEncoder((int) Robot.drivetrain.left1.getSelectedSensorPosition(), 1, wheelDiameter);
    right.configureEncoder((int) Robot.drivetrain.right1.getSelectedSensorPosition(), 1, wheelDiameter);

    // The first argument is the proportional gain. Usually this will be quite high
    // The second argument is the integral gain. This is unused for motion profiling
    // The third argument is the derivative gain. Tweak this if you are unhappy with the tracking of the trajectory
    // The fourth argument is the velocity ratio. This is 1 over the maximum velocity you provided in the
    //      trajectory configuration (it translates m/s to a -1 to 1 scale that your motors can read)
    // The fifth argument is your acceleration gain. Tweak this if you want to get to a higher or lower speed quicker
    left.configurePIDVA(1.0, 0.0, 0.0, 1 / maxVelocity, 0);
    right.configurePIDVA(1.0, 0.0, 0.0, 1 / maxVelocity, 0);

    double lOutput, rOutput;
    do {
      lOutput = left.calculate((int) Robot.drivetrain.left1.getSelectedSensorPosition());
      rOutput = right.calculate((int) Robot.drivetrain.right1.getSelectedSensorPosition());
    } while (lOutput > 0.001 && rOutput > 0.001);

    isFinished = true;
  }

  @Override
  protected boolean isFinished() {
    return isFinished;
  }

}
