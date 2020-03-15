package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class InsuranceStartDateTest extends BaseTest {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static LocalDate now = LocalDate.now();

    @Test(dataProvider = "valid-dates")
    public void userShouldBeAbleToSpecifyInsuranceStartDate(String date) {
        selectPreconditionPage
                .enterInsuranceStartDate(date);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(selectPreconditionPage.isInvalidDateErrorMessageDisplayed()).isFalse();
        softly.assertThat(selectPreconditionPage.isSubmitButtonEnabled()).isTrue();
        softly.assertAll();
    }

    @Test(dataProvider = "invalid-dates", groups = "negative")
    public void errorShouldBeShownIfInsuranceStartDateIsInvalid(String date, String errorMessage) {
        selectPreconditionPage
                .enterInsuranceStartDate(date);

        assertThat(selectPreconditionPage.isInvalidDateErrorMessageDisplayed()).isTrue();
        assertThat(selectPreconditionPage.getInvalidDateErrorMessage()).isEqualTo(errorMessage);
        assertThat(selectPreconditionPage.isSubmitButtonEnabled()).isFalse();
    }

    @DataProvider(name = "valid-dates", parallel = true)
    public static Object[][] validDatesDataProvider() {
        return new Object[][]{
                {now.format(formatter)},
                {now.plusMonths(3).format(formatter)},
        };
    }

    @DataProvider(name = "invalid-dates", parallel = true)
    public static Object[][] invalidDatesDataProvider() {
        return new Object[][]{
                {now.minusDays(1).format(formatter), "Hups! Dieses Datum liegt in der Vergangenheit. Bitte überprüfe deine Eingabe."},
                {now.plusMonths(10).plusDays(1).format(formatter), "Hups! Dieses Datum liegt zu weit in der Zukunft. Bitte überprüfe deine Eingabe."},
                {now.format(DateTimeFormatter.ofPattern("dd.MM")) + ".0000", "Hups, das hat leider nicht funktioniert. Bitte überprüfe deine Eingabe."},
        };
    }
}
