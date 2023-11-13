package com.kwi.config;

import org.junit.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    private static final Properties properties = new Properties();

    static {
        try {
            readProperties();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    private static void readProperties() throws IOException {
        String profile = System.getProperty("profileId");
//        properties.load(new FileReader(new File("src/test/resources/application-" + profile + ".properties"))); // CI
        properties.load(new FileReader(new File("src/test/resources/application-development.properties")));            // Dev
//        properties.load(new FileReader(new File("src/test/resources/application-system-integration.properties")));     //SI
    }

    public static String getProperty(Property propEnum) {
        return (String) properties.get(propEnum.property());
    }

}