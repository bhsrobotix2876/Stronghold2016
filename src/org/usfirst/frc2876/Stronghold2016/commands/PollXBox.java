// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2876.Stronghold2016.Robot;

/**
 *
 */
public class PollXBox extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public PollXBox() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    
    Command cross;
    
    boolean lastRightDPad;

    // Called just before this Command runs the first time
    protected void initialize() {
    	cross = new DriveCrossDefense(0, 0);
    	lastRightDPad = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.controller.getPOV() == 0) Robot.driveTrain.sensitivity = 1;
    	if (Robot.oi.controller.getPOV() == 180) Robot.driveTrain.sensitivity = .75;
    	if (!lastRightDPad && Robot.oi.controller.getPOV() == 90) {
    		if(!cross.isRunning()){
    			cross = new DriveCrossDefense(140, -.8);
    			cross.start();
    		} else {
    			cross.cancel();
    		}
    	}
    	lastRightDPad = Robot.oi.controller.getPOV() == 90;
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
