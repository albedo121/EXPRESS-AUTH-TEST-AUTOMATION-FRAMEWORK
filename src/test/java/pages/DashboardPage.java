package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {

    //INITIALIZE WEBDRIVER HERE
    protected WebDriver driver;
    protected WebDriverWait wait;

    public DashboardPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //DEFINE LOCATORS HERE
    private final By Logout_Button = By.xpath("//input[@value='LOGOUT']");

    //DEFINE METHODS HERE------------------------------

    //This function clicks on logout button
    public void Click_Logout_Button(){
        //Log message
        System.out.println("Clicking logout button...");

        //Click logout button
        wait.until(ExpectedConditions.elementToBeClickable(Logout_Button));
        driver.findElement(Logout_Button).click();
    }

}
