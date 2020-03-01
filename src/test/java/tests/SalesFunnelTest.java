package tests;

import java.util.List;
import models.Car;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EnterBirthDatePage;
import pages.SelectVehiclePage;
import static org.assertj.core.api.Assertions.assertThat;

public class SalesFunnelTest extends BaseTest {

    @Test(dataProvider = "cars")
    public void userShouldBeAbleToSelectCar(Car car) {
        EnterBirthDatePage enterBirthDatePage = selectPreconditionPage
            .submitSelectPreconditionPage()
            .submitSelectRegisteredOwnerPage()
            .selectVehicle(car.getVehicle())
            .selectModel(car.getModel())
            .selectBodyType(car.getBodyType())
            .selectFuelType(car.getFuelType())
            .selectEnginePower(car.getEnginePower())
            .selectEngine(car.getEngine(), car.getEngineModel())
            .enterRegistrationDate("02.2020")
            .submitEnterRegistrationDatePage();

        assertThat(enterBirthDatePage.isBirthdayInputDisplayed()).isTrue();
    }

    @Test
    public void userShouldBeAbleToFilterVehiclesList() {
        String brand = "TESLA";

        SelectVehiclePage selectVehiclePage = selectPreconditionPage
            .submitSelectPreconditionPage()
            .submitSelectRegisteredOwnerPage()
            .filterVehiclesList(brand);

        List<String> filteredVehicles = selectVehiclePage.getFilteredVehiclesList();

        assertThat(filteredVehicles.size()).isEqualTo(1);
        assertThat(filteredVehicles.get(0)).isEqualTo(brand);
        assertThat(selectVehiclePage.isUnknownVehicleWarningDisplayed()).isFalse();
    }

    @Test(groups = "negative")
    public void warningShouldBeShownIfVehicleDoesNotExist() {
        SelectVehiclePage selectVehiclePage = selectPreconditionPage
            .submitSelectPreconditionPage()
            .submitSelectRegisteredOwnerPage()
            .filterVehiclesList("KITT");

        List<String> filteredVehicles = selectVehiclePage.getFilteredVehiclesList();

        assertThat(filteredVehicles.isEmpty()).isTrue();
        assertThat(selectVehiclePage.isUnknownVehicleWarningDisplayed()).isTrue();
    }

    @DataProvider(name = "cars")
    public static Object[][] carsDataProvider() {
        return new Object[][]{
            {
                new Car("FORD", "Focus", "Kombi", "Sonstiges", "110 kW / 150 PS", "FOCUS TURNIER 1.6",
                    "HSN: 8566, TSN: AWO")
            },
            {
                new Car("FORD", "Sierra", "Limousine", "Benzin", "150 kW / 204 PS", "SIERRA RS COSWORTH",
                    "HSN: 0928, TSN: 684")
            },
            {
                new Car("FORD", "Scorpio", "Kombi", "Diesel", "85 kW / 116 PS", "SCORPIO TURNIER DIESEL",
                    "HSN: 0928, TSN: 859")
            },

            {new Car("BMW", "1er", "Cabrio", "Benzin", "105 kW / 143 PS", "118I CABRIO", "HSN: 0005, TSN: AQN")},
            {new Car("BMW", "2er", "Coupe", "Diesel", "110 kW / 150 PS", "218D COUPE", "HSN: 0005, TSN: CCX")},
            {new Car("BMW", "3er", "Limousine", "Hybrid", "225 kW / 306 PS", "335IH / ACTIVEHYBRID 3", "HSN: 0005, TSN: BKG")},

            {new Car("ROVER", "Rover 75", "Kombi", "Benzin", "110 kW / 150 PS", "ROVER 75 TOURER 2.0", "HSN: 2142, TSN: 325")},
            {new Car("ROVER", "Rover 200", "Limousine", "Diesel", "77 kW / 105 PS", "ROVER 220 SDI DIESEL-D", "HSN: 2055, TSN: 409")},
            {new Car("ROVER", "Rover 800", "Limousine", "Benzin", "100 kW / 136 PS", "ROVER 820 I,SI STH", "HSN: 2055, TSN: 353")}
        };
    }
}
