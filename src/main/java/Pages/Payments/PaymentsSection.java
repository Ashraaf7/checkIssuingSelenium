package Pages.Payments;

import Utilities.Utilities;
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

public class PaymentsSection   {


    // Payment Table Elements
    private By payeeNameOnThePaymentTable = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[3]");
    private By payeeStatusOnThePaymentTable = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[5]");

    // Headers Elements
    private By statusDropDown = By.cssSelector("select#pf_datefld");
    private By filterDate = By.cssSelector("input#pf_dr");
    private By uploadPaymentButton = By.cssSelector("a.btn-primary");
    private By uploadForm = By.cssSelector("form#uploadPayFileForm");
    private By paymentForm = By.cssSelector("div.bounceInDown#sendPayment");
    private By createPaymentButton = By.cssSelector("a#sendPaymentBtn");
    private By NACHAForm = By.cssSelector("form#nachaForm");
    private By NACHAButton = By.cssSelector("a#nachaLink");
    private By upperDropDown = By.xpath("//button[@data-toggle='dropdown']");

    // Footer Elements
    private By showPerPageButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[1]/button");
    private By customizeButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[2]/button");
    private By exportPageButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[3]/button");
    private By withSelectedButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[4]/button");
    private By selectButton = By.xpath("//*[@id=\"paymentsList_wrapper\"]/div[2]/div[5]/button");
    private By applyFilterDateButton = By.xpath("/html/body/div[19]/div[4]/button[2]");
    private By noPaymentMessage = By.cssSelector("div#addusermsg");
    private By noMatchingFoundMessage = By.xpath("//*[@id=\"paymentsList\"]/tbody/tr/td");
    private By theSeventhElementInTable = By.xpath("//table[@id='paymentsList']/thead/tr/th[7]");
    private By tableRowsCount = By.xpath("//table[@id='paymentsList']/tbody/tr/td[1]");
    private By claimFlash = By.xpath("/html/body/div[22]");
    private By nextButton = By.cssSelector("#paymentsList_next");

    // Other Elements
    private By num;
    private By customize;
    private By leftDay;
    private By rightDay;
    protected WebDriver driver;
    public PaymentsSection(WebDriver driver) {
        this.driver = driver;
    }
    public PaymentsSection selectFilterDate(String status,String from , String to) throws InterruptedException {
        driver.findElement(filterDate).click();
        Utilities.selectFromDropDown(driver,selectButton,status);
        leftDay  = By.xpath("//div[contains(@class,'left')]/div/table/tbody/tr/td[text()='"+from+"']");
        driver.findElement(leftDay).click();
        rightDay  = By.xpath("//div[contains(@class,'right')]/div/table/tbody/tr/td[text()='"+to+"']");
        driver.findElement(rightDay).click();
        driver.findElement(applyFilterDateButton).click();
        Thread.sleep(2000);
        Utilities.scrollToElement(driver,showPerPageButton);
        return this;
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
        if(Utilities.byToWebElement(driver,nextButton).isDisplayed()) {
            Utilities.scrollToElement(driver,nextButton);
            //Utilities.scrollToPosition(1176,1835);
            driver.findElement(nextButton).click();
        }
    }
    public PaymentsSection selectFromFilterDropDown(String text)
    {
        customize  = By.xpath("//a[@aria-controls='paymentsList'] /span[text()='"+text+"']");
        driver.findElement(customize).click();
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
        return this;
    }
    public PaymentsSection selectFromCustomizationDropDown(String text) throws InterruptedException {
        Utilities.scrollToElement(driver,customizeButton);
        driver.findElement(customizeButton).click();
        Thread.sleep(4000);
        customize  = By.xpath("//a[@aria-controls='paymentsList'] /span[text()='"+text+"']");
        driver.findElement(customize).click();
        driver.findElement(customize).click();
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
        return this;
    }

    public PaymentsSection selectFromExportPageDropDown(String text){
        Utilities.scrollToElement(driver,exportPageButton);
        driver.findElement(exportPageButton).click();
        selectFromFilterDropDown(text);
        return this;
    }

    public PaymentsSection selectFromWithSelectedDropDown(String text){
        Utilities.scrollToElement(driver,withSelectedButton);
        driver.findElement(payeeStatusOnThePaymentTable).click();
        driver.findElement(withSelectedButton).click();
        customize  = By.xpath("//a[@aria-controls='paymentsList'] /span[text()='"+text+"']");
        driver.findElement(customize).click();
        return this;
    }
    public PaymentsSection selectFromSelectDropDown(String text) throws InterruptedException {
        Thread.sleep(3000);
        clickOnNextPageButton();
        Thread.sleep(3000);
        Utilities.scrollToElement(driver,createPaymentButton);
        driver.findElement(selectButton).click();
        selectFromFilterDropDown(text);
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
       Utilities.scrollToElement(driver,createPaymentButton);
        driver.findElement(withSelectedButton).click();
        driver.findElement(By.xpath("//a[@aria-controls='paymentsList'] /span[text()='Delete']")).click();
        return this;

    }
    public void selectNumberOfPages(String number)
    {
        driver.findElement(showPerPageButton).click();
        num  = By.xpath("//span[text()='Show "+number+" Payments']");
        Utilities.scrollToElement(driver,num);
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

    public PaymentsSection clickOnUploadPayment()
    {
        driver.findElement(uploadPaymentButton).click();
        return this;
    }
    public CreatePaymentPage clickOnCreatePayment()
    {
        driver.findElement(createPaymentButton).click();
        return new CreatePaymentPage(driver);
    }
    public PaymentsSection clickOnNACHA()
    {
        driver.findElement(NACHAButton).click();
        return this;
    }

    public boolean checkVisibilityOfCreatePaymentForm()
    {
        Utilities.explicitlyWaitForClickability(driver,paymentForm);
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
