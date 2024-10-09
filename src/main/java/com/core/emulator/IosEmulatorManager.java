package com.core.emulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IosEmulatorManager {

    private static final String EMULATOR_NAME = "iOS Simulator"; // Change this to your iOS emulator name

    public static void startEmulator() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("xcrun", "simctl", "boot", EMULATOR_NAME);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("booted")) {
                    break;
                }
            }
        }
        process.waitFor();
    }

    public static void stopEmulator() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("xcrun", "simctl", "shutdown", EMULATOR_NAME);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        process.waitFor();
    }

    public static boolean isEmulatorRunning() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("xcrun", "simctl", "list", "devices");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(EMULATOR_NAME) && line.contains("(Booted)")) {
                    return true;
                }
            }
        }
        return false;
    }
}
