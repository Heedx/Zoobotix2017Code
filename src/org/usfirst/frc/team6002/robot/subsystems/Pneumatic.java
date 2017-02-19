package org.usfirst.frc.team6002.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatic extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Compressor airC;
	private DoubleSolenoid gearShift;
	private boolean highGear;
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void gearShift(DoubleSolenoid gearShift){
    	Compressor airC = new Compressor(0); //fix the port number
    	gearShift = new DoubleSolenoid(1,2);
    	this.gearShift = gearShift;
    }
    public void compressorOn(){
    	airC.setClosedLoopControl(true);
    }
    public void compressorOff(){
    	airC.setClosedLoopControl(false);
    }
    public void highGear(){
    	gearShift.set(DoubleSolenoid.Value.kForward);
    }
    public void lowGear(){
    	gearShift.set(DoubleSolenoid.Value.kReverse);
    }
}

