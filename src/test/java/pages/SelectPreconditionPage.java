package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SelectPreconditionPage extends BasePage {
    private static final String URL_ENDING = "selectPrecondition";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='In 90 Sekunden zum Beitrag']");

    private final By invalidDateError = By.cssSelector("div[class^='ValidationLabel']");

    public SelectPreconditionPage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public SelectRegisteredOwnerPage submitSelectPreconditionPage() {
        new CommonElements().submit();
        return new SelectRegisteredOwnerPage();
    }

    public SelectPreconditionPage enterInsuranceStartDate(String date) {
        $("input[name='inceptionDate']").setValue(date);
        return this;
    }

    public boolean isInvalidDateErrorMessageDisplayed() {
        return $(invalidDateError).isDisplayed();
    }

    public boolean isSubmitButtonEnabled() {
        return new CommonElements().isSubmitButtonActive();
    }

    public String getInvalidDateErrorMessage() {
        return $(invalidDateError).text();
    }
}
