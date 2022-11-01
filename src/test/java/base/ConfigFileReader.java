package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    public static Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/config.properties";

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al cargar el archivo properties " + propertyFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties no se encuentra en " + propertyFilePath);
        }
    }


    public static String getProp(String keyname) {
        return properties.getProperty(keyname);
    }

}
