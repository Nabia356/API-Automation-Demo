package utilities;

public class ApplicationConfiguration {

    private static final String baseURL = DefaultConfiguration.getProperty("BaseURL");

    public static String getBaseURL() {
        return baseURL;
    }
}
