package stepdefs;

import capabilities.DriverFactoryManager;
import helper.Action;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;

public class GlobalStep extends BasePage {

    @And("user click {string} button in {string} page")
    public void userClickButtonInPage(String element, String page) throws Exception {
        action.click(Action.Direction.ID, locateForPageElement(element, page));
    }

    @And("user fill {string} input value {string} in {string} page")
    public void userFillInputValueInPage(String element, String value, String page) throws Exception {
        action.sendText(Action.Direction.ID, locateForPageElement(element, page), value);
    }

    @Then("user should be redirected to {string} page")
    public void userShouldBeRedirectedToPage(String value) {
        action.verifyTextElement(value);
    }

    @Then("user able to see {string} message verification")
    public void userCanSeeVerifyValueData(String value) {
        action.verifyTextElement(value);
    }

    @Given("user click back navigate android")
    public void userClickBackNavigateAndroid() {
        action.backAndroid();
    }

    @Then("user can see verify value {string} message")
    public void userCanSeeVerifyValueStringMessage(String value) {
        action.verifyTextElement(value);
    }

    @Then("user close the applications")
    public void userCloseApplication(String value) {
        DriverFactoryManager.quitDriver();
    }

    @Then("user able to see {string} data verification")
    public void userAbleToSeeDataVerification(String value) {
        action.verifyTextElement(value);
    }
}
