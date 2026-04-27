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

  Scenario: User clicks the logout button and is redirected to the login page.
    Given user is logged in
    And user clicks logout button
    Then user is logged out and redirected to login page

  Scenario:


