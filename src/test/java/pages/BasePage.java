package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;

abstract class BasePage {

    /**
     * Each page object calls the BasePage constructor that checks whether a proper page is shown to a user by checking
     * unique page locator, URL ending, and page title.
     * @param urlEnding trailing part of URL that comes after the last "/" and is unique for each page.
     * @param pageLocator locator that uniquely represents a page object.
     */
    BasePage(final String urlEnding, final By pageLocator) {
        $(pageLocator).shouldBe(visible);
        checkUrl(urlEnding);
        checkPageTitle();
    }

    /**
     * @throws IllegalStateException if URL ending differs from the expected one.
     */
    private void checkUrl(String urlEnding) {
        String actualUrlEnding = url().substring(url().lastIndexOf("/") + 1);

        if (!actualUrlEnding.equals(urlEnding)) {
            throw new IllegalStateException(generateExceptionMessage("URL ending", urlEnding, actualUrlEnding));
        }
    }

    /**
     * @throws IllegalStateException if page title differs from the expected one.
     */
    private void checkPageTitle() {
        String pageTitle = "FRIDAY Autoversicherung. In nur 90 Sekunden zu deinem Angebot!";
        String actualPageTitle = title();

        if (!actualPageTitle.equals(pageTitle)) {
            throw new IllegalStateException(generateExceptionMessage("page title", pageTitle, actualPageTitle));
        }
    }

    private String generateExceptionMessage(String matter, String expectedValue, String actualValue) {
        return String.format("Wrong %s. Expected: '%s'; Actual: '%s'", matter, expectedValue, actualValue);
    }
}