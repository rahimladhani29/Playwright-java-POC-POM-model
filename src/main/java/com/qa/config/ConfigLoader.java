package com.qa.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private final Properties prop = new Properties();

    public Properties initProperties() {
        String env = System.getProperty("env", "qa"); // default qa
        String fileName = "config/" + env + ".properties";

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                throw new RuntimeException("Could not find config file: " + fileName);
            }
            prop.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties: " + fileName, e);
        }
        return prop;
    }
}
