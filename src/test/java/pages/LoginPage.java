package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    protected WebDriver driver;

    //DEFINE LOCATORS HERE------------------------------
    private By Email_Input_Box = By.xpath("(//input[@type='email'])[1]");   //Email input box
    private By Password_Input_Box = By.xpath("(//input[@type='password'])[1]");   //Password input box
    private By Submit_Button = By.xpath("(//input[@type='submit'])[1]");   //Submit button
    private By Dashboard_Text = By.xpath("//*[contains(text(),'USER DASHBOARD')]");   //Dashboard text

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //DEFINE METHODS HERE------------------------------

    //This function finds and enters email
    public void Enter_Email(String email){
        //Find and enter email
        driver.findElement(Email_Input_Box).sendKeys(email);
    }

    //This function finds and enters password
    public void Enter_Password(String password){
        //Find and enter password
        driver.findElement(Password_Input_Box).sendKeys(password);

        //Log message
        System.out.println("Entered valid assword");
    }

    //This function finds and clicks submit button
    public void Click_Submit_Button(){
        //Find and click submit button
        driver.findElement(Submit_Button).click();

        //Log message
        System.out.println("Clicked submit button");
    }

    //This function checks if user is currently on dashboard page (logged in)
    public void Check_Is_Dashboard_Page(){
        //Locate text 'USER DASHBOARD' to confirm login
        String text = driver.findElement(Dashboard_Text).getText();

        //Check if text is 'USER DASHBOARD'. If yes then means successful login otherwise not logged in.
        if (text.equals("USER DASHBOARD"))
            System.out.println("Login successful - User reached dashboard page.");
        else
            System.out.println("Login failed.");
    }

}


