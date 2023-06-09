package stepdefs;

import helper.Action;
import helper.GeneratedString;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;

public class RegisterStepDefinition extends BasePage {
    @When("user fill {string} input value register name")
    public void userFillInputValueRegisterName(String element) throws Exception {
        action.sendText(Action.Direction.ID, locateForPageElement(element, "Register"), GeneratedString.nameDummy());
        GeneratedString.setName(action.getText(Action.Direction.ID, locateForPageElement(element, "Register")));
    }

    @And("user fill {string} input value register email")
    public void userFillInputValueRegisterEmail(String element) throws Exception {
        action.sendText(Action.Direction.ID, locateForPageElement(element, "Register"), GeneratedString.emailDummy());
        GeneratedString.setEmail(action.getText(Action.Direction.ID, locateForPageElement(element, "Register")));
    }

    @And("user fill {string} input already register email")
    public void userFillInputAlreadyRegisterEmail(String element) throws Exception {
        action.sendText(Action.Direction.ID, locateForPageElement(element, "Login"), GeneratedString.getEmail());
    }

    @And("user can wait loading application for {int} seconds")
    public void userCanWaitLoadingForSeconds(int index) throws InterruptedException {
        Thread.sleep(index * 1000);
    }

    @And("user able to see value email after register")
    public void userCanSeeVerifyValueEmailAfterRegister() {
        action.verifyTextElement(GeneratedString.getEmail());
    }

    @Then("user able to see value name after register")
    public void userCanSeeVerifyValueNameAfterRegister() {
        action.verifyTextElement(GeneratedString.getName());
    }
}
