package com.stv.factory.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {
    private static ConfigReader instance;

    private ConfigReader() {
        try {
            if (System.getProperty("base.url") == null || System.getProperty("base.url").isEmpty()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
                properties.load(fileInputStream);
                fileInputStream.close();

                String baseUrl = properties.getProperty("base.url");
                if (baseUrl != null && !baseUrl.isEmpty()) {
                    System.setProperty("base.url", baseUrl);
                    System.out.println("[INFO] Base URL loaded from config: " + baseUrl);
                } else {
                    throw new RuntimeException("base.url is not set in config.properties");
                }
            } else {
                System.out.println("[INFO] Base URL provided via system property: " + System.getProperty("base.url"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ConfigReader getInstance() {
        if(instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    public String getData(String data) {
        return System.getProperty(data);
    }
}