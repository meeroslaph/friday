package tests;

import java.util.List;
import org.testng.annotations.Test;
import pages.SelectVehiclePage;
import static org.assertj.core.api.Assertions.assertThat;

public class VehicleFilterTest extends BaseTest {

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
        String brand = "KITT";

        SelectVehiclePage selectVehiclePage = selectPreconditionPage
            .submitSelectPreconditionPage()
            .submitSelectRegisteredOwnerPage()
            .filterVehiclesList(brand);

        List<String> filteredVehicles = selectVehiclePage.getFilteredVehiclesList();

        assertThat(filteredVehicles.isEmpty()).isTrue();
        assertThat(selectVehiclePage.isUnknownVehicleWarningDisplayed()).isTrue();
    }

}
