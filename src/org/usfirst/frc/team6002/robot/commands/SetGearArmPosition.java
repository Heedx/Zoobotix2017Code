package org.usfirst.frc.team6002.robot.commands;

import org.usfirst.frc.team6002.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetGearArmPosition extends Command {

	private double setPoint;
	
    public SetGearArmPosition(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearArm); 
    	setPoint = angle; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearArm.setGearArmAngle(setPoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
