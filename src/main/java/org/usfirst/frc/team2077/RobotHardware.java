package org.usfirst.frc.team2077;

import com.kauailabs.navx.frc.*;
import edu.wpi.first.wpilibj2.command.*;
import org.usfirst.frc.team2077.common.WheelPosition;
import org.usfirst.frc.team2077.common.drivetrain.*;
import org.usfirst.frc.team2077.common.sensor.AngleSensor;


/**
 * To prepare this class for actual use you'll need to replace all instances of `/*DRIVE_MODULE&#42;/`
 * with your chassis' wheel module type.
 * As well as replacing all instances of `/*CHASSIS_TYPE&#42;/` with the robot's actual chassis type.
 * <br /><br />
 * In the case of something like a mecanum driven chassis you might replace `/*DRIVE_MODULE&#42;/` with
 * {@link org.usfirst.frc.team2077.common.subsystem.CANLineSubsystem.SparkNeo CANLineSubsystem.SparkNeo}
 * and `/*CHASSIS_TYPE&#42;/` with {@link MecanumChassis}
 * */
public class RobotHardware implements org.usfirst.frc.team2077.common.RobotHardware</*DRIVE_MODULE*/, /*CHASSIS_TYPE*/> {
    private final Subsystem HEADING = new Subsystem() {};
    private final Subsystem POSITION = new Subsystem() {};
    private final /*CHASSIS_TYPE*/ CHASSIS;

    public RobotHardware() {
        CHASSIS = new /*CHASSIS_TYPE*/(this);
    }

    @Override public Subsystem getHeading() {
        return HEADING;
    }

    @Override public Subsystem getPosition() {
        return POSITION;
    }

    @Override public AbstractChassis</*DRIVE_MODULE*/> getChassis() {
        return CHASSIS;
    }

    @Override public AHRS getNavX() {
        return null;
    }

    @Override public AngleSensor getAngleSensor() {
        return null;
    }

    @Override public /*DRIVE_MODULE*/ getWheel(WheelPosition position) {
        return null;
    }
}
