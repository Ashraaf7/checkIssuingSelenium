package Pages.Payments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PayeesPage extends PaymentsSection {
    By idSortButton = By.xpath("//*[@id=\"payeeList\"]/thead/tr/th[1]");

    //Create payee
    By createNewPayee = By.xpath("//*[@id=\"main-wrapper\"]/div/div/div[1]/div[2]/a");
    By fundingSource = By.id("funding_source");
    By payeeName = By.id("payee_name");
    By email = By.id("email");
    By mailTo = By.id("mail_to");
    By payeeAddress = By.id("payee_addr");
    By taxId = By.id("taxid");
    By transId = By.id("trans_id");
    By reference = By.id("reference");
    By memo = By.id("memo");
    By amount = By.id("amount");
    By postageType = By.id("postage_type");
    By accountType = By.id("acct_type");

    By addPayeeButton = By.xpath("//input[@value='Add Payee']");
    // Methods to interact with the elements
    public void clickOnCreateNewPayee()
    {
        driver.findElement(createNewPayee).click();
    }
    public void createNewPayee(String fundingSourceValue, String name, String emailValue, String mailToValue,
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
    }
    public void selectFundingSource(String fundingSourceValue) {
        WebElement selectElement = driver.findElement(fundingSource);
        Select select = new Select(selectElement);
        select.selectByVisibleText(fundingSourceValue);
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

    public void sortIds()
    {
        driver.findElement(idSortButton).click();
        driver.findElement(idSortButton).click();
    }
    By payPayee = By.xpath("//table[@id='payeeList'] /tbody /tr[1] /td[5] //a[@title=\"Pay Payee\"]");

    //Disable and its elements
    By disablePayee = By.xpath("//table[@id='payeeList'] /tbody /tr[1] /td[5] //a[@title=\"Disable Payee\"]");
    By enabledStatus = By.xpath("//table[@id='payeeList'] /tbody /tr[1] /td[4]");

    //Payee details and its elements
    By payeeDetails = By.xpath("//table[@id='payeeList'] /tbody /tr[1] /td[5] //a[@title=\"Payee Details\"]");
    By payeeNameOnThePayeeTable = By.xpath("//*[@id=\"payeeList\"]/tbody/tr[1]/td[2]");
    By payeeNameOnTheHeader = By.xpath("//div/div/div[3]/div/div/form/div[1]/h4");

    //Delete and its elements
    By deletePayee = By.xpath("//table[@id='payeeList'] /tbody /tr[1] /td[5] //a[@title=\"Delete Payee\"]");
    Alert alert ;
    public PayeesPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnPayPayee() {
        driver.findElement(payPayee).click();
    }
    public void clickOnDisablePayee() {
        driver.findElement(disablePayee).click();
    }
    public void clickOnPayeeDetails() {
        driver.findElement(payeeDetails).click();
    }
    public void clickOnDeletePayee() {
        driver.findElement(deletePayee).click();
    }
    public boolean verifyThatPayPayeeAppears()
    {
        return checkVisibilityOfCreatePaymentForm();
    }
    public String verifyThatDisablePayeeAppears()
    {
        return driver.findElement(enabledStatus).getText();
    }
    public String getPayeeName()
    {
        return driver.findElement(payeeNameOnThePayeeTable).getText();
    }
    public String verifyThatPayeeDetailsAppears()
    {
        return driver.findElement(payeeNameOnTheHeader).getText();
    }
    public boolean verifyThatDeletePayeeAppears()
    {
        alert = driver.switchTo().alert();
        String flag ="";
        flag = alert.getText();
        if(!flag.equalsIgnoreCase(""))
            return true;
        else
            return false;
    }


}
