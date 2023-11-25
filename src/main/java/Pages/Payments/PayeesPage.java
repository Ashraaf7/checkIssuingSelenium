package Pages.Payments;

import Utilities.Utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PayeesPage extends PaymentsSection {
    public PayeesPage(WebDriver driver) {
        super(driver);
    }
    // Sort Button
    private By idSortButton = By.xpath("//*[@id=\"payeeList\"]/thead/tr/th[1]");

    // Create payee
    private By createNewPayee = By.xpath("//*[@id=\"main-wrapper\"]/div/div/div[1]/div[2]/a");
    private By fundingSource = By.id("funding_source");
    private By payeeName = By.id("payee_name");
    private By email = By.id("email");
    private By mailTo = By.id("mail_to");
    private By payeeAddress = By.id("payee_addr");
    private By taxId = By.id("taxid");
    private By transId = By.id("trans_id");
    private By reference = By.id("reference");
    private By memo = By.id("memo");
    private By amount = By.id("amount");
    private By postageType = By.id("postage_type");
    private By accountType = By.id("acct_type");

    private By addPayeeButton = By.xpath("//input[@value='Add Payee']");

    // Methods to interact with the elements
    public PayeesPage clickOnCreateNewPayee()
    {
        driver.findElement(createNewPayee).click();
        return  this;
    }
    public void selectFundingSource(String fundingSourceValue) {
        Utilities.explicitlyWaitForVisibility(driver,fundingSource);
        Utilities.selectFromDropDown(driver,fundingSource,fundingSourceValue);
    }

    public void enterPayeeName(String name) {
        driver.findElement(payeeName).clear();
        driver.findElement(payeeName).sendKeys(name);
    }

    public void enterEmail(String emailValue) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailValue);
    }

    public void enterMailTo(String mailToValue) {
        driver.findElement(mailTo).clear();
        driver.findElement(mailTo).sendKeys(mailToValue);
    }

    public void enterPayeeAddress(String address) {
        driver.findElement(payeeAddress).clear();
        driver.findElement(payeeAddress).sendKeys(address);
    }

    public void enterTaxId(String taxIdValue) {
        driver.findElement(taxId).clear();
        driver.findElement(taxId).sendKeys(taxIdValue);
    }

    public void enterTransactionId(String transIdValue) {
        driver.findElement(transId).clear();
        driver.findElement(transId).sendKeys(transIdValue);
    }

    public void enterReference(String referenceValue) {
        driver.findElement(reference).clear();
        driver.findElement(reference).sendKeys(referenceValue);
    }

    public void enterMemo(String memoValue) {
        driver.findElement(memo).clear();
        driver.findElement(memo).sendKeys(memoValue);
    }

    public void enterAmount(String amountValue) {
        driver.findElement(amount).clear();
        driver.findElement(amount).sendKeys(amountValue);
    }

    public void selectPostageType(String postageTypeValue) {
        WebElement selectElement = driver.findElement(postageType);
        Select select = new Select(selectElement);
        select.selectByVisibleText(postageTypeValue);
    }
    public void selectAccountType(String accountTypeValue) {
        WebElement selectElement = driver.findElement(accountType);
        Select select = new Select(selectElement);
        select.selectByVisibleText(accountTypeValue);
    }
    public void clickAddPayeeButton() {
        driver.findElement(addPayeeButton).click();
    }

    public PayeesPage sortIds()
    {
        Utilities.explicitlyWaitForClickability(driver,idSortButton);
        driver.findElement(idSortButton).click();
        driver.findElement(idSortButton).click();
        return this;
    }
    public PayeesPage createNewPayee(String fundingSourceValue, String name, String emailValue, String mailToValue,
                               String address, String taxIdValue, String transIdValue, String referenceValue,
                               String memoValue, String amountValue, String postageTypeValue, String accountTypeValue)
    {
        selectFundingSource(fundingSourceValue);
        enterPayeeName(name);
        enterEmail(emailValue);
        enterMailTo(mailToValue);
        enterPayeeAddress(address);
        enterTaxId(taxIdValue);
        enterTransactionId(transIdValue);
        enterReference(referenceValue);
        enterMemo(memoValue);
        enterAmount(amountValue);
        selectPostageType(postageTypeValue);
        selectAccountType(accountTypeValue);
        clickAddPayeeButton();
        return this;
    }


    // Payee Actions
    private By payPayee = By.xpath("//table[@id='payeeList']/tbody/tr[1]/td[5]//a[@title=\"Pay Payee\"]");

    // Disable and its elements
    private By disablePayee = By.xpath("//table[@id='payeeList']/tbody/tr[1]/td[5]//a[@title=\"Disable Payee\"]");
    private By enablePayee = By.xpath("//table[@id='payeeList']/tbody/tr[1]/td[5]//a[@title=\"Enable Payee\"]");
    private By enabledStatus = By.xpath("//table[@id='payeeList']/tbody/tr[1]/td[4]");

    // Payee details and its elements
    private By payeeDetails = By.xpath("//table[@id='payeeList']/tbody/tr[1]/td[5]//a[@title=\"Payee Details\"]");
    private By payeeNameOnThePayeeTable = By.xpath("//*[@id=\"payeeList\"]/tbody/tr[1]/td[2]");
    private By payeeNameOnTheHeader = By.xpath("//div/div/div[3]/div/div/form/div[1]/h4");

    // Delete and its elements
    private By deletePayee = By.xpath("//table[@id='payeeList']/tbody/tr[1]/td[5]//a[@title=\"Delete Payee\"]");

    public PayeesPage clickOnPayPayee() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(payPayee).click();
        return this;
    }
    public PayeesPage clickOnDisablePayee()throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(disablePayee).click();
        return this;
    }

    public void clickOnEnablePayee() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(enablePayee).click();
    }
    public PayeesPage clickOnPayeeDetails()throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(payeeDetails).click();
        return this;
    }
    public PayeesPage clickOnDeletePayee() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(deletePayee).click();
        return this;
    }
    public boolean verifyThatPayPayeeAppears()
    {
        return checkVisibilityOfCreatePaymentForm();
    }
    public String verifyThatDisablePayeeAppears()
    {
        Utilities.explicitlyWaitForVisibility(driver,enabledStatus);
        return driver.findElement(enabledStatus).getText();
    }
    public String getPayeeName()
    {
        return driver.findElement(payeeNameOnThePayeeTable).getText();
    }
    public String verifyThatPayeeDetailsAppears()
    {
        Utilities.explicitlyWaitForVisibility(driver,payeeNameOnTheHeader);
        return driver.findElement(payeeNameOnTheHeader).getText();
    }
    public boolean verifyThatDeletePayeeAppears()
    {
        Utilities.explicitlyWait(driver).until(ExpectedConditions.alertIsPresent());
        return !driver.switchTo().alert().getText().equalsIgnoreCase("");
    }


}
