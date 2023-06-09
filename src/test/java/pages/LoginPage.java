package pages;

import helper.Action;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends Action {
    public Map<String, String> variables = new HashMap<>();

    public LoginPage() {
        super();
    }

    public String elementForLogin(String key) {
        variables.put("inputEmail", "com.loginmodule.learning:id/textInputEditTextEmail");
        variables.put("inputPassword", "com.loginmodule.learning:id/textInputEditTextPassword");
        variables.put("btnLogin", "com.loginmodule.learning:id/appCompatButtonLogin");
        variables.put("btnRegister", "com.loginmodule.learning:id/textViewLinkRegister");
        return variables.get(key);
    }
}
