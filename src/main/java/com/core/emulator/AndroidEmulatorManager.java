package com.core.emulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndroidEmulatorManager {

        private String emulatorName;

        public AndroidEmulatorManager(String emulatorName) {
            this.emulatorName = emulatorName;
        }

        public void startEmulator() throws IOException, InterruptedException {
            if (isEmulatorRunning()) {
                System.out.println("Emulator is already running.");
                return;
            }

            ProcessBuilder processBuilder = new ProcessBuilder("emulator", "-avd", emulatorName);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    // Kiểm tra nếu đã hoàn thành quá trình boot
                    if (line.contains("Successfully loaded snapshot")) {
                        System.out.println("Emulator is ready with the loaded snapshot.");
                        break;
                    }
                }
            }

        }

        // Dừng emulator
        public void stopEmulator() throws IOException, InterruptedException {
            if (!isEmulatorRunning()) {
                System.out.println("Emulator is not running.");
                return;
            }

            ProcessBuilder processBuilder = new ProcessBuilder("adb", "-s", emulatorName, "emu", "kill");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            process.waitFor();

            System.out.println("Emulator stopped.");
        }

        public boolean isEmulatorRunning() throws IOException {
            ProcessBuilder processBuilder = new ProcessBuilder("adb", "devices");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(emulatorName)) {
                        return true;
                    }
                }
            }
            return false;
        }

}
