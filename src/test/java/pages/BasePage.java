package pages;

import helper.Action;

public class BasePage {
    public Action action;
    public HomePage homePage;
    public CartPage cartPage;

    public BasePage() {
        action = new Action();
        homePage = new HomePage();
        cartPage = new CartPage();
    }

    public String locateForPageElement(String element, String page) {
        String res = null;
        switch (page) {
            case "Home":
                res = homePage.elementForHomePage(element);
                break;
            case "Cart":
                res = cartPage.elementForCartPage(element);
                break;
        }
        return res;
    }

}
