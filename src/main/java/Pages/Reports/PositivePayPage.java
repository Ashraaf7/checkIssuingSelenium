package Pages.Reports;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class PositivePayPage   {
    // Locators using By objects
    private By accountTypeFilter = By.cssSelector("select#fs_filter");
    private By dateFilter = By.cssSelector("select#dr_shortcuts");
    private By  SFTPUploaderIcon =By.cssSelector("a#sftpBtn");
    private By addSftpButton = By.xpath("//*[@id=\"addSftpBtn\"]");
    private By sftpName = By.cssSelector("input#sftpName");
    private By bankType = By.cssSelector("select#sftpAcctId");
    private By sftpFormatId = By.cssSelector("select#sftpFormatId");
    private By sftpHost = By.cssSelector("input#sftpHost");
    private By sftpUser = By.cssSelector("input#sftpUser");
    private By sftpPass = By.cssSelector("input#sftpPass");
    private By directoryUploadTo = By.cssSelector("input#sftpDir");
    private By saveFormatBtn = By.id("saveFormatBtn");
    private By sftpDownloadIcon = By.xpath("//*[@id=\"downloadLink\"]");
    private By downloadFileFormat = By.cssSelector("select#ppDlFormatId");
    private By doDownloadLink = By.cssSelector("a#doDownloadLink");
    private By sftpTable = By.xpath("//*[@id=\"sftpModal\"]/div/div/div[2]/table");
    private By deleteSftpAccount = By.xpath("//*[@id=\"sftpModal\"]/div/div/div[2]/table/tbody/tr/td[3]/a");

    private WebDriver driver;
    public PositivePayPage(WebDriver driver) {
        this.driver= driver;
    }
    // Methods to interact with the elements

    public void selectAccountFilter(String optionText) {
        Utilities.explicitlyWaitForClickability(driver,accountTypeFilter);
        driver.findElement(accountTypeFilter).click();
        Utilities.selectFromDropDown(driver,accountTypeFilter,optionText);
    }
    public String verifyAccountFilter() {
        Utilities.explicitlyWaitForVisibility(driver,accountTypeFilter);
        return Utilities.getSelectedOptionFromDropDown(driver,accountTypeFilter).getText();
    }
    public void selectDateFilter(String optionText) {
        Utilities.explicitlyWaitForClickability(driver,dateFilter);
        driver.findElement(dateFilter).click();
        Utilities.selectFromDropDown(driver,dateFilter,optionText);

    }
    public String verifyDateFilter() {
        Utilities.explicitlyWaitForVisibility(driver,dateFilter);
        return Utilities.getSelectedOptionFromDropDown(driver,dateFilter).getText();
    }

    public PositivePayPage clickSFTPUploaderIcon() {
        driver.findElement(SFTPUploaderIcon).click();
        return this;
    }

    public void clickAddSftpButton() {
        driver.findElement(addSftpButton).click();
    }

    public PositivePayPage addSFTPAccount(String sftpName,String bankAccount, String sftpFormat, String sftpHost, String sftpUser, String sftpPass, String directoryToUpload) {
        clickAddSftpButton();
        enterSftpName(sftpName);
        Utilities.selectFromDropDown(driver,bankType,bankAccount);
        Utilities.selectFromDropDown(driver,sftpFormatId,sftpFormat);
        enterSftpHost(sftpHost);
        enterSftpUser(sftpUser);
        enterSftpPass(sftpPass);
        enterDirectoryToUpload(directoryToUpload);
        clickSaveFormatButton();
        return this;
    }
    public void enterSftpName(String name) {
        driver.findElement(sftpName).clear();
        driver.findElement(sftpName).sendKeys(name);
    }

    public void enterSftpHost(String host) {
        driver.findElement(sftpHost).clear();
        driver.findElement(sftpHost).sendKeys(host);
    }

    public void enterSftpUser(String user) {
        driver.findElement(sftpUser).clear();
        driver.findElement(sftpUser).sendKeys(user);
    }

    public void enterSftpPass(String pass) {
        driver.findElement(sftpPass).clear();
        driver.findElement(sftpPass).sendKeys(pass);
    }
    public void enterDirectoryToUpload(String pass) {
        driver.findElement(directoryUploadTo).clear();
        driver.findElement(directoryUploadTo).sendKeys(pass);
    }

    public void clickSaveFormatButton() {
        driver.findElement(saveFormatBtn).click();
    }
    public boolean verifyAddingSFTPAccount()
    {
        Utilities.explicitlyWaitForVisibility(driver,addSftpButton);
       return driver.findElement(addSftpButton).isDisplayed();
    }
    public PositivePayPage deleteSFTPAccount()
    {
         driver.findElement(deleteSftpAccount).click();
         return this;
    }
    public boolean verifyDeletingSFTPAccount()
    {
        return driver.findElement(sftpTable).isDisplayed();
    }

    public PositivePayPage clickSFTPDownloadIcon() {
        driver.findElement(sftpDownloadIcon).click();
        return this;
    }

    public PositivePayPage selectDownloadFormat(String format) {
        driver.findElement(downloadFileFormat).click();
        Utilities.selectFromDropDown(driver,downloadFileFormat,format);
        return this;
    }

    public PositivePayPage clickDoDownloadLink() {
        driver.findElement(doDownloadLink).click();
        return this;
    }


}
