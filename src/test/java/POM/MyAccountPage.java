package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BaseHQ {

    /*--------------------------------------------LOCATORS--------------------------------------------*/
    public By logo = By.xpath("//img[@alt='My Store']");

    /*--------------------------------------------METHODS--------------------------------------------*/
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void backToHomePage() {
        driver.findElement(logo).click();
    }
}
