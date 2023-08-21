package Pages.Reports;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class PositivePayPage extends PageBase {
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
    public PositivePayPage(WebDriver driver) {
        super(driver);
    }
    // Methods to interact with the elements

    public void selectAccountFilter(String optionText) {
        driver.findElement(accountTypeFilter).click();
        Select select = new Select(driver.findElement(accountTypeFilter));
        select.selectByVisibleText(optionText);
    }
    public String verifyAccountFilter() {
        Select select = new Select(driver.findElement(accountTypeFilter));
        WebElement selectedOption =select.getFirstSelectedOption();
        return selectedOption.getText();
    }
    public void selectDateFilter(String optionText) {
        driver.findElement(dateFilter).click();
        Select select = new Select(driver.findElement(dateFilter));
        select.selectByVisibleText(optionText);
    }
    public String verifyDateFilter() {
        Select select = new Select(driver.findElement(dateFilter));
        WebElement selectedOption =select.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public void clickSFTPUploaderIcon() {
        driver.findElement(SFTPUploaderIcon).click();
    }

    public void clickAddSftpButton() {
        driver.findElement(addSftpButton).click();
    }

    public void addSFTPAccount(String sftpName,String bankAccount, String sftpFormat, String sftpHost, String sftpUser, String sftpPass, String directoryToUpload) {
        clickAddSftpButton();
        enterSftpName(sftpName);
        selectBankAccount(bankAccount);
        selectSftpFormat(sftpFormat);
        enterSftpHost(sftpHost);
        enterSftpUser(sftpUser);
        enterSftpPass(sftpPass);
        enterDirectoryToUpload(directoryToUpload);
        clickSaveFormatButton();
    }
    public void enterSftpName(String name) {
        driver.findElement(sftpName).clear();
        driver.findElement(sftpName).sendKeys(name);
    }
    public void selectBankAccount(String format) {
        Select select = new Select(driver.findElement(bankType));
        select.selectByVisibleText(format);
    }
    public void selectSftpFormat(String format) {
        Select select = new Select(driver.findElement(sftpFormatId));
        select.selectByVisibleText(format);
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
       return driver.findElement(addSftpButton).isDisplayed();
    }
    public void deleteSFTPAccount()
    {
         driver.findElement(deleteSftpAccount).click();
    }
    public boolean verifyDeletingSFTPAccount()
    {
        return driver.findElement(sftpTable).isDisplayed();
    }

    public void clickSFTPDownloadIcon() {
        driver.findElement(sftpDownloadIcon).click();
    }

    public void selectDownloadFormat(String format) {
        driver.findElement(downloadFileFormat).click();
        Select select = new Select(driver.findElement(downloadFileFormat));
        select.selectByVisibleText(format);
    }

    public void clickDoDownloadLink() {
        driver.findElement(doDownloadLink).click();
    }

    public boolean verifyDownloadSFTP (String filenamePattern)
    {
        int timeoutSeconds = 60;
        Path downloadDir = Paths.get("C:\\Users\\elost\\Downloads");
        boolean fileDownloaded = false;

        for (int i = 0; i < timeoutSeconds; i++) {
            if (checkFilesInDirectory(downloadDir, filenamePattern)) {
                fileDownloaded = true;
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return fileDownloaded;

    }
    private boolean checkFilesInDirectory(Path directory, String filenamePattern) {
        Pattern regex = Pattern.compile(filenamePattern);

        try {
            return Files.walk(directory)
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .anyMatch(filename -> regex.matcher(filename).matches());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
