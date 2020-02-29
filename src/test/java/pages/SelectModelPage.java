package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class SelectModelPage extends BasePage {
    private static final String URL_ENDING = "selectModel";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='Wähle dein Automodell']");

    SelectModelPage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public SelectBodyTypePage selectModel(String model) {
        $(By.xpath("//button[@name='model']//label[text()='" + model + "']")).click();
        return new SelectBodyTypePage();
    }
}
