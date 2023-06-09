package pages;

import helper.Action;

import java.util.HashMap;
import java.util.Map;

public class RegisterPage extends Action {
    public Map<String, String> variables = new HashMap<>();

    public RegisterPage() {
        super();
    }

    public String elementForRegister(String key) {
        variables.put("inputName", "com.loginmodule.learning:id/textInputEditTextName");
        variables.put("inputEmail", "com.loginmodule.learning:id/textInputEditTextEmail");
        variables.put("inputPassword", "com.loginmodule.learning:id/textInputEditTextPassword");
        variables.put("inputConfirmPass", "com.loginmodule.learning:id/textInputEditTextConfirmPassword");
        variables.put("btnRegister", "com.loginmodule.learning:id/appCompatButtonRegister");
        variables.put("btnAlreadyMember", "com.loginmodule.learning:id/appCompatTextViewLoginLink");
        return variables.get(key);
    }
}
