package ch.eiafr.gmd.helpers;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    private static final String CONFIG_FILE = "/ch/eiafr/gmd/config/config.properties";

    static {
        try {
            properties.load(Config.class.getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            
            System.exit(-1);
        }
    }

    public static int getIntValue(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}