package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BaseHQ {

    /*--------------------------------------------LOCATORS--------------------------------------------*/

    public WebElement resultPrintedSummerDress() {
        WebElement rpsd = driver.findElement(By.cssSelector("li.ajax_block_product:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h5:nth-child(1) > a:nth-child(1)"));
        return rpsd;
    }

    public WebElement resultPrice() {
        WebElement rp = driver.findElement(By.cssSelector("#our_price_display"));
        return rp;
    }

    public WebElement resultNotFound() {
        WebElement rnf = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        return rnf;
    }

    /*--------------------------------------------METHODS--------------------------------------------*/
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }


}
