package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class represents common web elements that occur in multiple pages. It eliminates code duplication and supports
 * Composition Over Inheritance principle.
 */
class CommonElements {
    private final By submitButton = By.cssSelector("button[type='submit']");

    void submit() {
        $(submitButton).click();
    }

    boolean isSubmitButtonActive() {
        return !$(submitButton).attr("class").contains("Button__disabled");
    }

}