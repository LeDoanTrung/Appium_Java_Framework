package com.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataReaderHelper {

    public static <T> T getData(String filePath, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T data = null;
        try {
            // Read the file and convert it to the given class type
            data = objectMapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
