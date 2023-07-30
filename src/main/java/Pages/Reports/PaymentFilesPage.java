package Pages.Reports;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

public class PaymentFilesPage extends PageBase {
    // Locators using By objects
    private By filterPayments = By.cssSelector("select#dr_shortcuts");
    private By downloadIcon = By.xpath("//*[@id=\"paymentFileList\"]/tbody/tr[1]/td[7]/a[@title='Download Payment File']");
    private By dateOneTheTable = By.xpath("//*[@id=\"paymentFileList\"]/tbody/tr[1]/td[3]");
    private By sortTheDate = By.xpath("//*[@id=\"paymentFileList\"]/thead/tr/th[3]");
    private By trueIcon = By.xpath("//*[@id=\"paymentFileList\"]/tbody/tr[1]/td[7]/a[@title='Confirm Payment File']");
    public PaymentFilesPage(WebDriver driver) {
        super(driver);
    }
    // Methods to interact with the elements
    public boolean verifyFilteringOption()
    {
       String first= driver.findElement(dateOneTheTable).getText();
        driver.findElement(sortTheDate).click();
        String last= driver.findElement(dateOneTheTable).getText();
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        String dayString = Integer.toString(day);
        if(first.contains(dayString) && last.contains(dayString))
            return true;
        else
            return false;
    }
    public boolean verifyTrueIcon()
    {
        return driver.findElement(trueIcon).isDisplayed();
    }
    public void selectFilterPayments(String optionText) {
        driver.findElement(filterPayments).click();
        Select select = new Select(driver.findElement(filterPayments));
        select.selectByVisibleText(optionText);
    }


    public void clickOnDownloadIcon() {
        driver.findElement(downloadIcon).click();
    }
}
