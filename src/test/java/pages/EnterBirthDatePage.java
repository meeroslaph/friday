package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class EnterBirthDatePage extends BasePage {
    private static final String URL_ENDING = "enterBirthDate";
    private static final By PAGE_LOCATOR = By.xpath("//div[text()='Wann wurdest du geboren?']");

    EnterBirthDatePage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public boolean isBirthdayInputDisplayed() {
        return $("input[name='birthDate']").isDisplayed();
    }
}
