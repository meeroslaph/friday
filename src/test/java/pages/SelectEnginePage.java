package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SelectEnginePage extends BasePage {
    private static final String URL_ENDING = "selectEngine";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='Ist dein Auto dabei?']");

    SelectEnginePage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public EnterRegistrationDatePage selectEngine(String engine, String model) {
        $(By.xpath(
            "//button[@name='engine']//div[label[text()='" + engine + "'] and p[text()='" + model + "']]")).click();
        return new EnterRegistrationDatePage();
    }
}
