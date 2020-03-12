package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.commands.LaunchBall;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class SensorSystem extends Subsystem {

    private final ColorSensorV3 cSensor;// c
    private final ColorMatch matcher;

    private final AnalogInput ultrasonic = new AnalogInput(Robot.UltrasonicPort); //

    private final Color Blue = ColorMatch.makeColor(0.170, 0.444, 0.386);
    private final Color Green = ColorMatch.makeColor(0.210, 0.530, 0.260);
    private final Color Red = ColorMatch.makeColor(0.387, 0.406, 0.201);
    private final Color Yellow = ColorMatch.makeColor(0.230, 0.511, 0.191);

    private static final double ValueToMeters = 0.003175;

    public String colorDetect;

    public SensorSystem() {
        cSensor = new ColorSensorV3(Robot.i2cport);
        matcher = new ColorMatch();
        matcher.addColorMatch(Blue);
        matcher.addColorMatch(Green);
        matcher.addColorMatch(Red);
        matcher.addColorMatch(Yellow);
    }

    public void initDefaultCommand() {
    }

    public void periodic() {
    }

    public String colorString(ColorMatchResult cmr) {
        if (cmr.color == this.Blue) {
            return "Blue";
        }

        else if (cmr.color == this.Green) {
            return "Green";
        }

        else if (cmr.color == this.Red) {
            return "Red";
        }
        
        else if (cmr.color == this.Yellow) {
            return "Yellow";
        }

        else {
            return "None";
        }
    }

    public void detectColor() {
        Color detected = cSensor.getColor();
        ColorMatchResult match = matcher.matchClosestColor(detected);
        String color = colorString(match);
        colorDetect = color;
        SmartDashboard.putString("Colour", color);
    }

    public void getDistance() {
        double dist = ultrasonic.getValue() * ValueToMeters;
        String distance = dist + " m";
        SmartDashboard.putString("Distance", distance);
    }

}