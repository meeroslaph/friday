package tests;

import org.testng.annotations.BeforeMethod;
import pages.SelectPreconditionPage;
import static com.codeborne.selenide.Selenide.open;

abstract class BaseTest {
    SelectPreconditionPage selectPreconditionPage;

    @BeforeMethod
    public void setUp() {
        open("https://hello.friday.de");
        selectPreconditionPage = new SelectPreconditionPage();
    }
}
