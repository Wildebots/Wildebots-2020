// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

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

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton leftTrigger;
    public JoystickButton rightTrigger;
    public JoystickButton start1;
    public Joystick xbox1;

    public JoystickButton triggerL;
    public JoystickButton triggerR;
    public JoystickButton a;
    public JoystickButton back;
    public JoystickButton start2;
    public Joystick xbox2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xbox1 = new Joystick(0);
        rightTrigger = new JoystickButton(xbox1, 6);
        rightTrigger.whileHeld(new ShiftGear(Value.kForward));
        leftTrigger = new JoystickButton(xbox1, 5);
        leftTrigger.whileHeld(new ShiftGear(Value.kReverse));

        start1 = new JoystickButton(xbox1, 8);
        start1.whenPressed(new CompressorOff());

        xbox2 = new Joystick(1);
        triggerL = new JoystickButton(xbox2, 5);
        triggerL.whileHeld(new BallIntake(-0.75));
        triggerR = new JoystickButton(xbox2, 6);
        triggerR.whileHeld(new LaunchBall());

        a = new JoystickButton(xbox2, 1);
        a.whileHeld(new BallIntake(0.75));
     
        back = new JoystickButton(xbox2, 7);
        back.whileHeld(new MoveArmPiston(Value.kReverse));
        start2 = new JoystickButton(xbox2, 8);
        start2.whileHeld(new MoveArmPiston(Value.kForward));

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Arcade Drive", new ArcadeDrive());
        SmartDashboard.putData("Launch Ball", new LaunchBall());
        SmartDashboard.putData("Move Arm Piston", new MoveArmPiston());
        SmartDashboard.putData("Ball Intake", new BallIntake());
        SmartDashboard.putData("Shift Gear", new ShiftGear());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getXbox1() {
        return xbox1;
    }

    public Joystick getXbox2() {
        return xbox2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

