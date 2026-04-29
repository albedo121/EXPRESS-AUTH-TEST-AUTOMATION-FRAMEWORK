#noinspection SpellCheckingInspection
Feature: To test login functionality

  @positive
  Scenario Outline: Successful login on entering valid credentials.
    Given user is on login page
    When user enters valid email "<email>" and password "<password>"
    And user clicks submit button
    Then user is logged in and navigated to dashboard page

    Examples:
      | email         | password         |
      | VALID_EMAIL_1 | VALID_PASSWORD_1 |
      | VALID_EMAIL_2 | VALID_PASSWORD_2 |
      | VALID_EMAIL_3 | VALID_PASSWORD_3 |
      | VALID_EMAIL_4 | VALID_PASSWORD_4 |
      | VALID_EMAIL_5 | VALID_PASSWORD_5 |

  @negative-test
  Scenario Outline: Unsuccessful login on entering valid email and invalid password.
    Given user is on login page
    When user enters valid email "<email>" and invalid password "<password>"
    And user clicks submit button
    Then user is unable to login and error message is displayed

    Examples:
      | email         | password           |
      | VALID_EMAIL_1 | INVALID_PASSWORD_1 |
      | VALID_EMAIL_2 | INVALID_PASSWORD_2 |
      | VALID_EMAIL_3 | INVALID_PASSWORD_3 |
      | VALID_EMAIL_4 | INVALID_PASSWORD_4 |
      | VALID_EMAIL_5 | INVALID_PASSWORD_5 |

  @negative-test
  Scenario Outline: Unsuccessful login on entering invalid email and valid password.
    Given user is on login page
    When user enters invalid email "<email>" and valid password "<password>"
    And user clicks submit button
    Then user is unable to login and error message is displayed
    Examples:
      | email           | password         |
      | INVALID_EMAIL_1 | VALID_PASSWORD_1 |
      | INVALID_EMAIL_2 | VALID_PASSWORD_2 |
      | INVALID_EMAIL_3 | VALID_PASSWORD_3 |
      | INVALID_EMAIL_4 | VALID_PASSWORD_4 |
      | INVALID_EMAIL_5 | VALID_PASSWORD_5 |