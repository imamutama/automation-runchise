package pages;

import helper.Action;

public class BasePage {
    public Action action;
    public LoginPage loginPage;
    public RegisterPage registerPage;

    public BasePage() {
        action = new Action();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    public String locateForPageElement(String element, String page) {
        String res = null;
        switch (page) {
            case "Login":
                res = loginPage.elementForLogin(element);
                break;
            case "Register":
                res = registerPage.elementForRegister(element);
                break;
        }
        return res;
    }

}
