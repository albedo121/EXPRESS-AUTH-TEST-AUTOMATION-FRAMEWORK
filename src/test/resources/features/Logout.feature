#noinspection SpellCheckingInspection

#Positive Test Cases:
#User clicks the logout button and is redirected to the login page.
#After logout, user cannot access dashboard or any authenticated page (redirected to login).
#Logout button is visible only when user is logged in.
#Session/cookies are cleared after logout.
#User can log in again after logging out.

#Negative Test Cases:
#User tries to access logout URL directly without being logged in (should stay on login page or see an error).
#User clicks logout, then uses browser back button (should not access dashboard).
#Multiple logout requests (double-clicking logout) do not cause errors.
#Logout fails due to server error (simulate and check error handling/message).
#Logout with expired session (should redirect to login and not throw error).

Feature: To test logout functionality

  Background:
    Given user is on login page

  Scenario Outline: Successful logout for different user roles
    And user with role "<role>" enters email "<email>" and password "<password>"
    When user clicks logout button
    Then user is logged out and navigated to login page
    Examples:
      | role  | email         | password         |
      | user  | VALID_EMAIL_5 | VALID_PASSWORD_5 |
      | admin | ADMIN_EMAIL_1 | ADMIN_PASSWORD_1 |

