#noinspection SpellCheckingInspection
Feature: To test login functionality

  Scenario Outline: Successful login on entering valid credentials
    Given user is on login page
    When user enters valid "<email>" and "<password>"
    And user clicks submit button
    Then user is logged in and navigated to dashboard page

    Examples:
    | email | password |
    | tony@stark.com | iamironman |
    | bruce@Wayne.com | iambatman#123 |
    | clark@kent.com  | #@!IAMSUPERman |
    | sarah.connor@email.com | Terminator-T800 |
    | john.doe@company.com | Secure@Pass123 |

    Scenario Outline: Unsuccessful login on entering invalid password
      Given user is on login page
      When user enters invalid "<email>" and "<password">
      And user clicks submit button
      Then user is unable to login and error message is displayed

      Examples:
        | email | password |
        | tony@stark.com | iamnotironman |
        | bruce@Wayne.com | iambatman#321 |
        | clark@kent.com  | IAMSUPERman#@! |
        | sarah.connor@email.com | Terminator-T1000 |
        | john.doe@company.com | Secure@Pass122 |