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
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private PWMVictorSPX leftMotor;
    private PWMVictorSPX rightMotor;
    private DifferentialDrive differentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    //Gearbox encoders
    private Encoder encoderL;
    private Encoder encoderR;

    //Gain for simple P loop
    private double kP = 1;

    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftMotor = new PWMVictorSPX(9);
        addChild("Left Motor",leftMotor);
        leftMotor.setInverted(false);
                
        rightMotor = new PWMVictorSPX(0);
        addChild("Right Motor",rightMotor);
        rightMotor.setInverted(false);
                
        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        addChild("Differential Drive",differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        encoderL = new Encoder(0, 1);
        encoderL.setDistancePerPulse( 1. / (4096 * 6 * Math.PI));
        encoderR = new Encoder(2, 3);
        encoderR.setDistancePerPulse( 1. / (4096 * 6 * Math.PI));
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ArcadeDrive());

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
    
    // Drive function
    
    public void autonomous()
    {
        double leftMD = encoderL.getDistance(); //left motor distance
        double rightMD = encoderR.getDistance(); //right motor distance
        double averageDistance = (leftMD+rightMD)/2; //average of the 2

        if (averageDistance <= 117)
            differentialDrive.arcadeDrive(0.5, 0.0);
        else
            differentialDrive.arcadeDrive(0.0, 0.0);

    }
    
    public void drive(Joystick xboxController) {
        //Get raw X and Y values from Left Joystick on Controller 1
        double getX = xboxController.getX(Hand.kLeft);
        double getY = xboxController.getY(Hand.kLeft);

        //Deadband to account for joystick being offset in neutral
        if(Math.abs(getX) < 0.05) {
            getX = 0;
        }

        if(Math.abs(getY) < 0.05) {
            getY = 0;
        }

        //Heading error
        double error = encoderL.getDistance() - encoderR.getDistance();
        
        if(Math.abs(getX) < 0.1 && getY != 0) {

            differentialDrive.tankDrive(getY + kP * error, getY - kP * error);

            SmartDashboard.putNumber("Left Encoder", encoderL.getDistance());
            SmartDashboard.putNumber("Right Encoder", encoderR.getDistance());
            SmartDashboard.putNumber("Heading Error", error);
        }

        //Drive the bot using the values
        differentialDrive.arcadeDrive(-getY, getX);
        SmartDashboard.putNumber("Left Encoder", encoderL.getDistance());
        SmartDashboard.putNumber("Right Encoder", encoderR.getDistance());
        SmartDashboard.putNumber("Heading Error", error);
    }
}