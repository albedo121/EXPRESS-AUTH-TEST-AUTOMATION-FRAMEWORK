package pages;

import Base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {

    //INITIALIZE WEBDRIVER HERE
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected BaseClass base;

    public DashboardPage(WebDriver driver, WebDriverWait wait, BaseClass base){
        this.driver = driver;
        this.wait = wait;
        this.base = base;
    }

    //DEFINE LOCATORS HERE
    private final By Logout_Button_Locator = By.xpath("//input[@value='LOGOUT']");
    private final By Login_Banner_Text_Locator = By.xpath("(//span[@class='text-1'])[1]");

    //DEFINE METHODS HERE------------------------------

    //This function clicks on logout button
    public void Click_Logout_Button(){
        //Log message
        System.out.println("Clicking logout button...");

        //Click logout button
        wait.until(ExpectedConditions.elementToBeClickable(Logout_Button_Locator)).click();
    }

    //This function checks if user logged out by checking if present on login page
    //by checking if navigated to correct url and login page banner text is present
    public void Is_Logged_Button(){
        //Check if expected and current url match
        String Expected_url = base.getCredentials("URL");
        wait.until(ExpectedConditions.urlToBe(Expected_url));
        String Current_url = driver.getCurrentUrl();
        Assert.assertEquals("Not present at login page",Current_url,Expected_url);

        //Check if text banner text on login page is present to confirm login page
        String Banner_Text = wait.until(ExpectedConditions.visibilityOfElementLocated(Login_Banner_Text_Locator)).getText().replace("\n", " ");
        Assert.assertEquals("Login page banner mismatch","Every new friend is a new adventure", Banner_Text);
    }

}
