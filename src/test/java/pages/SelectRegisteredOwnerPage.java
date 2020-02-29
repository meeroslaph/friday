package pages;

import org.openqa.selenium.By;

public class SelectRegisteredOwnerPage extends BasePage {
    private static final String URL_ENDING = "selectRegisteredOwner";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='Wird das Auto auf dich zugelassen?']");

    SelectRegisteredOwnerPage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public SelectVehiclePage submitSelectRegisteredOwnerPage() {
        new CommonElements().submit();
        return new SelectVehiclePage();
    }
}
