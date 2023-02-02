package org.usfirst.frc.team2077;

import org.usfirst.frc.team2077.common.*;

import java.util.*;
/*
You should replace "SparkNeoDriveModule" with the type of modules your chassis uses.
Ex. SparkNeoDriveModule, SwerveModule, etc.
and replace "MecanumChassis" with the type of chassis you're using MecanumChassis, SwerveChassis, etc.
*/

/**
 * This is intended to be a spot for the definition and retrieval of all robot hardware.
 * */
public class RobotHardware extends HardwareRequirements<DRIVE_MODULE, CHASSIS_TYPE> {
    private final CHASSIS_TYPE chassis;
    private final Map<WheelPosition, DRIVE_MODULE> wheels = new EnumMap<>(WheelPosition.class);

    public RobotHardware() {
        super();

        for(WheelPosition p : WheelPosition.values()) {
            wheels.put(p, makeWheel(p));
        }

        chassis = new CHASSIS_TYPE(this);
    }

    private DRIVE_MODULE makeWheel(WheelPosition position) {
        return switch(position) {
            case FRONT_LEFT -> new DRIVE_MODULE();
            case FRONT_RIGHT -> new DRIVE_MODULE();
            case BACK_LEFT -> new DRIVE_MODULE();
            case BACK_RIGHT -> new DRIVE_MODULE();
            default -> throw new IllegalArgumentException("Unsupported Wheel position: " + position);
        };
    }

    @Override public CHASSIS_TYPE getChassis() {
        return chassis;
    }

    @Override public DRIVE_MODULE getWheel(WheelPosition pos) {
        return wheels.get(pos);
    }
}
