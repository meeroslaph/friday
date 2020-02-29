package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SelectVehiclePage extends BasePage {
    private static final String URL_ENDING = "selectVehicle";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='Wähle dein Auto aus']");

    SelectVehiclePage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public SelectModelPage selectVehicle(String vehicle) {
        $(By.xpath("//button[@name='make']//label[text()='" + vehicle + "']")).click();
        return new SelectModelPage();
    }
}