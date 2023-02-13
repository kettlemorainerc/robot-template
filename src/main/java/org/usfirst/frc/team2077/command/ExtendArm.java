package org.usfirst.frc.team2077.command;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import org.usfirst.frc.team2077.RobotHardware;
import org.usfirst.frc.team2077.common.command.RepeatedCommand;

public class ExtendArm extends RepeatedCommand {
    private final Spark arm;
    //TODO: right motor type?

    private final ArmDirection direction;
    private final double speed = 0.2;


    public enum ArmDirection{
        EXTEND(1),
        RETRACT(-1);
        private final int direction;
        ArmDirection(int direction) {
            this.direction = direction;
        }
        public int getDirection(){
            return direction;
        }
    }

    public ExtendArm(RobotHardware hardware, ArmDirection direction){
        arm = hardware.arm;
        this.direction = direction;
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        arm.stopMotor();
    }

    @Override
    public void initialize() {
        arm.set(speed*direction.getDirection());
    }
}
