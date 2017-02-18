package org.usfirst.frc.team6002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6002.robot.Robot;
import org.usfirst.frc.team6002.robot.subsystems.Drivetrain;

/**
 *
 */
public class GyroDriveStraight extends Command {

    public GyroDriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.chassis.setSetpoint(Robot.chassis.getGyroAngle());
    	Robot.chassis.setPID(0.5, 0.0, 0.0);
    	Robot.chassis.enable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.arcadeDrive(Robot.chassis.getPIDOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.disable();
    }
}
