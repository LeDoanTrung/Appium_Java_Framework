package com.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonHelper {

    public static String readJsonFile(String filePath) throws IOException {
            Path currentDirectoryPath = Paths.get("").toAbsolutePath();
            Path fullPath = currentDirectoryPath.resolve(filePath);

            if (!Files.exists(fullPath)) {
                throw new IOException("Can't find file: " + fullPath.toString());
            }

            return new String(Files.readAllBytes(fullPath));
    }

    public static <T> T readAndParse(String path, Class<T> clazz) throws IOException {
        String jsonContent = readJsonFile(path);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonContent, clazz);
    }



}
