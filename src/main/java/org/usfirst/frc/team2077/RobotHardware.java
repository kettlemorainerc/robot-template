package org.usfirst.frc.team2077;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.Subsystem;
import org.usfirst.frc.team2077.common.*;
import org.usfirst.frc.team2077.common.drivetrain.MecanumChassis;
import org.usfirst.frc.team2077.common.WheelPosition;
import org.usfirst.frc.team2077.common.drivetrain.SparkNeoDriveModule;
import org.usfirst.frc.team2077.common.sensor.AngleSensor;
import org.usfirst.frc.team2077.drivetrain.DrivePosition;

import java.util.*;
/*
You should replace "DRIVE_MODULE" with the type of modules your chassis uses.
Ex. SparkNeoDriveModule, SwerveModule, etc.
and replace "CHASSIS_TYPE" with the type of chassis you're using MecanumChassis, SwerveChassis, etc.
*/

/**
 * This is intended to be a spot for the definition and retrieval of all robot hardware.
 * */
public class RobotHardware extends HardwareRequirements<SparkNeoDriveModule, MecanumChassis> {
    private final MecanumChassis chassis;
    private final Map<WheelPosition, SparkNeoDriveModule> wheels = new EnumMap<>(WheelPosition.class);

    public RobotHardware(
            Subsystem heading,
            Subsystem position,
            AngleSensor angleSensor,
            AHRS navX
    ) {
        super(heading, position, angleSensor, navX);

        for(WheelPosition p : WheelPosition.values()) {
            wheels.put(p, makeWheel(p));
        }

        chassis = new MecanumChassis(this);
    }

    public RobotHardware() {
        this(
                new Subsystem() {}, // heading placeholder
                new Subsystem() {}, // position placeholder
                null, // angle sensor, if we need
                null // navX, if we need
        );
    }

    private SparkNeoDriveModule makeWheel(WheelPosition position) {
        var target = DrivePosition.forWheelPosition(position);

        return new SparkNeoDriveModule(target);
    }

    @Override public MecanumChassis getChassis() {
        return chassis;
    }

    @Override public SparkNeoDriveModule getWheel(WheelPosition pos) {
        return wheels.get(pos);
    }
}
