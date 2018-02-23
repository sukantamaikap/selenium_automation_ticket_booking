package seleniumBooking.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Util for running
 */
public final class ConfigUtil {

    private ConfigUtil() {

    }

    private static Properties readProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInput = null;
        try {
            File file = new File("test.properties");
            fileInput = new FileInputStream(file);
            properties.load(fileInput);
        } finally {
            fileInput.close();
        }
        return properties;
    }

    public static String getBaseUrl() throws IOException {
        if (readProperties() == null) {
            return null;
        }

        return readProperties().getProperty("baseUrl");
    }

    public static String getBrowser() throws IOException {
        if (readProperties() == null) {
            return null;
        }

        return readProperties().getProperty("browser");
    }
}
