package com.test.fedexhomepage.configuration;

public class Property {

    private static final String CHROME = "CHROME";
    private static final String BROWSER = "browser";
    private static final String TIMEOUT = "timeout";
    private static final String DEFAULT_TIMEOUT = "20";
    private static final String BASE_URL = "base_url";
    private static final String DEFAULT_BASE_URL = "https://www.fedex.com";
    private static final String INVALID_TRACK_ID = "invalid_track_id";


    public static String getBrowser() {
        return System.getProperty(BROWSER, CHROME);
    }

    public static int getTimeout() {
        return Integer.parseInt(System.getProperty(TIMEOUT, DEFAULT_TIMEOUT));
    }

    public static String getBaseUrl() {
        return System.getProperty(BASE_URL, DEFAULT_BASE_URL);
    }

    public static String getInvalidTrackId() {
        return System.getProperty(INVALID_TRACK_ID, "test");
    }

}
