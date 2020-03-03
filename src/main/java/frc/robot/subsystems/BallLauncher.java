// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class BallLauncher extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private PWMVictorSPX launchMotorL;
    private PWMVictorSPX launchMotorR;
    private PWMVictorSPX intakeMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public BallLauncher() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        launchMotorL = new PWMVictorSPX(3);
        addChild("Launch Motor L",launchMotorL);
        launchMotorL.setInverted(false);
                
        intakeMotor = new PWMVictorSPX(1);
        addChild("Intake Motor",intakeMotor);
        intakeMotor.setInverted(false);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        launchMotorR = new PWMVictorSPX(2);
        launchMotorR.setInverted(true);

    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void Intake(Joystick xboxController) {
        double getY = xboxController.getY(Hand.kLeft);
        intakeMotor.set(getY);
    }

    public void LaunchSpeed(double x) {
        launchMotorL.set(x);
        launchMotorR.set(x);
    }

    public void endLaunch() {
        launchMotorL.set(0.0); // Set the speed to zero first
        launchMotorL.stopMotor(); // Stop the motor (Deconstructor)
        launchMotorR.set(0.0); // Set the speed to zero first
        launchMotorR.stopMotor(); // Stop the motor (Deconstructor)       
    }
}

