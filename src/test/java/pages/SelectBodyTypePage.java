package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SelectBodyTypePage extends BasePage {
    private static final String URL_ENDING = "selectBodyType";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='Welche Form hat das Auto?']");

    SelectBodyTypePage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public SelectFuelTypePage selectBodyType(String body) {
        $(By.xpath("//button[@name='bodyType']//label[text()='" + body + "']")).click();
        return new SelectFuelTypePage();
    }
}
