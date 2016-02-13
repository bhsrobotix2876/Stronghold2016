// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.Stronghold2016;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder.IndexingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainFrontRightTalon;
    public static CANTalon driveTrainRearRightTalon;
    public static CANTalon driveTrainFrontLeftTalon;
    public static CANTalon driveTrainRearLeftTalon;
    public static AnalogGyro driveTrainAnalogGyro1;
    public static Encoder driveTrainIndexedEncoder1;
    public static Encoder driveTrainIndexedEncoder2;
    public static CANTalon armCANTalon;
    public static DigitalInput armBottomLimit;
    public static DigitalInput armTopLimit;
    public static CANTalon intakeLeftTalon;
    public static CANTalon intakeRightTalon;
    public static DigitalInput intakeLimitSwitch1;
    public static CANTalon shooterLeftTalon;
    public static CANTalon shooterRightTalon;
    public static Encoder shooterQuadratureEncoder1;
    public static Encoder shooterQuadratureEncoder2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainFrontRightTalon = new CANTalon(4);
        LiveWindow.addActuator("DriveTrain", "FrontRightTalon", driveTrainFrontRightTalon);
        
        driveTrainRearRightTalon = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "RearRightTalon", driveTrainRearRightTalon);
        
        driveTrainFrontLeftTalon = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "FrontLeftTalon", driveTrainFrontLeftTalon);
        
        driveTrainRearLeftTalon = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "RearLeftTalon", driveTrainRearLeftTalon);
        
        driveTrainAnalogGyro1 = new AnalogGyro(0);
        LiveWindow.addSensor("DriveTrain", "AnalogGyro 1", driveTrainAnalogGyro1);
        driveTrainAnalogGyro1.setSensitivity(0.007);
        driveTrainIndexedEncoder1 = new Encoder(3, 4, false);
        LiveWindow.addSensor("DriveTrain", "Indexed Encoder 1", driveTrainIndexedEncoder1);
        driveTrainIndexedEncoder1.setDistancePerPulse(1.0);
        driveTrainIndexedEncoder1.setPIDSourceType(PIDSourceType.kRate);
        driveTrainIndexedEncoder1.setIndexSource(5, IndexingType.kResetOnRisingEdge);
        driveTrainIndexedEncoder2 = new Encoder(6, 7, false);
        LiveWindow.addSensor("DriveTrain", "Indexed Encoder 2", driveTrainIndexedEncoder2);
        driveTrainIndexedEncoder2.setDistancePerPulse(1.0);
        driveTrainIndexedEncoder2.setPIDSourceType(PIDSourceType.kRate);
        driveTrainIndexedEncoder2.setIndexSource(8, IndexingType.kResetOnRisingEdge);
        armCANTalon = new CANTalon(9);
        LiveWindow.addActuator("Arm", "CANTalon", armCANTalon);
        
        armBottomLimit = new DigitalInput(0);
        LiveWindow.addSensor("Arm", "BottomLimit", armBottomLimit);
        
        armTopLimit = new DigitalInput(1);
        LiveWindow.addSensor("Arm", "TopLimit", armTopLimit);
        
        intakeLeftTalon = new CANTalon(7);
        LiveWindow.addActuator("Intake", "LeftTalon", intakeLeftTalon);
        
        intakeRightTalon = new CANTalon(8);
        LiveWindow.addActuator("Intake", "RightTalon", intakeRightTalon);
        
        intakeLimitSwitch1 = new DigitalInput(2);
        LiveWindow.addSensor("Intake", "Limit Switch 1", intakeLimitSwitch1);
        
        shooterLeftTalon = new CANTalon(5);
        LiveWindow.addActuator("Shooter", "LeftTalon", shooterLeftTalon);
        
        shooterRightTalon = new CANTalon(6);
        LiveWindow.addActuator("Shooter", "RightTalon", shooterRightTalon);
        
        shooterQuadratureEncoder1 = new Encoder(9, 10, false, EncodingType.k4X);
        LiveWindow.addSensor("Shooter", "Quadrature Encoder 1", shooterQuadratureEncoder1);
        shooterQuadratureEncoder1.setDistancePerPulse(1.0);
        shooterQuadratureEncoder1.setPIDSourceType(PIDSourceType.kRate);
        shooterQuadratureEncoder2 = new Encoder(11, 12, false, EncodingType.k4X);
        LiveWindow.addSensor("Shooter", "Quadrature Encoder 2", shooterQuadratureEncoder2);
        shooterQuadratureEncoder2.setDistancePerPulse(1.0);
        shooterQuadratureEncoder2.setPIDSourceType(PIDSourceType.kRate);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
