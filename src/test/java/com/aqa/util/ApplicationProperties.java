package com.aqa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {

    private static FileInputStream fileInputStream;
    private static Properties properties;

    static {
        try {
            final String applicationProperties = "src/test/resources/application.properties";
            fileInputStream = new FileInputStream(applicationProperties);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
