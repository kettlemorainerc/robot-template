package org.usfirst.frc.team2077;

import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj2.command.*;
import org.usfirst.frc.team2077.common.drivetrain.*;
import org.usfirst.frc.team2077.common.subsystems.*;

public class RobotHardware implements org.usfirst.frc.team2077.common.RobotHardware<SparkNeoDriveModule> {
    private final Subsystem HEADING = new Subsystem() {};
    private final Subsystem POSITION = new Subsystem() {};
    private final AbstractChassis CHASSIS;

    public RobotHardware() {
        CHASSIS = new MecanumChassis(this);
    }

    @Override public Subsystem getHeading() {
        return HEADING;
    }

    @Override public Subsystem getPosition() {
        return POSITION;
    }

    @Override public AbstractChassis getChassis() {
        return CHASSIS;
    }

    @Override public AHRS getNavX() {
        return null;
    }

    @Override public CANLineSubsystem<SparkNeoDriveModule> getWheel(MecanumMath.WheelPosition position) {
        return null;
    }
}
