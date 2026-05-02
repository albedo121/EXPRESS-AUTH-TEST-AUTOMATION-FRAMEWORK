package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

    private final BaseClass base;

    // Cucumber injects the same BaseClass instance used by all step files
    public Hooks(BaseClass base) {
        this.base = base;
    }

    //Setup Browser
    @Before
    public void BrowserSetup() {
        //Define options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        System.out.println("Launching browser...");
        base.driver = new ChromeDriver(options);
        base.driver.manage().window().maximize();   //Maximize window
        base.wait = new WebDriverWait(base.driver, Duration.ofSeconds(60));
    }

    //Close Browser
    @After
    public void Teardown(){
        System.out.println("Teardown");
        base.driver.quit();
    }
}
