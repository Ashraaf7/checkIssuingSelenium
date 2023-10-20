package Pages.Payments;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaymentsSection extends PageBase {


    By payeeNameOnThePaymentTable = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[3]");

    By payeeStatusOnThePaymentTable = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[5]");
    //Headers Elements
    By statusDropDown = By.cssSelector("select#pf_datefld");
    By filterDate = By.cssSelector("input#pf_dr");
    By uploadPaymentButton = By.cssSelector("a.btn-primary");
    By uploadForm = By.cssSelector("form#uploadPayFileForm");
    By paymentForm = By.cssSelector("div.bounceInDown#sendPayment");

    By createPaymentButton = By.cssSelector("a#sendPaymentBtn");
    By NACHAForm = By.cssSelector("form#nachaForm");

    By NACHAButton = By.cssSelector("a#nachaLink");
    By upperDropDown = By.xpath("//button[@data-toggle='dropdown']");

    //Footer Elements
    By showPerPageButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[1]/button");
    By customizeButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[2]/button");
    By exportPageButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[3]/button");
    By withSelectedButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[4]/button");
    By selectButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[5]/button");
    By applyFilterDateButton = By.xpath("/html/body/div[19]/div[4]/button[2]");
    By noPaymentMessage = By.cssSelector("div#addusermsg");
    By noMatchingFoundMessage = By.xpath("//*[@id=\"paymentsList\"]/tbody/tr/td");
    By theSeventhElementInTable = By.xpath("//table[@id='paymentsList'] /thead /tr /th[7] ");
    By tableRowsCount = By.xpath("//table[@id='paymentsList'] /tbody /tr /td[1]");
    By claimFlash = By.xpath("/html/body/div[22]");
    By nextButton = By.cssSelector("#paymentsList_next");
    By num;
    By customize;
    By leftDay;
    By rightDay;
    Select helperSelect ;
    Actions actions;
    public PaymentsSection(WebDriver driver) {
        super(driver);
    }
    public void filerByStatus (String status){
        WebElement statusDropDownElement =driver.findElement(statusDropDown);
        helperSelect = new Select(statusDropDownElement);
        helperSelect.selectByVisibleText(status);
    }
    public void selectFilterDate(String status,String from , String to) throws InterruptedException {
        driver.findElement(filterDate).click();
        filerByStatus(status);
        leftDay  = By.xpath("//div[contains(@class,'left')]/div/table/tbody/tr/td[text()='"+from+"']");
        driver.findElement(leftDay).click();
        rightDay  = By.xpath("//div[contains(@class,'right')]/div/table/tbody/tr/td[text()='"+to+"']");
        driver.findElement(rightDay).click();
        driver.findElement(applyFilterDateButton).click();
        Thread.sleep(2000);
        PageBase.scrollToElement(showPerPageButton);
    }
    public boolean verifyNoMatchingFoundMessage()
    {
        return driver.findElement(noMatchingFoundMessage).isDisplayed();
    }
    public boolean verifyNoPaymentMessage()
    {
        return driver.findElement(noPaymentMessage).isDisplayed();
    }
    public void clickOnNextPageButton()
    {
        WebElement flagNextButton = driver.findElement(nextButton);
        if(flagNextButton.isDisplayed()) {
            PageBase.scrollToElement(nextButton);
            //PageBase.scrollToPosition(1176,1835);
            driver.findElement(nextButton).click();
        }
    }
    public void selectFromFilterDropDown(String text)
    {
        customize  = By.xpath("//a[@aria-controls='paymentsList'] /span[text()='"+text+"']");
        driver.findElement(customize).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }
    public void selectFromCustomizationDropDown(String text) throws InterruptedException {
        PageBase.scrollToElement(customizeButton);
        driver.findElement(customizeButton).click();
        Thread.sleep(4000);
        customize  = By.xpath("//a[@aria-controls='paymentsList'] /span[text()='"+text+"']");
        driver.findElement(customize).click();
        driver.findElement(customize).click();
        actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void selectFromExportPageDropDown(String text){
        PageBase.scrollToElement(exportPageButton);
        driver.findElement(exportPageButton).click();
        selectFromFilterDropDown(text);
    }
    public boolean verifyExportPage()
    {
        int timeoutSeconds = 60;
        Path filePath = Paths.get(downloadFilePath, "Checkissuing.csv");
        boolean fileDownloaded = false;

        for (int i = 0; i < timeoutSeconds; i++) {
            if (Files.exists(filePath)) {
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

    public void selectFromWithSelectedDropDown(String text){
        PageBase.scrollToElement(withSelectedButton);
        driver.findElement(payeeStatusOnThePaymentTable).click();
        driver.findElement(withSelectedButton).click();
        customize  = By.xpath("//a[@aria-controls='paymentsList'] /span[text()='"+text+"']");
        driver.findElement(customize).click();
    }
    public void selectFromSelectDropDown(String text) throws InterruptedException {
        Thread.sleep(3000);
        clickOnNextPageButton();
        Thread.sleep(3000);
        PageBase.scrollToElement(createPaymentButton);
        driver.findElement(selectButton).click();
        selectFromFilterDropDown(text);
        actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
       PageBase.scrollToElement(createPaymentButton);
        driver.findElement(withSelectedButton).click();
        driver.findElement(By.xpath("//a[@aria-controls='paymentsList'] /span[text()='Delete']")).click();
    }
    public void selectNumberOfPages(String number)
    {
        driver.findElement(showPerPageButton).click();
        num  = By.xpath("//span[text()='Show "+number+" Payments']");
        PageBase.scrollToElement(num);
        driver.findElement(num).click();
    }
    public boolean verifyClaimFlash(){
        return  driver.findElement(claimFlash).isDisplayed();
    }
    public String verifySelectFromFilterDropDown(){
        return  driver.findElement(payeeStatusOnThePaymentTable).getText();
    }
    public String getTheLastPayee()  {
        return driver.findElement(payeeNameOnThePaymentTable).getText();
    }

    public int getPaymentsCount()  {
        List<WebElement> tableElements=  driver.findElements(tableRowsCount);
        return tableElements.size();
    }

    public String checkCustomization()  {
        return driver.findElement(theSeventhElementInTable).getText();
    }

    public void clickOnUploadPayment()
    {
        driver.findElement(uploadPaymentButton).click();
    }
    public void clickOnCreatePayment()
    {
        driver.findElement(createPaymentButton).click();
    }
    public void clickOnNACHA()
    {
        driver.findElement(NACHAButton).click();
    }

    public boolean checkVisibilityOfCreatePaymentForm()
    {
        return driver.findElement(paymentForm).isDisplayed();

    }
    public boolean checkVisibilityOfUploadPaymentForm()
    {
        return driver.findElement(uploadForm).isDisplayed();

    }   public boolean checkVisibilityOfNACHAForm()
    {
        return driver.findElement(NACHAForm).isDisplayed();

    }
}
