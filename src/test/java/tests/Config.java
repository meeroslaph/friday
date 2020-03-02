package tests;

abstract class Config {
    public static final String ENV = System.getProperty("env", "local");
    public static final String REMOTE = System.getProperty("remote", "http://localhost:4444/wd/hub");
    public static final String BASE_URL = System.getProperty("baseUrl", "https://hello.friday.de");
    public static final String BROWSER = System.getProperty("browser", "chrome");
    public static final String BROWSER_VERSION = System.getProperty("browserVersion", "80");
    public static final String START_MAXIMIZED = System.getProperty("startMaximized", "true");
    public static final String PLATFORM = System.getProperty("platform", "Mojave 10.14");
    public static final String TIMEOUT = System.getProperty("timeout", "10000");

    public static final String SAUCE_USER = System.getenv("SAUCE_USERNAME");
    public static final String SAUCE_KEY = System.getenv("SAUCE_ACCESS_KEY");
}
