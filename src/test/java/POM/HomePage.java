package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends BaseHQ {
    /*--------------------------------------------LOCATORS--------------------------------------------*/

    public By signInButton = By.xpath("//a[normalize-space()='Sign in']");

    public By newsletterInput = By.xpath("//input[@id='newsletter-input']");

    public By newsletterButton = By.xpath("//button[@name='submitNewsletter']");

    public By contactUsButton = By.xpath("//a[@title='Contact Us']");

    public WebElement newsletterSuccessfully() {
        WebElement nsf = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
        return nsf;
    }

    public By searchBox = By.xpath("//input[@id='search_query_top']");

    public By searchBoxButton = By.xpath("//button[@name='submit_search']");

    public By searchBoxResult = By.xpath("/html[1]/body[1]/div[2]/ul[1]/li[2]");

    public By iTem1 = By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line'] img[title='Faded Short Sleeve T-shirts']");

    public By atcItem1 = By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered'] a[title='Add to cart']");

    public By iTem2 = By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line'] img[title='Blouse']");

    public By atcItem2 = By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line hovered'] a[title='Add to cart']");

    public By iTem3 = By.cssSelector("#homefeatured > li:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)");

    public By atcItem3 = By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-tablet-line first-item-of-mobile-line hovered'] a[title='Add to cart']");

    public By iTem4 = By.cssSelector("#homefeatured > li:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)");

    public By atcItem4 = By.cssSelector("#homefeatured > li:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1)");

    public By iTem5 = By.cssSelector("#homefeatured > li:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)");

    public By atcItem5 = By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line last-line first-item-of-mobile-line hovered'] a[title='Add to cart']");

    public By atcItem7 = By.cssSelector("#homefeatured > li:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1)");

    public By item1Detail = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/h5/a");

    public By continueShopping = By.cssSelector("span[title='Continue shopping'] span:nth-child(1)");

    public By proceedToCheckout = By.xpath("//span[normalize-space()='Proceed to checkout']");

    public WebElement searchBoxResult() {
        WebElement sbs = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/ul[1]/li[2]"));
        return sbs;
    }

    public WebElement resultReport() {
        WebElement rr = driver.findElement(By.cssSelector("span[class='heading-counter']"));
        return rr;
    }

    public By res = By.xpath("span[class='heading-counter']");

    public WebElement showingResult() {
        WebElement sr = driver.findElement(By.xpath("//div[@class='top-pagination-content clearfix']//div[@class='product-count'][normalize-space()='Showing 1 - 7 of 7 items']"));
        return sr;
    }

    /*--------------------------------------------METHODS--------------------------------------------*/

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn() {
        driver.findElement(signInButton).click();
    }

    public void newsletterInput(String input) {
        driver.findElement(newsletterInput).sendKeys(input);
    }

    public void newsletterButtonClick() {
        driver.findElement(newsletterButton).click();
    }

    public void contactusButtonClick() {
        driver.findElement(contactUsButton).click();
    }

    public void searchBoxInput(String input) {
        driver.findElement(searchBox).sendKeys(input);
    }

    public void searchBoxClear() {
        driver.findElement(searchBox).clear();
    }

    public void searchBoxButtonClick() {
        driver.findElement(searchBoxButton).click();
    }

    public void searchBoxResultClick() {
        driver.findElement(searchBoxResult).click();
    }

    public void addToCartItem1() {
        driver.findElement(atcItem1).click();
    }

    public void addToCartItem2() {
        driver.findElement(atcItem2).click();
    }

    public void addToCartItem3() {
        driver.findElement(atcItem3).click();
    }

    public void addToCartItem4() {
        driver.findElement(atcItem4).click();
    }

    public void addToCartItem5() {
        driver.findElement(atcItem5).click();
    }

    public void addToCartItem7() {
        driver.findElement(atcItem7).click();
    }

    public void continueShoppingButton() {
        driver.findElement(continueShopping).click();
    }

    public void proceedToCheckoutButton() {
        driver.findElement(proceedToCheckout).click();
    }

    public void item1Detail() {
        driver.findElement(item1Detail).click();
    }

    public By testItem1 = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div");

    public void testing1() {
        driver.findElement(testItem1).click();
    }

    /*-------------------------------------------------------Base Methods-------------------------------------------------------*/
    public void mouseHover(By element) {
        Actions mouseHover = new Actions(driver);
        WebElement Product = driver.findElement(element);
        mouseHover.moveToElement(Product).perform();
    }

    public void ExWait(int seconds, By condition) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(condition));
    }

    public void ImWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void select3Items() {
        mouseHover(iTem1);
        ImWait(30);
        addToCartItem1();
        ExWait(30, By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2"));
        continueShoppingButton();
        mouseHover(iTem2);
        ImWait(30);
        addToCartItem2();
        ExWait(30, By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2"));
        continueShoppingButton();
        mouseHover(iTem3);
        ImWait(30);
        addToCartItem3();
        ExWait(30, By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2"));
        proceedToCheckoutButton();
    }

    public void select5Items() {
        mouseHover(iTem1);
        ImWait(30);
        addToCartItem1();
        ExWait(30, By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2"));
        continueShoppingButton();
        mouseHover(iTem2);
        ImWait(30);
        addToCartItem2();
        ExWait(30, By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2"));
        continueShoppingButton();
        mouseHover(iTem3);
        ImWait(30);
        addToCartItem3();
        ExWait(30, By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2"));
        continueShoppingButton();
        mouseHover(iTem4);
        ImWait(30);
        addToCartItem4();
        continueShoppingButton();
        ExWait(30, By.cssSelector("div[class='layer_cart_product col-xs-12 col-md-6'] h2"));
        mouseHover(iTem5);
        ImWait(30);
        addToCartItem5();
        proceedToCheckoutButton();
    }
}
