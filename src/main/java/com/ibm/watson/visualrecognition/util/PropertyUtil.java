package com.ibm.watson.visualrecognition.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

	private static PropertyUtil instance = null;
    private Properties properties;


    protected PropertyUtil() throws IOException{

        properties = new Properties();
        properties.load(getClass().getResourceAsStream("/bluemix.properties"));

    }

    public static PropertyUtil getInstance() {
        if(instance == null) {
            try {
                instance = new PropertyUtil();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
