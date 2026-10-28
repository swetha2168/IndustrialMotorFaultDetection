
package com.ece;

import java.util.ArrayList;
import java.util.List;

public class MotorFaultDetector {

    public List<String> detectFaults(
            double current,
            int rpm,
            double temperature,
            double vibration) {

        if (!Double.isFinite(current) || current < 0
                || rpm < 0
                || !Double.isFinite(temperature)
                || !Double.isFinite(vibration)
                || vibration < 0) {
            throw new IllegalArgumentException(
                    "Invalid motor sensor readings");
        }

        List<String> faults = new ArrayList<>();

        if (current > 10) {
            faults.add("Overload");
        }

        if (vibration > 7) {
            faults.add("Bearing Problem");
        }

        if (temperature > 80) {
            faults.add("Overheating");
        }

        if (rpm < 1000 || rpm > 1800) {
            faults.add("Abnormal Speed");
        }

        if (faults.isEmpty()) {
            faults.add("Normal");
        }

        return faults;
    }
}
