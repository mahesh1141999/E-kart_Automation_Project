package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties intializeProperties() throws IOException {
        Properties prop = new Properties();
        File proFile= new File(System.getProperty("user.dir")+"\\src\\res\\config\\config.properties");
        FileInputStream fis = new FileInputStream(proFile);
        prop.load(fis);
     return prop;
    }
}
