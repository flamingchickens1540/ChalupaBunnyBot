package org.usfirst.frc.team1540.robot.commands;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
import java.io.File;

public class PathfinderPlayground {

  //  Waypoint[] points = new Waypoint[]{
//      new Waypoint(-4, -1, Pathfinder.d2r(-45)),    // Waypoint @ x=-4, y=-1, exit angle=-45 degrees
//      new Waypoint(-2, -2, 0),                      // Waypoint @ x=-2, y=-2, exit angle=0 radians
//      new Waypoint(0, 0, 0)                         // Waypoint @ x=0,  y=0,  exit angle=0 radians
//  };

  final static double xDistance = 1;

  static Waypoint[] points = new Waypoint[] {
      new Waypoint(0, 0, 0),
      new Waypoint(xDistance, 0, 0)
  };

  final static double maxVelocity = 0.1;
  final static double maxAcceleration = 0.5;

//  Timer theTimer = new Timer();

  public static void main(String[] args) {
    File myFile = new File("path.csv");
    Pathfinder.writeToCSV(myFile, getTrajectory());
  }

  public static Trajectory getTrajectory() {
    // Create the Trajectory Configuration
    //
    // Arguments:
    // Fit Method:          HERMITE_CUBIC or HERMITE_QUINTIC
    // Sample Count:        SAMPLES_HIGH (100 000)
    //                      SAMPLES_LOW  (10 000)
    //                      SAMPLES_FAST (1 000)
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
        Trajectory.Config.SAMPLES_HIGH, 0.05, maxVelocity, maxAcceleration, 60.0);

    // Generate the trajectory
    return Pathfinder.generate(points, config);
  }

}