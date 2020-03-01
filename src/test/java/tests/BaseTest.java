package tests;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SelectPreconditionPage;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

abstract class BaseTest {
    SelectPreconditionPage selectPreconditionPage;

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "https://hello.friday.de";
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.browser = Browsers.CHROME;

        open(baseUrl);
        selectPreconditionPage = new SelectPreconditionPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }

}
