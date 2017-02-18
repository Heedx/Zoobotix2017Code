package org.usfirst.frc.team6002.robot.subsystems;

import org.usfirst.frc.team6002.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team6002.robot.RobotMap;
import org.usfirst.frc.team6002.robot.commands.DriveWithJoystick;

/**
 *
 */
public class Drivetrain extends PIDSubsystem {
	static private double p = 0.0;
	static private double i = 0.0;
	static private double d = 0.0;
	
	static private RobotDrive drive;
	
	static private VictorSP frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;
	
    // Initialize your subsystem here
    public Drivetrain() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Drivetrain", p, i, d);
    	frontLeftMotor = new VictorSP(RobotMap.frontLeftMotorPort);
    	frontRightMotor = new VictorSP(RobotMap.frontRightMotorPort);
    	backRightMotor = new VictorSP(RobotMap.backRightMotorPort);
    	backLeftMotor = new VictorSP(RobotMap.backleftMotorPort);
    	drive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
    }

    /*It drives using the microsoft xbox controllers with arcade drive when no other 
    command is running
    */ 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand()
    	setDefaultCommand(new DriveWithJoystick()); 
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
    
    //drive the chassis by passing it a move and turn value
    //Move - forward = positive, backward = negative
    //Turn - right = positive, left = negative
    public void arcadeDrive(double moveValue, double turnValue){
    	drive.arcadeDrive(moveValue, turnValue); 
    }
}
