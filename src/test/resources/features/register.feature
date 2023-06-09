@register @smoke-test
Feature: Register

  Background:
    And user click "btnRegister" button in "Login" page

  @register-successfully
  Scenario Outline: User able for register successfully
    When user fill "inputName" input value register name
    And user fill "inputEmail" input value register email
    And user fill "inputPassword" input value "<password>" in "Register" page
    And user fill "inputConfirmPass" input value "<password>" in "Register" page
    And user click "btnRegister" button in "Register" page
    Then user can see verify value "<message>" message
    And user can wait loading application for 2 seconds
    And user click "btnAlreadyMember" button in "Register" page
    And user fill "inputEmail" input already register email
    And user fill "inputPassword" input value "<password>" in "Login" page
    And user click "btnLogin" button in "Login" page
    Then user able to see value name after register
    And user able to see value email after register
    And user able to see "<password>" message verification
    Examples:
      | password    | message                 |
      | Password123 | Registration Successful |

  @register-null-name
  Scenario: User can't input name
    When user click "btnRegister" button in "Register" page
    Then user able to see "Enter Full Name" message verification

  @register-null-email
  Scenario: User can't input email
    When user fill "inputName" input value register name
    And user click "btnRegister" button in "Register" page
    Then user able to see "Enter Valid Email" message verification

  @register-null-password
  Scenario: User can't input email
    When user fill "inputName" input value register name
    And user fill "inputEmail" input value register email
    And user click "btnRegister" button in "Register" page
    Then user able to see "Enter Password" message verification

  @register-invalid-confirm
  Scenario: User invalid confirm password
    When user fill "inputName" input value register name
    And user fill "inputEmail" input value register email
    And user fill "inputPassword" input value "<password>" in "Register" page
    And user click "btnRegister" button in "Register" page
    Then user able to see "Password Does Not Matches" message verification

  @register-invalid-email
  Scenario: User invalid email
    When user fill "inputName" input value register name
    And user fill "inputEmail" input value "test" in "Register" page
    And user fill "inputPassword" input value "<password>" in "Register" page
    And user fill "inputConfirmPass" input value "<password>" in "Register" page
    And user click "btnRegister" button in "Register" page
    Then user able to see "Enter Valid Email" message verification
