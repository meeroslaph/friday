package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.SelectPreconditionPage;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserCapabilities;
import static com.codeborne.selenide.Configuration.remote;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

abstract class BaseTest {
    SelectPreconditionPage selectPreconditionPage;

    /**
     * The method runs before a test suite execution starts. It adds {@link AllureSelenide} listener needed for Allure
     * report generation and prepares a browser object according to the desired environment.
     *
     * Throws {@link IllegalStateException} if the desired environment is not supported.
     * @see SelenideLogger
     * @see Config
     */
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        baseUrl = Config.BASE_URL;
        browser = Config.BROWSER;
        startMaximized = Boolean.parseBoolean(Config.START_MAXIMIZED);
        timeout = Long.parseLong(Config.TIMEOUT);

        switch (Config.ENV) {
            case "local":
                break;
            case "remote":
                remote = Config.REMOTE;
                break;
            case "saucelabs":
                String browserVersion = Config.BROWSER_VERSION;
                String platform = Config.PLATFORM;

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("browserVersion", browserVersion);
                capabilities.setCapability("platformName", platform);
                capabilities.setCapability("name", "Test");

                remote = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub",
                    Config.SAUCE_USER, Config.SAUCE_KEY);
                browserCapabilities = capabilities;
                break;
            default:
                throw new IllegalStateException("Environment system property '" + Config.ENV + "' is not supported");
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void openHomePage() {
        open(baseUrl);
        selectPreconditionPage = new SelectPreconditionPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }

}
