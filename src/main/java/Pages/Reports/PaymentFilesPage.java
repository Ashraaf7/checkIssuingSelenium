package Pages.Reports;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class PaymentFilesPage   {
    private WebDriver driver;
    public PaymentFilesPage(WebDriver driver) {
        this.driver= driver;
    }
    // Locators using By objects
    private By filterPayments = By.cssSelector("select#dr_shortcuts");
    private By downloadIcon = By.xpath("//*[@id=\"paymentFileList\"]/tbody/tr[1]/td[7]/a[@title='Download Payment File']");
    private By fileNameOnTable = By.xpath("//*[@id=\"paymentFileList\"]/tbody/tr[1]/td[2]");
    private By dateOneTheTable = By.xpath("//*[@id=\"paymentFileList\"]/tbody/tr[1]/td[3]");
    private By sortTheDate = By.xpath("//*[@id=\"paymentFileList\"]/thead/tr/th[3]");
    private By trueIcon = By.xpath("//*[@id=\"paymentFileList\"]/tbody/tr[1]/td[7]/a[@title='Confirm Payment File']");

    // Methods to interact with the elements
    public boolean verifyFilteringOption()
    {
        Utilities.explicitlyWaitForVisibility(driver,dateOneTheTable);
       String first= driver.findElement(dateOneTheTable).getText();
        driver.findElement(sortTheDate).click();
        String last= driver.findElement(dateOneTheTable).getText();
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        String dayString = Integer.toString(day);
        return first.contains(dayString) && last.contains(dayString);
    }
    public boolean verifyTrueIcon()
    {
        return driver.findElement(trueIcon).isDisplayed();
    }
    public PaymentFilesPage selectFilterPayments(String optionText) {
        driver.findElement(filterPayments).click();
        Utilities.selectFromDropDown(driver,filterPayments,optionText);
        return this;
    }


    public PaymentFilesPage clickOnDownloadIcon() {
        driver.findElement(downloadIcon).click();
        return this;
    }

    public String getFileName ()
    {
       return driver.findElement(fileNameOnTable).getText();
    }

}
