package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SelectEnginePowerPage extends BasePage {
    private static final String URL_ENDING = "selectEnginePower";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='Wie viele PS hat dein Auto?']");

    SelectEnginePowerPage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public SelectEnginePage selectEnginePower(String power) {
        $(By.xpath("//button[@name='enginePower']//label[text()='" + power + "']")).click();
        return new SelectEnginePage();
    }
}
