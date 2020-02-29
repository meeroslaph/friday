package pages;

import org.openqa.selenium.By;

public class SelectPreconditionPage extends BasePage {
    private static final String URL_ENDING = "selectPrecondition";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='In 90 Sekunden zum Beitrag']");

    public SelectPreconditionPage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public SelectRegisteredOwnerPage submitSelectPreconditionPage() {
        new CommonElements().submit();
        return new SelectRegisteredOwnerPage();
    }

}
