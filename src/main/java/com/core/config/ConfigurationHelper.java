package com.core.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigurationHelper {
    private static JsonNode config;


    public static JsonNode readConfiguration(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            config = objectMapper.readTree(new File(filePath));
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read configuration file: " + filePath);
        }
    }

    public static String getConfigurationByKey(JsonNode config, String key) {
        if (ConfigurationHelper.config == null) {
            throw new IllegalStateException("Configuration not loaded. Call readConfiguration() first.");
        }
        JsonNode valueNode = ConfigurationHelper.config.path(key);
        if (valueNode.isMissingNode()) {
            throw new IllegalArgumentException("Key not found in configuration: " + key);
        }
        return valueNode.asText();
    }
}
