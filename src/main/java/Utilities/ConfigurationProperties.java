package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProperties {

    public static Properties property;
    private static String configPath = "Configurations/Config.properties";

    public static void initializePropertyFile() throws IOException {
        property = new Properties();
        InputStream inputStream = new FileInputStream(configPath);
        property.load(inputStream);
    }
}

