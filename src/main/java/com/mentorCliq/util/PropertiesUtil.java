package com.mentorCliq.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    public static int readPropertiesFileByKey(String key) {

        try (InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream("requiredPercent.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            return Integer.parseInt(prop.getProperty(key));

        } catch (IOException ex) {
            throw new RuntimeException("Properties file doesn't exist");
        }
    }
}
