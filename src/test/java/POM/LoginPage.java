package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BaseHQ {

    Properties propData = dataInput();

    /*--------------------------------------------LOCATORS--------------------------------------------*/

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement invalidEmailAddressError;

    public By createAnAccountButton = By.cssSelector("button[id='SubmitCreate'] span");

    public By emailAddressInput = By.cssSelector("#email_create");

    public By titleMrButton = By.cssSelector("#id_gender1");

    public By titleMrsButton = By.cssSelector("#id_gender2");

    public By firstNameInput = By.cssSelector("#customer_firstname");

    public By lastNameInput = By.cssSelector("#customer_lastname");

    public By emailInput = By.cssSelector("#email");

    public By passwordInput = By.cssSelector("#passwd");

    public By dobDayButton = By.cssSelector("#days");

    public By dobMonthButton = By.cssSelector("#months");

    public By dobYearButton = By.cssSelector("#years");

    public By newsletterButton = By.cssSelector("#newsletter");

    public By specialOffersButton = By.cssSelector("#optin");

    public By addressFirstNameInput = By.cssSelector("#firstname");

    public By addressLastNameInput = By.cssSelector("#lastname");

    public By addressCompanyInput = By.cssSelector("#company");

    public By addressAddress1Input = By.cssSelector("#address1");

    public By addressAddress2Input = By.cssSelector("#address2");

    public By addressCityInput = By.cssSelector("#city");

    public By addressStateButton = By.cssSelector("#id_state");

    public By addressPostalCodeInput = By.cssSelector("#postcode");

    public By addressCountryButton = By.cssSelector("#id_country");

    public By addressAdditionalInformationInput = By.cssSelector("#other");

    public By addressHomePhoneInput = By.cssSelector("#phone");

    public By addressMobilePhoneInput = By.cssSelector("#phone_mobile");

    public By addressAliasInput = By.cssSelector("#alias");

    public By registerButton = By.cssSelector("button[id='submitAccount'] span");

    public By emailAddressLogIn = By.xpath("//input[@id='email']");

    public By passwordLogin = By.xpath("//input[@id='passwd']");

    public By signInButton = By.xpath("//span[normalize-space()='Sign in']");

    public WebElement invalidEmailAddressError() {
        WebElement elt = invalidEmailAddressError;
        return elt;
    }

    public WebElement welcomeToYourAccount() {
        WebElement wta = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
        return wta;
    }

    /*--------------------------------------------METHODS--------------------------------------------*/

    public LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void addEmail(String input) {
        driver.findElement(emailAddressInput).sendKeys(input);
    }

    public void createAnAccountButtonClick() {
        driver.findElement(createAnAccountButton).click();
    }

    public void titleMrButtonClick() {
        driver.findElement(titleMrButton).click();
    }

    public void titleMrsButtonClick() {
        driver.findElement(titleMrsButton).click();
    }

    public void firstNameInput(String input) {
        driver.findElement(firstNameInput).sendKeys(input);
    }

    public void lastNameInput(String input) {
        driver.findElement(lastNameInput).sendKeys(input);
    }

    public void passwordInput(String input) {
        driver.findElement(passwordInput).sendKeys(input);
    }

    public void dobDaySet(String input) {
        int convertNumber = Integer.parseInt(input);
        Select select = new Select(driver.findElement(dobDayButton));
        select.selectByIndex(convertNumber);
    }

    public void dobMonthSet(String input) {
        int convertNumber = Integer.parseInt(input);
        Select select = new Select(driver.findElement(dobMonthButton));
        select.selectByIndex(convertNumber);
    }

    public void dobYearSet(String input) {
        int convertNumber = Integer.parseInt(input);
        Select select = new Select(driver.findElement(dobYearButton));
        select.selectByIndex(convertNumber);
    }

    public void signUpNewsletterButton() {
        driver.findElement(newsletterButton).click();
    }

    public void receiveSpecialOffersButton() {
        driver.findElement(specialOffersButton).click();
    }

    public void addressFirstNameInput(String input) {
        driver.findElement(addressFirstNameInput).sendKeys(input);
    }

    public void addressLastNameInput(String input) {
        driver.findElement(addressLastNameInput).sendKeys(input);
    }

    public void addressCompanyInput(String input) {
        driver.findElement(addressCompanyInput).sendKeys(input);
    }

    public void addressAddress1Input(String input) {
        driver.findElement(addressAddress1Input).sendKeys(input);
    }

    public void addressAddress2Input(String input) {
        driver.findElement(addressAddress2Input).sendKeys(input);
    }

    public void addressCityInput(String input) {
        driver.findElement(addressCityInput).sendKeys(input);
    }

    public void addressStateButton(String input) {
        int convertNumber = Integer.parseInt(input);
        Select select = new Select(driver.findElement(addressStateButton));
        select.selectByIndex(convertNumber);
    }

    public void addressPostalCodeInput(String input) {
        driver.findElement(addressPostalCodeInput).sendKeys(input);
    }

    public void addressCountryButton(String input) {
        int convertNumber = Integer.parseInt(input);
        Select select = new Select(driver.findElement(addressCountryButton));
        select.selectByIndex(convertNumber);
    }

    public void addressAdditionalInformationInput(String input) {
        driver.findElement(addressAdditionalInformationInput).sendKeys(input);
    }

    public void addressHomePhoneInput(String input) {
        driver.findElement(addressHomePhoneInput).sendKeys(input);
    }

    public void addressMobilePhoneInput(String input) {
        driver.findElement(addressMobilePhoneInput).sendKeys(input);
    }

    public void addressAliasInput(String input) {
        driver.findElement(addressAliasInput).clear();
        driver.findElement(addressAliasInput).sendKeys(input);
    }

    public void registerButtonClick() {
        driver.findElement(registerButton).click();
    }

    public void emailAddressLogin(String input) {
        driver.findElement(emailAddressLogIn).sendKeys(input);
    }

    public void passwordLogin(String input) {
        driver.findElement(passwordLogin).sendKeys(input);
    }

    public void signInButtonClick() {
        driver.findElement(signInButton).click();
    }

    public void createAccount() {
        titleMrButtonClick();
        firstNameInput(propData.getProperty("validFirstName"));
        lastNameInput(propData.getProperty("validLastName"));
        passwordInput(propData.getProperty("validPassword"));
        dobDaySet(propData.getProperty("validDobDay"));
        dobMonthSet(propData.getProperty("validDobMonth"));
        dobYearSet(propData.getProperty("validDobYear"));
        signUpNewsletterButton();
        receiveSpecialOffersButton();
        addressCompanyInput(propData.getProperty("validCompany"));
        addressAddress1Input(propData.getProperty("validAddress1"));
        addressAddress2Input(propData.getProperty("validAddress2"));
        addressCityInput(propData.getProperty("validCity"));
        addressStateButton(propData.getProperty("validState"));
        addressPostalCodeInput(propData.getProperty("validPostalCode"));
        addressAdditionalInformationInput(propData.getProperty("validAdditionalInformation"));
        addressHomePhoneInput(propData.getProperty("validHomePhone"));
        addressMobilePhoneInput(propData.getProperty("validMobilePhone"));
        addressAliasInput(propData.getProperty("validAlias"));
        registerButtonClick();
    }

    public void accountLogin() {
        emailAddressLogin(propData.getProperty("validEmailAddress"));
        passwordLogin(propData.getProperty("validPassword"));
        signInButtonClick();
    }

}
