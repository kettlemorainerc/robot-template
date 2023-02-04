package org.usfirst.frc.team2077.common.command;

import org.junit.jupiter.api.*;
import org.usfirst.frc.team2077.common.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.usfirst.frc.team2077.common.VelocityDirection.*;
import static org.usfirst.frc.team2077.common.WheelPosition.*;

class MoveTest {
    private MoveTestHardware hardware;
    private Move move;

    MoveTest() {
        this.hardware = new MoveTestHardware();
    }
    
    @BeforeEach void before() {
        clock = 0;
        hardware.chassis.getActualPosition().set(0, 0, 0);
        hardware.chassis.getActualPositionMeasured().set(0, 0, 0);
        
        move = null;
    }

    @Test void bot_goes_north() {
        useMove(new Move(hardware, 10, 0, 0));
        tick(0, 0, 0);
        tick(2, 0, 0);
        tick(4, 0, 0);
        tick(6, 0, 0);
        tick(8, 0, 0);
        tick(10, 0, 0);
        tick(10, 0, 0);
        assertTrue(move.isFinished());
    }

    @Test void bot_goes_east() {
        useMove(new Move(hardware, 0, 10, 0));
        tick(0, 0, 0);
        tick(0, 2, 0);
        tick(0, 4, 0);
        tick(0, 6, 0);
        tick(0, 8, 0);
        tick(0, 10, 0);
        tick(0, 10, 0);
        assertTrue(move.isFinished());
    }
    
    @Test public void bot_goes_north_and_east() {
        useMove(new Move(hardware, 10, 10, 0));
        tick(0, 0, 0);
        tick(2, 2, 0);
        tick(4, 4, 0);
        tick(6, 6, 0);
        tick(8, 8, 0);
        tick(10, 10, 0);
        tick(10, 10, 0);
        assertTrue(move.isFinished());
    }

    @Test public void bot_rotates() {
        useMove(new Move(hardware, 50));

        tick(0, 0, 0);
        tick(0, 0, 10);
        tick(0, 0, 20);
        tick(0, 0, 30);
        tick(0, 0, 40);
        tick(0, 0, 50);
        tick(0, 0, 50);
        assertTrue(move.isFinished());
    }

    @Test public void bot_does_everything() {
        useMove(new Move(hardware, 10, 10, 50));

        tick();
        tick();
        tick();
        tick();
        tick();
        tick();
        tick();
    }

    private void useMove(Move move) {
        this.move = move;
        this.move.initialize();
    }

    private void tick(double positionN, double positionE, double positionR) {
        tick(positionN, positionE, positionR, true);
    }

    private void tick() {
        tick(0, 0, 0, false);
    }

    private void tick(double positionN, double positionE, double positionR, boolean test) {
        var chassis = hardware.getChassis();

        chassis.periodic();
        move.execute();
        boolean done = move.isFinished();
        if(done) move.end(false);

        var position = chassis.getPosition();
        System.out.println(position + " | done: " + done);

        if(test) {
            assertArrayEquals(
                  new double[] {positionN, positionE, positionR},
                  position.get(),
                  0.01
            );
        }
    }


    public static final double CHANGE_IN_TIME = 0.2;
    private static double clock = 0;
    private static double getNext() {
        clock += CHANGE_IN_TIME;
        return clock;
    }

    private static class MoveTestHardware extends HardwareRequirements<TestDriveModule, TestChassis> {
        private final Map<WheelPosition, TestDriveModule> modules;
        private final TestChassis chassis;
        
        MoveTestHardware() {
            this.modules = Map.of(
                  FRONT_LEFT, makeWheel(FRONT_LEFT),
                  FRONT_RIGHT, makeWheel(FRONT_RIGHT),
                  BACK_LEFT, makeWheel(BACK_LEFT),
                  BACK_RIGHT, makeWheel(BACK_RIGHT)
            );

            this.chassis = new TestChassis(this, MoveTest::getNext);
        }

        @Override public TestChassis getChassis() {
            return chassis;
        }

        @Override public TestDriveModule getWheel(WheelPosition pos) {
            return modules.get(pos);
        }
        
        private static TestDriveModule makeWheel(WheelPosition pos) {
            return new TestDriveModule(pos, TestChassis.MAX_WHEEL_VELOCITY);
        }
    }
}