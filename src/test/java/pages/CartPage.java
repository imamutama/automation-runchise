package pages;

import helper.Action;

import java.util.HashMap;
import java.util.Map;

public class CartPage extends Action {
    public Map<String, String> variables = new HashMap<>();

    public CartPage() {
        super();
    }

    public String elementForCartPage(String key) {
        variables.put("textProductDetail", "div[class='css-1wff9y2'] p[class='MuiTypography-root MuiTypography-body1 css-anr7ky']");
        variables.put("removeQty", "(//button[contains(@type,'button')])[4]");
        variables.put("cardProduct", "(//div[contains(@class,'css-56jipt')])[1]");
        variables.put("priceDetail", "(//div[contains(@class,'css-1pq5c6l')])[1]");
        return variables.get(key);
    }
}
