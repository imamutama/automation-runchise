package stepdefs;

import gherkin.lexer.Da;
import helper.Action;
import helper.DataConstant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BasePage;

public class AddProductStep extends BasePage {

    DataConstant dataConstant = new DataConstant();

    @And("user verify value price quantity from fill {string} in {string} page")
    public void userVerify(String element, String page) {
        String[] getTotal1 = dataConstant.valuePrice.split("\\.");
        int priceQty = Integer.parseInt(getTotal1[0] + getTotal1[1]) * 2;
        String[] getTotal2 = action.getText(Action.Direction.CSS, locateForPageElement(element, page)).split("\\.");
        int totalPrice = Integer.parseInt(getTotal2[0] + getTotal2[1]);
        System.out.println("price quantity : " + priceQty);
        System.out.println("total price :" + totalPrice);
        Assert.assertEquals(priceQty, totalPrice);
    }

    @And("user get value price quantity from fill {string} in {string} page")
    public void userGetValuePriceQuantityFromFill(String element, String page) {
        //  dataConstant.setNameProduct(action.getText(Action.Direction.XPATH, locateForPageElement("textProduct", page)));
        dataConstant.setValuePrice(action.getText(Action.Direction.XPATH, locateForPageElement(element, page)));
    }

    @Then("user verify value price quantity after remove from fill {string} in {string} page")
    public void userVerifyValuePriceQuantityAfterRemoveFromFill(String element, String page) {
        String[] getTotal1 = dataConstant.valuePrice.split("\\.");
        int priceQty = Integer.parseInt(getTotal1[0] + getTotal1[1]) * 2;
        String[] getTotal = action.getText(Action.Direction.XPATH, locateForPageElement(element, page)).split("\\.");
        int totalPrice = Integer.parseInt(getTotal[0] + getTotal[1]);
        Assert.assertEquals(priceQty, totalPrice);
    }

    @And("user able to see detail product same from order product")
    public void userAbleToSeeDetailProductSameFromOrderProduct() {
        Assert.assertEquals(true, action.verifyTextElement(dataConstant.getNameProduct()));
    }
}
