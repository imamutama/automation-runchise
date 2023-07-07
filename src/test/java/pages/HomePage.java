package pages;

import helper.Action;

import java.util.HashMap;
import java.util.Map;

public class HomePage extends Action {
    public Map<String, String> variables = new HashMap<>();

    public HomePage() {
        super();
    }

    public String elementForHomePage(String key) {
        variables.put("locationOpen", "(//div[@class='css-1ozv6b7'])[1]");
        variables.put("dropdownLocation", "//div[@aria-haspopup='true']");
        variables.put("chooseLocation", "(//div[@class='css-10hhgxr'])[1]");
        variables.put("scrollProduct", "(//div[@class='css-1u9uw2c'])[1]");
        variables.put("addProduct", "(//p[contains(text(),'Tambah')])[1]");
        variables.put("addQuantity", "(//div[@class='MuiBox-root css-sjx0zd'])[2]");
        variables.put("priceProduct", "(//div[contains(@class,'css-1pq5c6l')])[1]");
        variables.put("totalPrice", "//*[@class='MuiTypography-root MuiTypography-body1 css-anr7ky'][2]");
        variables.put("addToCart", "//div[contains(@class,'css-ffp25a')]//button[2]");
        variables.put("textProduct", "(//div[@class='css-cg2gzu'])[1]");
        return variables.get(key);
    }

}
