package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ProductPage extends BaseHQ {

    Properties propData = dataInput();

    public void ImWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    /*--------------------------------------------LOCATORS--------------------------------------------*/

    public WebElement reviewNotify() {
        WebElement rn = driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div/p[1]"));
        return rn;
    }

    public WebElement sendToAFriendText() {
        WebElement staft = driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div/p[1]"));
        return staft;
    }

    public WebElement commentNotify() {
        WebElement cn = driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div/p[1]"));
        return cn;
    }

    public By item1BigPic = By.xpath("//*[@id=\"bigpic\"]");

    public By item1BigPicClose = By.xpath("//a[@title='Close']");

    public By item1ViewLarger = By.xpath("//span[@class='span_link no-print']");

    public By item1QuantityInput = By.xpath("//input[@id='quantity_wanted']");

    public By itemAddToCart = By.xpath("//button[@name='Submit']");

    public By nullQuantityReportClose = By.xpath("//a[@title='Close']");

    public By successAddToCartClose = By.xpath("//span[@title='Close window']");

    public By shoppingCart = By.xpath("//a[@title='View my shopping cart']");

    public By tweetButton = By.xpath("//button[normalize-space()='Tweet']");

    public By writeAReview = By.xpath("//a[normalize-space()='Write a review']");

    public By writeAReviewTitle = By.xpath("//input[@id='comment_title']");

    public By writeAReviewComment = By.xpath("//textarea[@id='content']");

    public By writeAReviewSendButton = By.xpath("//button[@id='submitNewMessage']");

    public By sendToAFriend = By.xpath("//a[normalize-space()='Send to a friend']");

    public By friendName = By.xpath("//*[@id=\"friend_name\"]");

    public By friendEmail = By.xpath("//*[@id=\"friend_email\"]");

    public By friendSendButton = By.xpath("//button[@id='sendEmail']//span[contains(text(),'Send')]");

    /*--------------------------------------------METHODS--------------------------------------------*/

    public ProductPage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public void item1BigPic() {
        driver.findElement(item1BigPic).click();
    }

    public void item1BigPicClose() {
        driver.findElement(item1BigPicClose).click();
    }

    public void item1ViewLarger() {
        driver.findElement(item1ViewLarger).click();
    }

    public void item1QuantityInputClear() {
        driver.findElement(item1QuantityInput).clear();
    }

    public void item1QuantityInput(String input) {
        driver.findElement(item1QuantityInput).sendKeys(input);
    }

    public void itemAddToCart() {
        driver.findElement(itemAddToCart).click();
    }

    public void nullQuantityReportClose() {
        driver.findElement(nullQuantityReportClose).click();
    }

    public void successAddToCartClose() {
        driver.findElement(successAddToCartClose).click();
    }

    public void shoppingCart() {
        driver.findElement(shoppingCart).click();
    }

    public void tweetButton() {
        driver.findElement(tweetButton).click();
    }

    public void writeAReview() {
        driver.findElement(writeAReview).click();
    }

    public void writeAReviewTitle(String input) {
        driver.findElement(writeAReviewTitle).sendKeys(input);
    }

    public void writeAReviewComment(String input) {
        driver.findElement(writeAReviewComment).sendKeys(input);
    }

    public void writeAReviewSendButton() {
        driver.findElement(writeAReviewSendButton).click();
    }

    public void sendToAFriend() {
        driver.findElement(sendToAFriend).click();
    }

    public void friendNameInput(String input) {
        driver.findElement(friendName).sendKeys(input);
    }

    public void friendEmail(String input) {
        driver.findElement(friendEmail).sendKeys(input);
    }

    public void friendSendButton() {
        driver.findElement(friendSendButton).click();
    }

    public void writeAReviewProcess() {
        writeAReview();
        ImWait(30);
        writeAReviewTitle(propData.getProperty("validWriteAReviewTitle"));
        writeAReviewComment(propData.getProperty("validWriteAReviewComment"));
        writeAReviewSendButton();
    }

    public void sendToAFriendProcess() {
        sendToAFriend();
        ImWait(30);
        friendNameInput(propData.getProperty("validFriendName"));
        friendEmail(propData.getProperty("validFriendEmail"));
        friendSendButton();
    }

    public void testingViewLargeAndQuantityProcess() {
        item1BigPic();
        ImWait(30);
        item1BigPicClose();
        item1ViewLarger();
        ImWait(30);
        item1BigPicClose();
        item1QuantityInputClear();
        item1QuantityInput("0");
        itemAddToCart();
        nullQuantityReportClose();
        item1QuantityInputClear();
        item1QuantityInput("3");
        itemAddToCart();
        ImWait(30);
        successAddToCartClose();
        shoppingCart();
    }
}
