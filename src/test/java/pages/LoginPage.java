package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class LoginPage {

    //INITIALIZE WEBDRIVER HERE
    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //DEFINE LOCATORS HERE------------------------------
    private final By Email_Input_Box_Locator = By.xpath("(//input[@type='email'])[1]");   //Email input box
    private final By Password_Input_Box_Locator = By.xpath("(//input[@type='password'])[1]");   //Password input box
    private final By Submit_Button_Locator = By.xpath("(//input[@type='submit'])[1]");   //Submit button
    private final By Dashboard_Text_Locator = By.xpath("//*[contains(text(),'USER DASHBOARD')]");   //Dashboard text
    private final By Login_failed_Text_Locator = By.xpath("//body[text()='Invalid credentials or user does not exists.']");   //Login failed text

    //DEFINE METHODS HERE------------------------------

    //This function finds and enters email
    public void Enter_Email(String email){

        //Log message
        System.out.println("Entering email: " + email);

        //Find and enter email
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email_Input_Box_Locator)).sendKeys(email);
    }

    //This function finds and enters password
    public void Enter_Password(String password){

        //Log message
        System.out.println("Entering password: " + password);

        //Find and enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(Password_Input_Box_Locator)).sendKeys(password);
    }

    //This function finds and clicks submit button
    public void Click_Submit_Button(){
        //Log message
        System.out.println("Clicking submit button...");

        //Find and click submit button
        wait.until(ExpectedConditions.elementToBeClickable(Submit_Button_Locator)).click();
    }

    //This function checks if user is logged in by checking if user is currently on dashboard page
    public void Is_Logged_In(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard_Text_Locator));
        String text = driver.findElement(Dashboard_Text_Locator).getText();
        Assert.assertEquals("Dashboard page text mismatch or login failed.", "USER DASHBOARD", text);

    }

    //This function checks if login failed by checking if text 'Invalid credentials or user does not exist is displayed'
    public void Is_Login_failed(){
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(Login_failed_Text_Locator)).getText();
        Assert.assertEquals("Login fail text mismatch", "Invalid credentials or user does not exists.", text);
    }

}
