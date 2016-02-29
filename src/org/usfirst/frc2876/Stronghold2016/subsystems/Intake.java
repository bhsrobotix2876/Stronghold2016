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
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Intake extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon rightTalon = RobotMap.intakeRightTalon;
    private final CANTalon leftTalon = RobotMap.intakeLeftTalon;
    private final DigitalInput limitSwitch = RobotMap.intakeLimitSwitch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public double intakeSpeed = 1;
    public double outputSpeed = 1;

//    public Intake(){
//    	initializeTalonMode();
//    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public CANTalon getLeftTalon(){
    	return leftTalon;
    }
    
    public CANTalon getRightTalon(){
    	return rightTalon;
    }
    
    public void updateSmartDashboard(){
//    	SmartDashboard.putBoolean("X Button", Robot.oi.xButton.get());
//    	SmartDashboard.putBoolean("A Button", Robot.oi.aButton.get());
//    	SmartDashboard.putNumber("Left Intake Talon Output", leftTalon.get());
//    	SmartDashboard.putNumber("Right Intake Talon Output", rightTalon.get());
//    	SmartDashboard.putBoolean("is intake limit switch pressed", isLimitSwitchPressed());
//    	SmartDashboard.putData("intake", this);
    	SmartDashboard.putBoolean("Is Intake Running", Math.abs(rightTalon.get()) > 0);
    }
    
    public void spinMotorsOut(double output){
    	leftTalon.set(-output);
    	rightTalon.set(output);
    }
    
    public void spinMotorsIn(double output){
    	leftTalon.set(output);
    	rightTalon.set(-output);
    }
    
    public boolean isLimitSwitchPressed(){
    	return !limitSwitch.get();
    }
    
    /**
     * Sets both motors to spin opposite each other, pos = in & neg = out
     * @param output, value both motors are set to
     */
    public void setBothMotors(double output){
    	leftTalon.set(output);
    	rightTalon.set(output);
    }
    
//    public void initializeTalonMode(){
//    	rightTalon.changeControlMode(CANTalon.TalonControlMode.Follower);
//    	rightTalon.set(leftTalon.getDeviceID());
//    	rightTalon.reverseOutput(true);
//    }
    
    public void initDefaultCommand() {
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new IntakeIdle());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

