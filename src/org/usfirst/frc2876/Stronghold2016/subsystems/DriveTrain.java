// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.Stronghold2016.subsystems;


import org.usfirst.frc2876.Stronghold2016.Robot;
import org.usfirst.frc2876.Stronghold2016.RobotMap;
import org.usfirst.frc2876.Stronghold2016.commands.*;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDeviceStatus;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Encoder.IndexingType;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon rearLeftTalon = RobotMap.driveTrainRearLeftTalon;
    private final CANTalon frontLeftTalon = RobotMap.driveTrainFrontLeftTalon;
    private final CANTalon rearRightTalon = RobotMap.driveTrainRearRightTalon;
    private final CANTalon frontRightTalon = RobotMap.driveTrainFrontRightTalon;
    private final Encoder rightEncoder = RobotMap.driveTrainRightEncoder;
    private final Encoder leftEncoder = RobotMap.driveTrainLeftEncoder;
    private final AnalogAccelerometer accel = RobotMap.driveTrainAccel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
	static final double THRESHOLD_OFF_BALANCE = 5;
	static final double THRESHOLD_ON_BALANCE = 3;
	
	public CameraServer server;

    public PIDController turnController;
    public double kP = .3;
    public double kI = 0;
    public double kD = 0;
    public double kF = 0;
    public double pidTolerance = 2.0;

    
    public RobotDrive myRobot;
    
    public DriveTrain(){
    	rearLeftTalon.setInverted(Robot.IS_PRACTICE_BOT);
    	frontLeftTalon.setInverted(Robot.IS_PRACTICE_BOT);
    	
    	myRobot = new RobotDrive(frontLeftTalon, rearLeftTalon, frontRightTalon, rearRightTalon);

    	initializeCamera();
    	
        turnController = new PIDController(kP, kI, kD, kF, Robot.navX, 
        	new PIDOutput(){ 
				public void pidWrite(double output) {
				}
			}
				);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-.5, .5);
        turnController.setAbsoluteTolerance(pidTolerance);
        turnController.setContinuous(true);
		
		rearLeftTalon.configEncoderCodesPerRev(100);
		rearRightTalon.configEncoderCodesPerRev(100);
    	 
    }
    
	private boolean isTankDrive = false;
	
    public boolean getIsTankDrive() {
		return isTankDrive;
	}

	public void setIsTankDrive(boolean isTankDrive) {
		this.isTankDrive = isTankDrive;
	}
	
	public void toggleIsTankDrive(){
		this.isTankDrive = !this.isTankDrive;
	}
	
	public void setBrakeMode(boolean on) {
		frontLeftTalon.enableBrakeMode(on);
		rearLeftTalon.enableBrakeMode(on);
		frontRightTalon.enableBrakeMode(on);
		rearRightTalon.enableBrakeMode(on);
	}
	
	public void setRampRate(double ramp) {
		frontLeftTalon.setVoltageRampRate(ramp);
		rearLeftTalon.setVoltageRampRate(ramp);
		frontRightTalon.setVoltageRampRate(ramp);
		rearRightTalon.setVoltageRampRate(ramp);
	}
	
	public double sensitivity = .75;

	public double getSensitivity(){
		return sensitivity;
	}
	
	public void setSensitivity(double sensitivity){
		this.sensitivity = sensitivity;
	}
	
	public double getDistance(){
		return (rightEncoder.getDistance() + leftEncoder.getDistance()) / 2;
	  
	}
	
	
	public Encoder getRightEncoder() {
		return rightEncoder;
	}
	
	
	public Encoder getLeftEncoder() {
		return leftEncoder;
	}
	
	private boolean isCrossing = false;
	
	public boolean isCrossingDefense(){
		double roll = Math.abs(Robot.navX.getRoll());
		
		if(!isCrossing && roll > THRESHOLD_OFF_BALANCE) {
			isCrossing = true;
		} else if (isCrossing && roll < THRESHOLD_ON_BALANCE) {
			isCrossing = false;
		} 
		return isCrossing;
	}

	public void initializeCamera(){
		server = CameraServer.getInstance();
		server.setQuality(50);
		server.startAutomaticCapture("cam1");
	}
	
	public void initDefaultCommand() {
		
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveControl());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
	public void updateSmartDashboard(){
//		boolean sensorPluggedIn = (frontRightTalon.isSensorPresent(FeedbackDevice.QuadEncoder) == FeedbackDeviceStatus.FeedbackStatusPresent);
//		SmartDashboard.putBoolean("fr encoder isSensorPresent ", sensorPluggedIn);
//		SmartDashboard.putData("Left Encoder", getLeftEncoder());
//    	SmartDashboard.putData("Right Encoder", getRightEncoder());
//    	SmartDashboard.putNumber("Right Encoder d", leftEncoder.getDistance());
//    	SmartDashboard.putNumber("Left Encoder d", rightEncoder.getDistance());
//    	SmartDashboard.putBoolean("is navX connected", Robot.navX.isConnected());
//    	SmartDashboard.putBoolean("is navX calibrating", Robot.navX.isCalibrating());
//    	SmartDashboard.putData("NavX", Robot.navX);
//    	SmartDashboard.putBoolean("is navX moving", Robot.navX.isMoving());
//    	SmartDashboard.putBoolean("is navX rotating", Robot.navX.isRotating());
//    	SmartDashboard.putNumber("navX angle", Robot.navX.getAngle());
//    	SmartDashboard.putNumber("navX pitch", Robot.navX.getPitch());
//    	SmartDashboard.putNumber("navX yaw", Robot.navX.getYaw());
//    	SmartDashboard.putNumber("navX roll", Robot.navX.getRoll());
//    	SmartDashboard.putNumber("navX WorldX", Robot.navX.getWorldLinearAccelX());
//    	SmartDashboard.putNumber("navX WorldY", Robot.navX.getWorldLinearAccelY());
//    	SmartDashboard.putNumber("navX WorldZ", Robot.navX.getWorldLinearAccelZ());
//    	SmartDashboard.putNumber("Accel RoboRio", accel.getAcceleration());
//    	SmartDashboard.putData("pid", turnController);
//    	SmartDashboard.putNumber("pid output", turnController.get());
//    	SmartDashboard.putBoolean("is crossing", isCrossing);
	}
	public void resetEncoders() {
		rightEncoder.reset();
		leftEncoder.reset();
	}
	public void initializeDistancePerPulse() {
		double wheelDiameter = 8;
		double pulsePerRevolution = 2048;
		double gearRatio = 10.71;
		leftEncoder.setDistancePerPulse(Math.PI * wheelDiameter / pulsePerRevolution * gearRatio);
		rightEncoder.setDistancePerPulse(Math.PI * wheelDiameter / pulsePerRevolution * gearRatio);
	}
}

