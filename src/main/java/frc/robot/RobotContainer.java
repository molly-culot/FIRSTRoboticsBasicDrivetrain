// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.GenericHID;

//imports joystick
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain drivetrain;
  private static Joystick driverJoystick;
  private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand autoCommand = new ExampleCommand(exampleSubsystem);
  public DriveCommand driveCommand; 
  // The robot's subsystems and commands are defined here...
    public RobotContainer(){
      
      //Creating an object for the drivetrain so the classes can be accessed
      drivetrain = new Drivetrain();
      //Creating an object for joystick
      driverJoystick = new Joystick(0);
      //initalizing drivecommand
      driveCommand = new DriveCommand(driverJoystick.getRawAxis(0), driverJoystick.getRawAxis(1), drivetrain);
    }

    //private void configreButtonBindings(){} 
    
    public Command getAutonomousCommand() {
      return autoCommand;
    }
    public Command getTeleopCommand(){
      return driveCommand;
    }
  
  }

