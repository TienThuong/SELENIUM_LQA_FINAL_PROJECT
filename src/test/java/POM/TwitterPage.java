package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterPage extends BaseHQ {

    /*--------------------------------------------LOCATORS--------------------------------------------*/

    public By twitterUsername = By.xpath("//input[@name=\"session[username_or_email]\"]");

    public By twitterPassword = By.xpath("//input[@name=\"session[password]\"]");

    public By twitterLoginButton = By.cssSelector("div[class='css-18t94o4 css-1dbjc4n r-1q3imqu r-42olwf r-sdzlij r-1phboty r-rs99b7 r-1w2pmg r-ero68b r-1gg2371 r-1ny4l3l r-1fneopy r-o7ynqc r-6416eg r-lrvibr']");

    public By tweetSendButton = By.cssSelector("div[class='css-18t94o4 css-1dbjc4n r-1q3imqu r-42olwf r-sdzlij r-1phboty r-rs99b7 r-1w2pmg r-19u6a5r r-ero68b r-1gg2371 r-1ny4l3l r-1fneopy r-o7ynqc r-6416eg r-lrvibr']");

    /*--------------------------------------------METHODS--------------------------------------------*/

    public TwitterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void twitterUsername(String input) {
        driver.findElement(twitterUsername).sendKeys(input);
    }

    public void twitterPassword(String input) {
        driver.findElement(twitterPassword).sendKeys(input);
    }

    public void twitterLogin() {
        driver.findElement(twitterLoginButton).click();
    }

    public void twitterSendButton() {
        driver.findElement(tweetSendButton).click();
    }
}
