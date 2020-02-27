package frc.robot.subsystems;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class SensorSystem extends Subsystem {

    private final ColorSensorV3 cSensor;// c
    private final ColorMatch matcher;

    private final AnalogInput ultrasonic = new AnalogInput(Robot.UltrasonicPort); //

    private final Color Blue = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color Green = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color Red = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color Yellow = ColorMatch.makeColor(0.361, 0.524, 0.113);

    private static final double ValueToInches = 0.125;

    private Color detect;

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
        //String value = ("(" + String.valueOf(cSensor.getRed()) + ", " + String.valueOf(cSensor.getGreen()) + ", " + String.valueOf(cSensor.getBlue()) + ")");
        ColorMatchResult match = matcher.matchClosestColor(detected);
        detect = match.color;
        String color = colorString(match);
        //System.out.println(value);
        System.out.println(color);
    }

    public void getDistance() {
        double distance = ultrasonic.getValue() * ValueToInches;
        System.out.println(distance);
    }

}