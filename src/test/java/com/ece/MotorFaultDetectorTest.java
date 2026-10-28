
package com.ece;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

class MotorFaultDetectorTest {

    private final MotorFaultDetector detector =
            new MotorFaultDetector();

    @Test
    void testOverload() {
        assertTrue(detector.detectFaults(12, 1450, 50, 2)
                .contains("Overload"));
    }

    @Test
    void testBearingProblem() {
        assertTrue(detector.detectFaults(8, 1450, 50, 9)
                .contains("Bearing Problem"));
    }

    @Test
    void testOverheating() {
        assertTrue(detector.detectFaults(8, 1450, 90, 2)
                .contains("Overheating"));
    }

    @Test
    void testAbnormalSpeed() {
        assertTrue(detector.detectFaults(8, 800, 50, 2)
                .contains("Abnormal Speed"));
    }

    @Test
    void testNormalMotor() {
        assertEquals(List.of("Normal"),
                detector.detectFaults(8, 1450, 50, 2));
    }

    @Test
    void testInvalidCurrent() {
        assertThrows(IllegalArgumentException.class,
                () -> detector.detectFaults(-1, 1450, 50, 2));
    }
}
