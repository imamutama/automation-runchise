package stepdefs;

import capabilities.DriverFactoryManager;
import helper.Action;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;
import utils.ConfigFileReader;

public class GlobalStep extends BasePage {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Given("User open Webview")
    public void userOpenSalesforceWebview() {
        action.openUrl(configFileReader.getApplicationUrl());
    }

    @And("user click {string} button in {string} page")
    public void userClickButtonInPage(String element, String page) throws Exception {
        action.click(Action.Direction.XPATH, locateForPageElement(element, page));
    }

    @And("user fill {string} input value {string} in {string} page")
    public void userFillInputValueInPage(String element, String value, String page) throws Exception {
        action.sendText(Action.Direction.XPATH, locateForPageElement(element, page), value);
    }

    @Then("user able to see {string} data verification")
    public void userAbleToSeeDataVerification(String value) {
        action.verifyTextElement(value);
    }
    @And("user click by text {string}")
    public void userClickTextInPage(String text) throws Exception {
        action.clickByTextAndroid(text);
    }
    @And("User scroll by element {string} in {string} page")
    public void userScrollByText(String value, String page) throws InterruptedException {
        action.scrollElement(locateForPageElement(value, page));
    }

    @And("User can wait loading application for {string} seconds")
    public void userCanWaitLoadingForSeconds(String index) throws InterruptedException {
        int intIndex = Integer.parseInt(index);
        Thread.sleep(intIndex * 1000);
    }

}
