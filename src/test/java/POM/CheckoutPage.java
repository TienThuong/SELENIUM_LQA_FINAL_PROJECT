package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BaseHQ {

    /*--------------------------------------------LOCATORS--------------------------------------------*/

    public WebElement shoppingCartSummary() {
        WebElement scs = driver.findElement(By.xpath("//h1[@id='cart_title']"));
        return scs;
    }

    public WebElement orderConfirmation() {
        WebElement scs = driver.findElement(By.cssSelector("p[class='cheque-indent'] strong[class='dark']"));
        return scs;
    }

    public WebElement tosError() {
        WebElement tose = driver.findElement(By.cssSelector("p[class='fancybox-error']"));
        return tose;
    }

    public By proceedToCheckout1 = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");

    public By proceedToCheckout2 = By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");

    public By termOfService = By.xpath("//input[@id='cgv']");

    public By proceedToCheckout3 = By.cssSelector("button[name='processCarrier'] span");

    public By payByBankWire = By.xpath("//a[@title='Pay by bank wire']");

    public By confirmedOrder = By.xpath("//span[normalize-space()='I confirm my order']");

    public By iTem1Plus = By.xpath("//tr[2]//a[@class=\"cart_quantity_up btn btn-default button-plus\"]");

    public By iTem3Delete = By.xpath("//tr[3]//a[@class=\"cart_quantity_delete\"]");

    public By tosErrorCloseButton = By.xpath("//a[@title='Close']");

    public By processToCheckoutButton = By.xpath("//a[@title='Proceed to checkout']");

    /*--------------------------------------------METHODS--------------------------------------------*/

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout1() {
        driver.findElement(proceedToCheckout1).click();
    }

    public void proceedToCheckout2() {
        driver.findElement(proceedToCheckout2).click();
    }

    public void proceedToCheckout3() {
        driver.findElement(proceedToCheckout3).click();
    }

    public void termOfServiceButton() {
        driver.findElement(termOfService).click();
    }

    public void payByBankWire() {
        driver.findElement(payByBankWire).click();
    }

    public void confirmedOrder() {
        driver.findElement(confirmedOrder).click();
    }

    public void item1Plus() {
        driver.findElement(iTem1Plus).click();
    }

    public void item3Delete() {
        driver.findElement(iTem3Delete).click();
    }

    public void tosErrorCloseButton() {
        driver.findElement(tosErrorCloseButton).click();
    }

    public void checkoutProcess() {
        proceedToCheckout1();
        proceedToCheckout2();
        termOfServiceButton();
        proceedToCheckout3();
        payByBankWire();
        confirmedOrder();
    }

    public void checkoutModify() {
        item1Plus();
        item1Plus();
        item1Plus();
        item3Delete();
        proceedToCheckout1();
        proceedToCheckout2();
        proceedToCheckout3();
    }

    public void checkoutTOSModify() {
        tosErrorCloseButton();
        termOfServiceButton();
        proceedToCheckout3();
        payByBankWire();
        confirmedOrder();
    }

    public void proceedToCheckout() {
        driver.findElement(processToCheckoutButton).click();
    }

    public void checkoutProcessFinish() {
        proceedToCheckout1();
        proceedToCheckout2();
        termOfServiceButton();
        proceedToCheckout3();
        payByBankWire();
        confirmedOrder();
    }
}
