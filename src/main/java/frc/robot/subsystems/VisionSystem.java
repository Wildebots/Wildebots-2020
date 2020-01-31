package frc.robot.subsystems;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class VisionSystem extends Subsystem {

    private final ColorSensorV3 sensor;
    private final ColorMatch matcher;

    private final AnalogInput ultrasonic = new AnalogInput(Robot.UltrasonicPort);

    private final Color Blue = ColorMatch.makeColor(0, 1, 1);
    private final Color Green = ColorMatch.makeColor(0, 1, 0);
    private final Color Red = ColorMatch.makeColor(1, 0, 0);
    private final Color Yellow = ColorMatch.makeColor(1, 1, 0);

    private static final double ValueToInches = 0.125;

    private Color detect;

    public VisionSystem() {
        sensor = new ColorSensorV3(Robot.i2cport);
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
        if (cmr.color == Blue) {
            return "Blue";
        }

        else if (cmr.color == Green) {
            return "Green";
        }

        else if (cmr.color == Red) {
            return "Red";
        }
        
        else if (cmr.color == Yellow) {
            return "Yellow";
        }

        else {
            return "None";
        }
    }

    public void detectColor() {
        Color detected = sensor.getColor();
        ColorMatchResult match = matcher.matchClosestColor(detected);
        detect = match.color;
        String color = colorString(match);
        SmartDashboard.putString("Color", color);
    }

    public void getDistance() {
        double distance = ultrasonic.getValue() * ValueToInches;
        System.out.println(distance);
    }

}