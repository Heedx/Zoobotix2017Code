package org.usfirst.frc.team6002.robot.subsystems;

import org.usfirst.frc.team6002.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team6002.robot.RobotMap;
import org.usfirst.frc.team6002.robot.commands.DriveWithJoystick;
import com.kauailabs.navx.frc.AHRS; 
import edu.wpi.first.wpilibj.SPI;

/**
 *
 */
public class Drivetrain extends PIDSubsystem {
	static private double p = 0.0;
	static private double i = 0.0;
	static private double d = 0.0;
	static private double pidOutput = 0.0;
	static private double maxRange = .6;
	
	static private PIDController pidControl;
	static private RobotDrive drive;
	static private VictorSP frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;
	static private AHRS gyro;
	static private Encoder leftEnc, rightEnc;
	
	
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
    	gyro = new AHRS(SPI.Port.kMXP);
    	setOutputRange(-maxRange, maxRange); //set the limits of the PidOutput to be only within 60% usage.
    	setPercentTolerance(0.1);//keep fixing error until we are 0.1% of the target.
    	
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
    	return gyro.getAngle();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	pidOutput = output;
    }
    public double getPIDOutput(){
    	return pidOutput;
    }
    public double getGyroAngle(){
    	return gyro.getAngle();
    }
    //allows other commands to set pid values.
    public void setPID(double p, double i, double d){
    	pidControl.setPID(p, i, d);
    }
    
    //drive the chassis by passing it a move and turn value
    //Move - forward = positive, backward = negative
    //Turn - right = positive, left = negative
    public void arcadeDrive(double moveValue, double turnValue){
    	drive.arcadeDrive(moveValue, turnValue); 
    }
}
