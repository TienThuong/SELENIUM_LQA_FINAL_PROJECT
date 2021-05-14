package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Properties;

public class ContactPage extends BaseHQ {

    Properties propData = dataInput();

    /*--------------------------------------------LOCATORS--------------------------------------------*/

    public WebElement contactUs() {
        WebElement cu = driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']"));
        return cu;
    }

    public WebElement messageSuccessfullySent() {
        WebElement msf = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
        return msf;
    }

    public By createAnAccountButton = By.cssSelector("button[id='SubmitCreate'] span");

    public By subjectHeadingButton = By.xpath("//select[@id='id_contact']");

    public By emailAddressInput = By.xpath("//input[@id='email']");

    public By orderReference = By.xpath("//input[@id='id_order']");

    public By attachFileInput = By.xpath("//input[@id='fileUpload']");

    public By sendButton = By.xpath("//span[contains(text(),'Send')]");

    public By messageInput = By.xpath("//textarea[@id='message']");

    /*--------------------------------------------METHODS--------------------------------------------*/

    public ContactPage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public void subjectHeadingButton(String input) {
        int convertNumber = Integer.parseInt(input);
        Select select = new Select(driver.findElement(subjectHeadingButton));
        select.selectByIndex(convertNumber);
    }

    public void emailAddressInput(String input) {
        driver.findElement(emailAddressInput).sendKeys(input);
    }

    public void orderReferenceInput(String input) {
        driver.findElement(orderReference).sendKeys(input);
    }

    public void attachFileInput(String input) {
        driver.findElement(attachFileInput).sendKeys(input);
    }

    public void messageInput(String input) {
        driver.findElement(messageInput).sendKeys(input);
    }

    public void sendButtonClick() {
        driver.findElement(sendButton).click();
    }

    public void contactForm() {
        subjectHeadingButton(propData.getProperty("validSubjectHeading"));
        emailAddressInput(propData.getProperty("validEmailAddress"));
        orderReferenceInput(propData.getProperty("validOrderReference"));
        attachFileInput(propData.getProperty("validAttachFilePath"));
        messageInput(propData.getProperty("validMessageInput"));
        sendButtonClick();
    }
}
