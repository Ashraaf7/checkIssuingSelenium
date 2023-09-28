package Pages.Reports;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckImagesPage extends PageBase {
    public CheckImagesPage(WebDriver driver) {
        super(driver);
    }
    // Locators using By objects
    private By paymentTypeDropDown = By.id("dciPaymentType");
    private By dateSelect = By.cssSelector("input#dciDr");
    private By cancelButton = By.xpath("//*[@id=\"dciForm\"]/div[3]/input[1]");
    private By downloadButton = By.xpath("//input[@value='Download']");
    private By fromDate ;
    private By toDate ;
    private By applyButton = By.xpath("/html/body/div[17]/div[4]/button[2]");
    private By cancelButtonWhenSelectingDate = By.xpath("/html/body/div[17]/div[4]/button[1]");
    private By dateSpanWhenSelectingDate = By.xpath("/html/body/div[17]/div[4]/span");

    // Methods to interact with the elements
    public void selectPaymentType(String type) {
        driver.findElement(paymentTypeDropDown).click();
        Select select = new Select(driver.findElement(paymentTypeDropDown));
        select.selectByVisibleText(type);
    }
    public String verifyPaymentType() {
        Select select = new Select(driver.findElement(paymentTypeDropDown));
        WebElement selectedOption =select.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public void selectDate(String from , String to) throws InterruptedException {
        driver.findElement(dateSelect).click();
        fromDate= By.xpath("//div[contains(@class,'left')] //table[@class='table-condensed']/tbody/tr/td[text()='"+from+"']");
        toDate= By.xpath("//div[17]/div[3]/div[1]/table/tbody/tr/td[text()='"+to+"']");
        driver.findElement(fromDate).click();
        driver.findElement(toDate).click();
        Thread.sleep(2000);
        driver.findElement(applyButton).click();
    }
    public boolean verifyDate(String expectedDate) {
        driver.findElement(dateSelect).click();
        String actual=driver.findElement(dateSpanWhenSelectingDate).getText();
        clickCancelButtonWhenSelectingDate();
        if(actual.contains(expectedDate))
            return true;
        else
            return false;
    }


    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
    public void clickCancelButtonWhenSelectingDate() {
        driver.findElement(cancelButtonWhenSelectingDate).click();
    }

    public void clickDownloadButton() {
        driver.findElement(downloadButton).click();
    }

}
