package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;
    static {
        String path="deviceConfig.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties=new Properties();
            properties.load(file);
        }catch (Exception e) {
            System.out.println("Configuration file is not exist");
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
