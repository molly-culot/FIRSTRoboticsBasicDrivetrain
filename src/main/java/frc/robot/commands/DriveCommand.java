// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
//Joysticks X and Y
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.Constants;



public class DriveCommand extends CommandBase {
  private final Joystick joystick;
  private final Drivetrain drivetrain;

  private Drivetrain driveSubsystem;
  /** Creates a new DriveCommand. */
  public DriveCommand(Drivetrain dt, Joystick js) {
    // Use addRequirements() here to declare subsystem dependencies.
    drivetrain = dt;
    joystick = js;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = this.joystick.getY();
    double rotation = this.joystick.getX();
    double squaredSpeed = Math.signum(speed) * Math.pow(speed, Constants.ACCELERATION_CONSTANT);
    double squaredRotation = Math.signum(rotation) * Math.pow(rotation, Constants.ACCELERATION_CONSTANT);
    this.drivetrain.diffDrive(squaredSpeed, squaredRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
