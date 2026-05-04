#noinspection SpellCheckingInspection

#Positive Test Cases:
#User clicks the logout button and is redirected to the login page.
#After logout, user cannot access dashboard or any authenticated page (redirected to login).
#Logout button is visible only when user is logged in.
#Session/cookies are cleared after logout.
#User can log in again after logging out.

Feature: To test logout functionality

  Background:
    Given user is on login page

  @positive
  Scenario Outline: Successful logout for different user roles
    When user with role "<role>" enters email "<email>" and password "<password>"
    And user clicks submit button
    When user clicks logout button
    Then user is logged out and navigated to login page
    Examples:
      | role  | email         | password         |
      | user  | VALID_EMAIL_5 | VALID_PASSWORD_5 |
      | admin | ADMIN_EMAIL_1 | ADMIN_PASSWORD_1 |

