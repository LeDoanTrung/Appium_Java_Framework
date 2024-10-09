package com.core.emulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndroidEmulatorManager {

    private static final String EMULATOR_NAME = "emulator-5554"; // Change this to your emulator name

    public static void startEmulator() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("emulator", "-avd", EMULATOR_NAME);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("boot completed")) {
                    break;
                }
            }
        }
        process.waitFor();
    }

    public static void stopEmulator() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("adb", "-s", EMULATOR_NAME, "emu", "kill");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        process.waitFor();
    }

    public static boolean isEmulatorRunning() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("adb", "devices");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(EMULATOR_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }
}
