package org.usfirst.frc.team6002.robot;

import org.usfirst.frc.team6002.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc.team6002.robot.commands.ExampleCommand;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	  private Joystick controller;
	  
	  //Values that FRC gave to reference these axis
	  private int leftYAxis = 1;
	  private int rightYAxis = 5;
	  private int rightXAxis = 4;
	  private Button aButton;
	  
	public OI() {
		controller = new Joystick(0);
		aButton = new JoystickButton(controller, 1);
		
		aButton.whenPressed(new SetGearArmPosition(Robot.gearArm.getIntakePosition()));

		//aButton.toggleWhenPressed(new SetGearArmPosition(.25));
	}
	
	//gets the values of the controller joysticks
	public double getLeftY() {
	    return -controller.getRawAxis(leftYAxis); //Left Joystick y-axis
	}
	
	public double getRightY() {
	    return controller.getRawAxis(rightYAxis); //Right Joystick y-axis 
	}
	public double getRightX(){
		return controller.getRawAxis(rightXAxis);
	}
	    
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
