package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {

    //Initialize
    private WebDriver driver;
    private LoginPage login;
    private WebDriverWait wait;
    private String url = "https://expressauth-zzn0.onrender.com/";

    //Setup Browser
    @Before
    public void BrowserSetup() {
        //Define options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        System.out.println("Launching browser");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();   //Maximize window
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        login = new LoginPage(driver, wait);
    }

    //Close Browser
    @After
    public void Teardown(){
        System.out.println("Teardown");
        driver.quit();
    }

    //DEFINE STEP METHODS FROM HERE---------------------------------

    @Given("user is on login page")
    public void user_is_on_login_page() {
        //Log message
        System.out.println("Navigating to url...");

        //Navigate to given url
        driver.get(url);
    }

    @When("user enters valid email {string} and password {string}")
    public void user_enters_valid_email_and_password(String email, String password) {
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
    public void user_enters_invalid_and_valid(String email, String password) {
        //Enter valid email and invalid password
        login.Enter_Email(email);
        login.Enter_Password(password);
    }

    @Then("user is unable to login and error message is displayed")
    public void user_is_unable_to_login_and_error_message_is_displayed() {
        //Check user was not logged in
        login.Is_Login_failed();
    }


}
