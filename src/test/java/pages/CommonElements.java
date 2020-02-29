package pages;

import static com.codeborne.selenide.Selenide.$;

/**
 * Class represents common web elements that occur in multiple pages. It eliminates code duplication and supports
 * Composition Over Inheritance principle.
 */
class CommonElements {

    void submit() {
        $("button[type='submit']").click();
    }

}