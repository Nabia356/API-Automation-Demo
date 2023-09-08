package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class DefaultConfiguration {
    protected static Logger logger = LogManager.getLogger("connector");
    protected static final String DEFAULT_CONFIGURATION = "config/default.ini";
    protected static Properties props = new Properties();

    static {
        loadProperties(props);
    }

    protected static void loadProperties(Properties props) {
        try {
            logger.debug("Loading Default configuration:");
            props.load(new FileInputStream(DefaultConfiguration.DEFAULT_CONFIGURATION));
        } catch (Exception e) {
            logger.error("Error while loading Default configuration: " + e);
            e.printStackTrace();
        }
    }

    public static String getProperty(String name) {
        return props.getProperty(name, null);
    }
}

