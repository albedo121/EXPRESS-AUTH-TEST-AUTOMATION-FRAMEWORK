package StepDefinitions;

import Base.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage;

public class LoginSteps {

    private final BaseClass base;
    private final LoginPage login;

    public LoginSteps(BaseClass base) {
        this.base = base;
        this.login = new LoginPage(base.driver, base.wait);
    }

    //DEFINE STEP METHODS FROM HERE---------------------------------

    @Given("user is on login page")
    public void user_is_on_login_page() {
        //Log message
        System.out.println("Navigating to url...");

        //Navigate to given url
        base.driver.get(base.url);
    }

    @When("user enters valid email {string} and password {string}")
    public void user_enters_valid_email_and_password(String emailKey, String passwordKey) {

        //Fetch email and password from env file
        String email = base.getCredentials(emailKey);
        String password = base.getCredentials(passwordKey);

        //Enter email and password
        login.Enter_Email(email);
        login.Enter_Password(password);
    }

    @And("user clicks submit button")
    public void user_enters_submit_button() {
        //Click submit button
        login.Click_Submit_Button();
    }

    @Then("user is logged in and navigated to dashboard page")
    public void user_is_logged_in_and_navigated_to_dashboard_page() {
        //Check if user was logged in by checking if navigated to dashboard page
        login.Is_Logged_In();
    }


    @When("user enters valid email {string} and invalid password {string}")
    public void user_enters_valid_email_and_invalid_password(String emailKey, String passwordKey) {

        //Fetch email and password from env file
        String email = base.getCredentials(emailKey);
        String password = base.getCredentials(passwordKey);

        //Enter email and password
        login.Enter_Email(email);
        login.Enter_Password(password);
    }

    @Then("user is unable to login and error message is displayed")
    public void user_is_unable_to_login_and_error_message_is_displayed() {
        //Check user was not logged in
        login.Is_Login_failed();
    }

    @When("user enters invalid email {string} and valid password {string}")
    public void user_enters_invalid_email_and_valid_password(String emailKey, String passwordKey) {

        //Fetch email and password from env file
        String email = base.getCredentials(emailKey);
        String password = base.getCredentials(passwordKey);

        //Enter email and password
        login.Enter_Email(email);
        login.Enter_Password(password);
    }

}
