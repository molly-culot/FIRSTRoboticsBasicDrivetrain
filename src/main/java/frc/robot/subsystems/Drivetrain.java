// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  //private DifferentialDrive differentialDrive; 
  /** Creates a new Drivetrain. */
  WPI_TalonFX frontLeftController;
  WPI_TalonFX frontRightController;
  WPI_TalonFX backLeftController;
  WPI_TalonFX backRightController;

  DoubleSolenoid gearShifter;

  boolean lowGear;


  public Drivetrain() {
    // controllers
    frontLeftController = new WPI_TalonFX(Constants.LEFT_FRONT_TALON);
    frontRightController = new WPI_TalonFX(Constants.RIGHT_FRONT_TALON);
    backLeftController = new WPI_TalonFX(Constants.LEFT_BACK_TALON);
    backRightController = new WPI_TalonFX(Constants.RIGHT_BACK_TALON);
    
    frontLeftController.setInverted(TalonFXInvertType.Clockwise);
    frontRightController.setInverted(TalonFXInvertType.Clockwise);
    backLeftController.setInverted(TalonFXInvertType.Clockwise);
    backLeftController.setInverted(TalonFXInvertType.Clockwise);

    frontLeftController.configFactoryDefault();
    frontRightController.configFactoryDefault();
    backLeftController.configFactoryDefault();
    backRightController.configFactoryDefault();

    gearShifter = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.GEAR_SHIFT_DEPLOY, Constants.GEAR_SHIFT_RETRACT);

    lowGear = false;
  }
  public void diffDrive(double speed, double rotation){
    //differentialDrive.arcadeDrive(X_AXIS,Y_AXIS);

    frontLeftController.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, rotation);
    backLeftController.follow(this.frontLeftController);

    frontRightController.set(ControlMode.PercentOutput, -speed, DemandType.ArbitraryFeedForward, rotation);
    backRightController.follow(this.frontRightController);

  }

  public boolean shiftGear(){
    gearShifter.set((this.lowGear) ? DoubleSolenoid.Value.kForward: DoubleSolenoid.Value.kReverse);
    this.lowGear = !this.lowGear;
    return this.lowGear;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void simulationPeriodic(){
    //to be implemented later
  }
}
