package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class EnterRegistrationDatePage extends BasePage {
    private static final String URL_ENDING = "enterRegistrationDate";
    private static final By PAGE_LOCATOR = By.xpath("//span[text()='Wann war die Erstzulassung?']");

    EnterRegistrationDatePage() {
        super(URL_ENDING, PAGE_LOCATOR);
    }

    public EnterRegistrationDatePage enterRegistrationDate(String date) {
        $("input[name='monthYearFirstRegistered']").sendKeys(date);
        return this;
    }

    public EnterBirthDatePage submitEnterRegistrationDatePage() {
        new CommonElements().submit();
        return new EnterBirthDatePage();
    }
}
