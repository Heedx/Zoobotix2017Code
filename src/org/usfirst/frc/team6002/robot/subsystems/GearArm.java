package org.usfirst.frc.team6002.robot.subsystems;

import org.usfirst.frc.team6002.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearArm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands
	private static CANTalon gearArmMotor; 
	
	int absPos; 
	
	private static double p; 
	private static double i; 
	private static double d;
	
	private static double home;
	private static double give; 
	private static double accept; 
	
	public GearArm(){
		//lets grab the 360 degree position of the MagEncoder's absolute position
		p = 0.5;
		i = 0.0;
		d = 0.0;
		
		gearArmMotor = new CANTalon(RobotMap.gearArmMotorPort);
		absPos = gearArmMotor.getPulseWidthPosition() & 0xFFF; 
		
		gearArmMotor.setEncPosition(absPos); 
		gearArmMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative); 
		
		
		//Configuring the PID and Talon settings 
		gearArmMotor.setSafetyEnabled(false); //Turn off safety features
		gearArmMotor.enableBrakeMode(true);//enable brake mode on talon
		gearArmMotor.changeControlMode(TalonControlMode.Position);//change control to position
		gearArmMotor.configPeakOutputVoltage(+8f,-8f);//Voltage range for PID
		
		gearArmMotor.setAllowableClosedLoopErr(0);//The alled margin of error
		gearArmMotor.setProfile(0);//the PID profile found on the roborio web interface
		gearArmMotor.setPID(p, i, d); //Set the PID constants (p,i,d)
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double getHomePosition(){
    	return home; 
    }
    public double getGivePosition(){
    	return give; 
    }
    public double getAcceptPosition(){
    	return accept; 
    }
    public void SetGearArmAngle(double angle){
    	gearArmMotor.set(angle); 
    }
}

