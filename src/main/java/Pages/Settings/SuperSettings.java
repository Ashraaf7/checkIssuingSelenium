package Pages.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuperSettings   {
    protected WebDriver driver;
    public SuperSettings(WebDriver driver) {
        this.driver = driver;
    }
    // Settings Elements
    private By companyInfo = By.cssSelector("a#settings-company-tab");
    private By fundingSources = By.cssSelector("a#settings-fundingsources-tab");
    private By users = By.cssSelector("a#settings-users-tab");
    private By security = By.cssSelector("a#settings-security-tab");
    private By logos = By.cssSelector("a#settings-logos-tab");
    private By notifications = By.cssSelector("a#settings-notifications-tab");
    private By options = By.cssSelector("a#settings-options-tab");
    private By billing = By.cssSelector("a#settings-billing-tab");
    public  void clickOnCompanyInfo() {
        driver.findElement(companyInfo).click();
    }

    public void clickOnFundingSources() {
        driver.findElement(fundingSources).click();
    }

    public void clickOnUsers() {
        driver.findElement(users).click();
    }

    public void clickOnSecurity() {
        driver.findElement(security).click();
    }

    public void clickOnLogos() {
        driver.findElement(logos).click();
    }

    public void clickOnNotifications() {
        driver.findElement(notifications).click();
    }

    public void clickOnOptions() {
        driver.findElement(options).click();
    }

    public void clickOnBilling() {
        driver.findElement(billing).click();
    }







}
