package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    //DEFINE LOCATORS HERE------------------------------
    private By Email_Input_Box = By.xpath("(//input[@type='email'])[1]");   //Email input box
    private By Password_Input_Box = By.xpath("(//input[@type='password'])[1]");   //Password input box
    private By Submit_Button = By.xpath("(//input[@type='submit'])[1]");   //Submit button
    private By Dashboard_Text = By.xpath("//*[contains(text(),'USER DASHBOARD')]");   //Dashboard text
    private By Login_failed_Text = By.xpath("//body[text()='Invalid credentials or user does not exists.']");   //Login failed text

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //DEFINE METHODS HERE------------------------------

    //This function finds and enters email
    public void Enter_Email(String email){

        //Log message
        System.out.println("Entering email: " + email);

        //Find and enter email
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email_Input_Box));
        driver.findElement(Email_Input_Box).sendKeys(email);
    }

    //This function finds and enters password
    public void Enter_Password(String password){

        //Log message
        System.out.println("Entering password: " + password);

        //Find and enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(Password_Input_Box));
        driver.findElement(Password_Input_Box).sendKeys(password);
    }

    //This function finds and clicks submit button
    public void Click_Submit_Button(){
        //Log message
        System.out.println("Clicking submit button...");

        //Find and click submit button
        wait.until(ExpectedConditions.elementToBeClickable(Submit_Button));
        driver.findElement(Submit_Button).click();
    }

    //This function checks if user is logged in by checking if user is currently on dashboard page
    public void Is_Logged_In(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard_Text));
        String text = driver.findElement(Dashboard_Text).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text, "USER DASHBOARD", "Dashboard page text mismatch or login failed.");
        softAssert.assertAll();
    }

    public void Is_Login_failed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Login_failed_Text));
        String text = driver.findElement(Login_failed_Text).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text, "Invalid credentials or user does not exists.", "Login fail text mismatch");
        softAssert.assertAll();
    }

}
