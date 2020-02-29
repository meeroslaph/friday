package tests;

import org.testng.annotations.Test;
import pages.EnterBirthDatePage;
import static org.assertj.core.api.Assertions.assertThat;

public class SalesFunnelTest extends BaseTest {

    @Test
    public void userShouldBeAbleToSelectCar() {
        EnterBirthDatePage enterBirthDatePage = selectPreconditionPage
            .submitSelectPreconditionPage()
            .submitSelectRegisteredOwnerPage()
            .selectVehicle("BMW")
            .selectModel("1er")
            .selectBodyType("Cabrio")
            .selectFuelType("Benzin")
            .selectEnginePower("105 kW / 143 PS")
            .selectEngine("118I CABRIO", "HSN: 0005, TSN: AQN")
            .enterRegistrationDate("01.2020")
            .submitEnterRegistrationDatePage();

        assertThat(enterBirthDatePage.isBirthdayInputDisplayed()).isTrue();
    }
}
