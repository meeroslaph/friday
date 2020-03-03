# FRI:DAY TEST AUTOMATION
Extensible & lightweight test automation solution based on Java, Maven, and TestNG.

Powered by (1) Selenium WebDriver-based [Selenide](https://selenide.org/) framework that eliminates boilerplate code implementation and allows focusing on the business logic instead, (2) [Allure](https://docs.qameta.io/allure/) report for the concise test report, and (3) [AssertJ](https://assertj.github.io/doc/) for fluent assertions.

## History
You can check the [tickets](https://github.com/meeroslaph/friday/issues?q=is%3Aissue+is%3Aclosed), [pull requests](https://github.com/meeroslaph/friday/pulls?q=is%3Apr+is%3Aclosed), and [CI builds](https://github.com/meeroslaph/friday/actions) to have a better idea what I worked on and see the progress.

## Technologies
| Technology    | Tool          |
| ------------- |:-------------:|
| Language | Java 1.8 |
| Build Tool | Maven 3.6.0 |
| Browser Automation | Selenide 5.7.0 |
| Testing Framework | TestNG 7.1.0 |
| Assertion Engine |  AssertJ 3.15.0 |
| Continuous Integration | GitHub Actions |

## Features
1. **Positive And Negative Scenarios**

   There are 16 tests cases, including negative scenarios gathered under a separate group. You can run exclusively negative scenarios using `mvn clean test -Dgroups=negative`.
   
1. **Automated Screenshots**

   Screenshots along with captured HTML of a page are saved automatically in `build/reports/tests`.
   
1. **Parallel Multithreaded Test Execution**

   3 threads for test methods execution and 2 additional threads for tests with multiple scenarios marked with `@DataProvider` annotation.
   
1. **Multiple Environments**

   - `mvn clean test -Denv=local` — Local.
   - `mvn clean test -Denv=remote` — Remote Selenium Grid server running in Docker container using GitHub Actions. See [How To Run](#how-to-run) section for details.
   - `mvn clean test -Denv=saucelabs` — 3rd party cloud provider [Sauce Labs](https://saucelabs.com/). (Assuming you have Sauce Labs account)
   
1. **Cross-browser**
   - `-Dbrowser=chrome` — Chrome
   - `-Dbrowser=firefox` — Firefox

1. **CI Integration**

   Every push to the repo triggers test execution and generates report afterwards that later can be open on a Jetty server.


1. **Test Reports**

   Allure and JaCoCo (assuming there is an ability to run the application under test with JaCoCo agent) reports integration.

## How To Run
Starring this repo (click on the "Star" button at the top) will start the CI build. And then you can watch the progress in the [Actions](https://github.com/meeroslaph/friday/actions) tab. That's it!


#### How To Run Locally
##### Prerequisites
It is assumed that the system has [ChromeDriver](https://chromedriver.chromium.org/) and [geckodriver](https://github.com/mozilla/geckodriver) (Firefox) installed. A good practice is to use configuration management tools for automated browser binaries distribution such as [Ansible](https://www.ansible.com/) or [Chef](https://www.chef.io/).

##### Steps
1. `mvn clean test` will start test execution.
2. `mvn allure:report` will generate Allure report.
3. `mvn allure:serve` will start a local Jetty server and open the Allure report in a browser.
4. Enjoy!
