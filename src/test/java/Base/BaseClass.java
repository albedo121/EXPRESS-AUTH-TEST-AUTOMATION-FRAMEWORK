package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigManager;

public class BaseClass {

    // Shared across all step definition files
    public WebDriver driver;
    public WebDriverWait wait;
    public String url = ConfigManager.get("URL");

    // Helper function to fetch actual credential value from secrets.env using key name
    // If key exists --> returns actual value
    // If key missing --> returns key as is
    public String getCredentials(String key) {
        String value = ConfigManager.get(key);
        return (value != null) ? value : key;
    }

}
