@login @smokr-test
Feature: Login

  @login-invalid-email-pass
  Scenario Outline: User login wrong password or email
    Given user fill "inputEmail" input value "<email>" in "Login" page
    When user fill "inputPassword" input value "<password>" in "Login" page
    And user click "btnLogin" button in "Login" page
    Then user able to see "<message>" message verification
    Examples:
      | email                    | password | message                 |
      | testingsurplus@gmail.com | Pass123  | Wrong Email or Password |

  @login-null-email
  Scenario Outline: User login is a empty email
    When user fill "inputPassword" input value "<password>" in "Login" page
    And user click "btnLogin" button in "Login" page
    Then user able to see "<message>" message verification
    Examples:
      | password | message           |
      | Pass123  | Enter Valid Email |

  @login-null-password
  Scenario Outline: User login is empty password
    Given user fill "inputEmail" input value "<email>" in "Login" page
    And user click "btnLogin" button in "Login" page
    Then user able to see "<message>" message verification
    Examples:
      | email                    | message           |
      | testingsurplus@gmail.com | Enter Valid Email |