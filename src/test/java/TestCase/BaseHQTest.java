package TestCase;

import POM.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseHQTest extends BaseHQ {
    /*-------------------------------------------------------TestCase 1-------------------------------------------------------*/
    @Test
    public void test1() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 1");
        eTest.info("TestCase 1 begin");
        Properties propData = dataInput();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        /*-------- Process --------*/
        homePage.signIn();
        loginPage.addEmail(propData.getProperty("invalidEmail"));
        loginPage.createAnAccountButtonClick();
        ExWait(30, By.cssSelector("#create_account_error"));

        String errorText = loginPage.invalidEmailAddressError().getText();
        if (errorText.contains("Invalid")) {
            eTest.pass("TestCase 1 passed with required condition");
        } else {
            eTest.fail("TestCase 1 failed to pass required condition");
        }
    }

    /*-------------------------------------------------------TestCase 2-------------------------------------------------------*/
    @Test
    public void test2() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 2");
        eTest.info("TestCase 2 begin");
        Properties propData = dataInput();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        /*-------- Process --------*/
        homePage.signIn();
        loginPage.addEmail(propData.getProperty("validEmailAddress"));
        loginPage.createAnAccountButtonClick();
        ExWait(30, By.xpath("//h1[normalize-space()='Create an account']"));
        loginPage.createAccount();

        String validAccount = loginPage.welcomeToYourAccount().getText();
        if (validAccount.contains("Welcome to your account.")) {
            eTest.pass("TestCase 2 passed with required condition");
        } else {
            eTest.fail("TestCase 2 failed to pass required condition");
        }
    }

    /*-------------------------------------------------------TestCase 3-------------------------------------------------------*/
    @Test
    public void test3() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 3");
        eTest.info("TestCase 3 begin");
        Properties propData = dataInput();
        HomePage homePage = new HomePage(driver);
        /*-------- Process --------*/
        homePage.newsletterInput(propData.getProperty("validEmailAddressNewsletter"));
        homePage.newsletterButtonClick();
        ExWait(30, By.xpath("//p[@class='alert alert-success']"));

        String successText = homePage.newsletterSuccessfully().getText();
        if (successText.contains("You have successfully subscribed")) {
            eTest.pass("TestCase 3 passed with required condition");
        } else {
            eTest.fail("TestCase 3 failed to pass required condition");
        }
    }

    /*-------------------------------------------------------TestCase 4-------------------------------------------------------*/
    @Test
    public void test4() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 4");
        eTest.info("TestCase 4 begin");
        HomePage homePage = new HomePage(driver);
        ContactPage contactPage = new ContactPage(driver);
        /*-------- Process --------*/
        homePage.contactusButtonClick();
        contactPage.contactForm();
        ExWait(30, By.xpath("//p[@class='alert alert-success']"));

        String expectedResult = contactPage.messageSuccessfullySent().getText();
        if (expectedResult.contains("Your message has been successfully sent to our team.")) {
            eTest.pass("TestCase 4 passed with required condition");
        } else {
            eTest.fail("TestCase 4 failed to pass required condition because server error");
        }
    }

    /*-------------------------------------------------------TestCase 5-------------------------------------------------------*/
    @Test
    public void test5() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 5");
        eTest.info("TestCase 5 begin");
        Properties propData = dataInput();
        HomePage homePage = new HomePage(driver);
        /*-------- Process --------*/
        homePage.searchBoxInput(propData.getProperty("validSearchText"));
        homePage.searchBoxClear();
        eTest.pass("TestCase 5 passed with required condition");
    }

    /*-------------------------------------------------------TestCase 6-------------------------------------------------------*/
    @Test
    public void test6() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 6");
        eTest.info("TestCase 6 begin");
        Properties propData = dataInput();
        HomePage homePage = new HomePage(driver);
        SearchPage dressSearchPage = new SearchPage(driver);
        /*-------- Process --------*/
        homePage.searchBoxInput(propData.getProperty("validSearchText"));
        ExWait(30, By.xpath("//div[@class='ac_results']"));

        String resultKeyword = homePage.searchBoxResult().getText();
        if (resultKeyword.contains("Dress")) {
            homePage.searchBoxResultClick();
            eTest.pass("TestCase 6 Part 6-1 passed with required condition");
        } else {
            eTest.fail("TestCase 6 Part 6-1 failed to process with required condition");
        }

        driver.navigate().back();
        homePage.searchBoxInput(propData.getProperty("validSearchText"));
        homePage.searchBoxButtonClick();

        String resultFound = homePage.resultReport().getText();
        String showingResult = homePage.showingResult().getText();
        if (resultFound.contains("7") && showingResult.contains("7")) {
            eTest.pass("TestCase 6 Part 6-2 passed with required condition");
        } else {
            eTest.fail("TestCase 6 Part 6-2 failed to process with required condition");
        }

        dressSearchPage.resultPrintedSummerDress().click();

        String expectedResult = dressSearchPage.resultPrice().getText();
        if (expectedResult.contains("$28.98")) {
            eTest.pass("TestCase 6 Part 6-3 passed with required condition");
        } else {
            eTest.fail("TestCase 6 Part 6-3 failed to process with required condition");
        }
    }

    /*-------------------------------------------------------TestCase 7-------------------------------------------------------*/
    @Test
    public void test7() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 7");
        eTest.info("TestCase 7 begin");
        Properties propData = dataInput();
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        /*-------- Process --------*/
        homePage.searchBoxInput(propData.getProperty("invalidSearchKeyWord"));
        homePage.searchBoxButtonClick();

        String expectedResult = searchPage.resultNotFound().getText();
        if (expectedResult.contains("No results were found for your search")) {
            eTest.pass("TestCase 7 passed with required condition");
        } else {
            eTest.fail("TestCase 7 failed to process with required condition");
        }
    }

    /*-------------------------------------------------------TestCase 8-------------------------------------------------------*/
    @Test
    public void test8() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 8");
        eTest.info("TestCase 8 begin");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        /*-------- Process --------*/
        homePage.signIn();
        loginPage.accountLogin();
        myAccountPage.backToHomePage();
        homePage.select3Items();
        checkoutPage.checkoutProcess();

        String expectedResult = checkoutPage.orderConfirmation().getText();
        if (expectedResult.contains("Your order on My Store is complete.")) {
            eTest.pass("TestCase 8 passed with required condition");
        } else {
            eTest.fail("TestCase 8 failed to process with required condition");
        }
    }

    /*-------------------------------------------------------TestCase 9-------------------------------------------------------*/
    @Test
    public void test9() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 9");
        eTest.info("TestCase 9 begin");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        /*-------- Process --------*/
        homePage.signIn();
        loginPage.accountLogin();
        myAccountPage.backToHomePage();
        homePage.select5Items();
        checkoutPage.checkoutModify();
        ImWait(30);

        String tosError = checkoutPage.tosError().getText();
        if (tosError.contains("You must agree to the terms of service before continuing.")) {
            checkoutPage.checkoutTOSModify();

            String expectedResult = checkoutPage.orderConfirmation().getText();
            if (expectedResult.contains("Your order on My Store is complete.")) {
                eTest.pass("TestCase 9 passed with required condition");
            } else {
                eTest.fail("TestCase 9 failed to process with required condition");
            }
        } else {
            eTest.fail("TestCase 9 failed to process with required condition");
        }
    }

    /*-------------------------------------------------------TestCase 10-------------------------------------------------------*/
    @Test
    public void test10() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 10");
        eTest.info("TestCase 10 begin");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ProductPage productPage = new ProductPage(driver);
        /*-------- Process --------*/
        homePage.signIn();
        loginPage.accountLogin();
        myAccountPage.backToHomePage();

        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"homefeatured\"]/li/div/div/div/span[3]"));
        boolean check = false;
        for (WebElement webElement : list) {
            if (webElement.getText().equals("-20%")) {
                check = true;
                webElement.click();
            }
        }

        productPage.itemAddToCart();
        ImWait(30);
        checkoutPage.proceedToCheckout();
        ImWait(30);
        checkoutPage.checkoutProcessFinish();

        String expectedResult = checkoutPage.orderConfirmation().getText();
        if (expectedResult.contains("Your order on My Store is complete.")) {
            eTest.pass("TestCase 10 passed with required condition");
        } else {
            eTest.fail("TestCase 10 failed to process with required condition");
        }
    }

    /*-------------------------------------------------------TestCase 11-------------------------------------------------------*/
    @Test
    public void test11() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 11");
        eTest.info("TestCase 11 begin");
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        /*-------- Process --------*/
        homePage.item1Detail();
        productPage.testingViewLargeAndQuantityProcess();

        String expectedResult = checkoutPage.shoppingCartSummary().getText();
        if (expectedResult.contains("SHOPPING-CART SUMMARY")) {
            eTest.pass("TestCase 11 passed with required condition");
        } else {
            eTest.fail("TestCase 11 failed to process with required condition");
        }
    }

    /*-------------------------------------------------------TestCase 12-------------------------------------------------------*/
    @Test
    public void test12() throws IOException, InterruptedException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 11");
        eTest.info("TestCase 11 begin");
        Properties propData = dataInput();
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        TwitterPage twitterPage = new TwitterPage(driver);
        /*-------- Process --------*/
        homePage.item1Detail();
        productPage.tweetButton();
        String parent = driver.getWindowHandle();
        Set<String> windowsIds = driver.getWindowHandles();
        for (String child_window : windowsIds) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
        Thread.sleep(5000);
        twitterPage.twitterUsername(propData.getProperty("validTwitterAccount"));
        twitterPage.twitterPassword(propData.getProperty("validTwitterPassword"));

    }

    /*-------------------------------------------------------TestCase 13-------------------------------------------------------*/
    @Test
    public void test13() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 13");
        eTest.info("TestCase 13 begin");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        ProductPage productPage = new ProductPage(driver);
        /*-------- Process --------*/
        homePage.signIn();
        loginPage.accountLogin();
        myAccountPage.backToHomePage();
        homePage.item1Detail();
        productPage.writeAReviewProcess();

        String expectedResult = productPage.commentNotify().getText();
        if (expectedResult.contains("Your comment has been added and will be available once approved by a moderator")) {
            eTest.pass("TestCase 13 passed with required condition");
        } else {
            eTest.fail("TestCase 13 failed to process with required condition");
        }
    }

    /*-------------------------------------------------------TestCase 14-------------------------------------------------------*/
    @Test
    public void test14() throws IOException {
        /*-------- Report & Setup--------*/
        ExtentTest eTest = extent.createTest("TestCase 14");
        eTest.info("TestCase 14 begin");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        ProductPage productPage = new ProductPage(driver);
        /*-------- Process --------*/
        homePage.signIn();
        loginPage.accountLogin();
        myAccountPage.backToHomePage();
        homePage.item1Detail();
        productPage.sendToAFriendProcess();

        String expectedResult = productPage.sendToAFriendText().getText();
        if (expectedResult.contains("Your e-mail has been sent successfully")) {
            eTest.pass("TestCase 14 passed with required condition");
        } else {
            eTest.fail("TestCase 14 failed to process with required condition");
        }
    }

    /*-------------------------------------------------------Based Setup-------------------------------------------------------*/
    WebDriver driver;
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void configuration() {
        String reportPath = System.getProperty("user.dir") + "/reports/TestCaseReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        System.out.println(reportPath);
        reporter.config().setReportName("Demo Test Report");
        reporter.config().setDocumentTitle("Demo Testing Report Title");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Operating System ", "MacOS Big Sur 11.4");
        extent.setSystemInfo("Tested By ", "Pham Sy Tam");
    }

    /*------------------------------------------------------------------------------------------------------------------------*/
    @BeforeMethod
    public void setupBrowser() throws IOException {
        Properties propData = dataInput();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(propData.getProperty("homePage"));
    }

    /*------------------------------------------------------------------------------------------------------------------------*/
    @AfterMethod
    public void closeBrowser() {
        driver.close();
        extent.flush();
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
}

