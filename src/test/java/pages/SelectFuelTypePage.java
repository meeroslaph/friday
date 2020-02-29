package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SelectFuelTypePage extends BasePage {
    private static final String URL_ENDING = "selectFuelType";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='Was tankst du?']");

    SelectFuelTypePage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public SelectEnginePowerPage selectFuelType(String fuel) {
        $(By.xpath("//button[@name='fuelType']//label[text()='" + fuel + "']")).click();
        return new SelectEnginePowerPage();
    }
}
