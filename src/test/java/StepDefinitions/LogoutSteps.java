package StepDefinitions;

import Base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

public class LogoutSteps {

    private final BaseClass base;
    private final LoginPage login;
    private final DashboardPage Dashboard;

    public LogoutSteps(BaseClass base) {
        this.base = base;
        this.login = new LoginPage(base.driver, base.wait);
        this.Dashboard = new DashboardPage(base.driver, base.wait, base);
    }

    //DEFINE STEP METHODS FROM HERE---------------------------------
    @When("user with role {string} enters email {string} and password {string}")
    public void user_with_role_enters_email_and_password(String role, String emailKey, String passwordKey) {
        //Fetch email and password from env file
        String email = base.getCredentials(emailKey);
        String password = base.getCredentials(passwordKey);

        //Enter email and password
        login.Enter_Email(email);
        login.Enter_Password(password);
    }

    @When("user clicks logout button")
    public void user_clicks_logout_button() {
        //Click on logout button
        Dashboard.Click_Logout_Button();
    }

    @Then("user is logged out and navigated to login page")
    public void user_is_logged_out_and_navigated_to_login_page() {
        Dashboard.Is_Logged_Button();
    }
}
