// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
//Joysticks X and Y
import frc.robot.subsystems.Drivetrain;


public class DriveCommand extends CommandBase {
  public double joystickInputX;
  public double joystickInputY;

  private Drivetrain driveSubsystem;
  /** Creates a new DriveCommand. */
  public DriveCommand(double inputX, double inputY, Drivetrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    joystickInputX = inputX;
    joystickInputY = inputY;
    driveSubsystem = driveTrain;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.diffDrive(joystickInputX, joystickInputY);
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
