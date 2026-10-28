
package com.ece;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        MotorFaultDetector detector = new MotorFaultDetector();

        double current = 8.0;
        int rpm = 1450;
        double temperature = 95.0;
        double vibration = 2.0;

        List<String> faults = detector.detectFaults(
                current, rpm, temperature, vibration);

        System.out.println("INDUSTRIAL MOTOR FAULT DETECTION");
        System.out.println("Current: " + current + " A");
        System.out.println("RPM: " + rpm);
        System.out.println("Temperature: " + temperature + " C");
        System.out.println("Vibration: " + vibration + " mm/s");
        System.out.println("Status: " + String.join(", ", faults));

        String html = """
                <!DOCTYPE html>
                <html>
                <head><title>Motor Fault Report</title></head>
                <body>
                <h1>Industrial Motor Fault Detection Report</h1>
                <p>Current: %s A</p>
                <p>RPM: %s</p>
                <p>Temperature: %s C</p>
                <p>Vibration: %s mm/s</p>
                <h2>Status: %s</h2>
                </body>
                </html>
                """.formatted(
                    current, rpm, temperature, vibration,
                    String.join(", ", faults));

        Path report = Path.of("reports", "motor-report.html");
        Files.createDirectories(report.getParent());
        Files.writeString(report, html);

        System.out.println("Report created: " +
                report.toAbsolutePath());
    }
}
