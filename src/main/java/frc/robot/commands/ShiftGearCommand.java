// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ShiftGearCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final Drivetrain drivetrain;

  public ShiftGearCommand(Drivetrain dt) {
    drivetrain = dt;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    drivetrain.shiftGear();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    
  }

  // Make this return true when this Command no longer needs to run execute(

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {}
  
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  
}
