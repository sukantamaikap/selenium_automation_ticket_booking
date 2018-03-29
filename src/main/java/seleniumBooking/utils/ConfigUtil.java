package seleniumBooking.utils;


import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Util for running
 */
public final class ConfigUtil {
    private static final String CONFIG_FILE_PATH = "/home/smaikap/sandbox/java/selenium_automation_ticket_booking/src/main/java/seleniumBooking/config.properties";

    private ConfigUtil() {

    }

    private static Properties readProperties() throws IOException {
        final Properties properties = new Properties();
        FileInputStream fileInput = null;
        try {
            final File file = new File(CONFIG_FILE_PATH);
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
            Assert.fail("config file not found !!!");
            return null;
        }

        return readProperties().getProperty("browser");
    }
}
