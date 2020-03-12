package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ChangeSpeed extends Command {
    
    public ChangeSpeed() {
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        int pov = Robot.oi.getXbox2().getPOV();
        SmartDashboard.putNumber("D-Pad", pov);

        switch(pov) {
            case 0:
                Robot.ballLauncher.changeSpeed(0.25);
            case 180:
                Robot.ballLauncher.changeSpeed(-0.25);
            default:
                Robot.ballLauncher.changeSpeed(0.0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}