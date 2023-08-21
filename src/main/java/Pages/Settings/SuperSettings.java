package Pages.Settings;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuperSettings extends PageBase {
    public SuperSettings(WebDriver driver) {
        super(driver);
    }
    By companyInfo = By.cssSelector("a#settings-company-tab");
    By fundingSources = By.cssSelector("a#settings-fundingsources-tab");
    By users = By.cssSelector("a#settings-users-tab");
    By security = By.cssSelector("a#settings-security-tab");
    By logos = By.cssSelector("a#settings-logos-tab");
    By notifications = By.cssSelector("a#settings-notifications-tab");
    By options = By.cssSelector("a#settings-options-tab");
    By billing = By.cssSelector("a#settings-billing-tab");

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
