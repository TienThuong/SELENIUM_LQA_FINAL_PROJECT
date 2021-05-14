package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseHQ {
    public WebDriver driver;

    public boolean Base(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public BaseHQ(WebDriver driver) {
        this.driver = driver;
    }

    public BaseHQ() {
    }

    public Properties dataInput() throws IOException {
        Properties propData = new Properties();
        FileInputStream data = new FileInputStream("data.properties");
        propData.load(data);
        return propData;
    }
}
