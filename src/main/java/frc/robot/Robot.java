// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {
  private static final int kFrontLeftChannel = 2;
  private static final int kRearLeftChannel = 3;
  private static final int kFrontRightChannel = 1;
  private static final int kRearRightChannel = 0;

  private static final int kJoystickChannel = 0;

private final TalonSRX frontright;
private final TalonSRX frontleft;
private final TalonSRX rearright;
private final TalonSRX rearleft;
  //private final MecanumDrive m_robotDrive;
  //private final Joystick m_stick;
  private final XboxController xbox1;

  /** Called once at the beginning of the robot program. */
  public Robot() {
    //PWMSparkMax frontLeft = new PWMSparkMax(kFrontLeftChannel);
    //PWMSparkMax rearLeft = new PWMSparkMax(kRearLeftChannel);
    //PWMSparkMax frontRight = new PWMSparkMax(kFrontRightChannel);
    //PWMSparkMax rearRight = new PWMSparkMax(kRearRightChannel);
 frontright= new TalonSRX(4); // creates a new TalonSRX with ID 0
 frontleft= new TalonSRX(1);
 rearleft= new TalonSRX(2);
 rearright= new TalonSRX(3);

    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    frontright.setInverted(true);
    rearright.setInverted(true);

    //m_robotDrive = new MecanumDrive(frontleft::set, rearleft::set, frontright::set, rearright::set);

    //m_stick = new Joystick(kJoystickChannel);
    xbox1 = new XboxController(kJoystickChannel);

    /* SendableRegistry.addChild(m_robotDrive, frontLeft);
    SendableRegistry.addChild(m_robotDrive, rearLeft);
    SendableRegistry.addChild(m_robotDrive, frontRight);
    SendableRegistry.addChild(m_robotDrive, rearRight); */
  }

  @Override
  public void teleopPeriodic() {
    // Use the joystick Y axis for forward movement, X axis for lateral
    // movement, and Z axis for rotation.
    //m_robotDrive.driveCartesian(-m_stick.getY(), -m_stick.getX(), -m_stick.getZ());
    double forward= xbox1.getLeftY();
    double turn= xbox1.getRightX();
  

    frontleft.set(TalonSRXControlMode.PercentOutput, forward-turn);   
    frontright.set(TalonSRXControlMode.PercentOutput, forward+turn);   
    rearleft.set(TalonSRXControlMode.PercentOutput, forward-turn);   
    rearright.set(TalonSRXControlMode.PercentOutput, forward+turn); 

  }
}
