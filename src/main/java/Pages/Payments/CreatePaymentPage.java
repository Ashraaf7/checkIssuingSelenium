package Pages.Payments;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreatePaymentPage extends PaymentsSection {
    public CreatePaymentPage(WebDriver driver) {
        super(driver);
    }
    // Create On Check Elements
    private By createCheck = By.xpath("(//a[@data-toggle='tab'])[1]");
    private By payeeNameOnCreateCheck = By.xpath("(//input[@placeholder='Payee Name'])[2]");
    private By payeeAddressOnCreateCheck = By.xpath("(//input[@id='addr'])");
    private By amountOnCreateCheck = By.cssSelector("input#spamt");
    private By amountTypeDropDown = By.cssSelector("select#sp_currency");
    private By memoOnCreateCheck = By.cssSelector("input#sp_memo");
    private By postage = By.cssSelector("select#sp_postage");
    private By onOffTriggerOnCheck = By.cssSelector("#sp_save_payee_wrap > label > div > div > span.bootstrap-switch-label");
    private By submitPaymentButton = By.cssSelector("input#paymentSubmitBtn");
    private By basicAdvancedButton = By.cssSelector("a#sp-advanced-link");

    // Advanced On Check Elements
    private By sendDateOnCheck = By.cssSelector("input#sp_senddate_fld");
    private By date;
    private By dateOnCheck = By.cssSelector("input#sp_checkdate_fld");
    private By insertOnCheckDropDown = By.cssSelector("select#sp_insert");
    private By check = By.cssSelector("input#sp_checknum");
    private By taxIdOnCheck = By.cssSelector("input#sp_taxid");
    private By internetRefOnCheck = By.cssSelector("#sp-advanced-opts > div:nth-child(8) > div > input");
    private By logoElement = By.cssSelector("select#sp_logo");

    // Create an ACH Elements
    private By createACH = By.xpath("(//a[@data-toggle='tab'])[2]");
    private By bankDropDown = By.cssSelector("select#ach_sp_acct");
    private By payeeNameOnACHCheck = By.xpath("(//input[@placeholder='Payee Name'])[3]");
    private By payeeAddressOnACHCheck = By.cssSelector("input#ach_addr");
    private By amountOnACHCheck = By.cssSelector("input#ach_spamt");
    private By memoOnACHCheck = By.xpath("//*[@id=\"ach_sp_memo\"]");
    private By amountDropDownACH = By.cssSelector("select#ach_sp_currency");
    private By payeeAccountTypeDropDown = By.cssSelector("select#ach_sp_acct_type");
    private By payeeAccountNumber= By.cssSelector("input#ach_sp_acct_num");
    private By payeeRoutingNumber= By.cssSelector("#ach_sp_routing_num");
    private By password= By.cssSelector("input#ach_sp_pass");
    private By ACHBasicAdvancedTrigger = By.xpath("/html/body/div[2]/div/div/div[4]/div/div[2]/div[2]/form/ul/li[1]/div[7]/div/a");
    private By submitPaymentButtonACH = By.cssSelector("input#achPaymentSubmitBtn");

    // Advanced On ACH Elements
    private By sendDateOnACH = By.cssSelector("#ach_sp_senddate_fld");
    private By insertOnACHDropDown = By.cssSelector("#ach_sp_insert");
    private By taxIdOnACH = By.cssSelector("#ach_sp_taxid");
    private By internetRefOnACH = By.cssSelector("#ach_sp_reference");
    private By onOffTriggerOnaACH = By.cssSelector("#ach_sp_save_payee_wrap > label > div > div > span.bootstrap-switch-label");

    public void selectDay(String day)
    {
        date  = By.xpath("//td /a[text()='"+day+"']");
        driver.findElement(date).click();
    }

     public void fillCheckForm(String payeeName,String payeeAddress,String amount,String memo ,String amountType,String postageOption)
     {
         driver.findElement(payeeNameOnCreateCheck).sendKeys(payeeName);
         driver.findElement(payeeAddressOnCreateCheck).sendKeys(payeeAddress);
         driver.findElement(amountOnCreateCheck).sendKeys(amount);
         Utilities.selectFromDropDown(driver,amountTypeDropDown,amountType);
         driver.findElement(memoOnCreateCheck).sendKeys(memo);
         Utilities.selectFromDropDown(driver,postage,postageOption);
         driver.findElement(onOffTriggerOnCheck).click();
         driver.findElement(onOffTriggerOnCheck).click();
     }
    public void fillACHForm(String bank,String payeeName,String payeeAddress,String amount,String amountType,String memo ,String accountType,String accountNumber,String routingNumber)  {
        driver.findElement(createACH).click();
        Utilities.selectFromDropDown(driver,bankDropDown,bank);
        driver.findElement(payeeNameOnACHCheck).sendKeys(payeeName);
        driver.findElement(payeeAddressOnACHCheck).sendKeys(payeeAddress);
        driver.findElement(amountOnACHCheck).sendKeys(amount);
        Utilities.selectFromDropDown(driver,amountDropDownACH,amountType);
        driver.findElement(memoOnACHCheck).sendKeys(memo);
        Utilities.selectFromDropDown(driver,payeeAccountTypeDropDown,accountType);
        driver.findElement(payeeAccountNumber).sendKeys(accountNumber);
        driver.findElement(payeeRoutingNumber).sendKeys(routingNumber);
        //driver.findElement(password).sendKeys(pass);
        Utilities.explicitlyWaitForClickability(driver,onOffTriggerOnaACH);
        driver.findElement(onOffTriggerOnaACH).click();
        driver.findElement(onOffTriggerOnaACH).click();
    }
    public CreatePaymentPage createCheckFormWithoutAdvanced(String payeeName,String payeeAddress,String amount,String memo ,String amountType,String postageOption)
    {
        fillCheckForm(payeeName, payeeAddress, amount, memo , amountType,postageOption);
        driver.findElement(submitPaymentButton).click();
        return this;
    }
    public CreatePaymentPage createCheckFormWithAdvanced(String payeeName,String payeeAddress,String amount,String memo ,String amountType,String postageOption,String sendDay,String dayOnCheck ,String insert ,String checkNum,String tax,String internalRef,String logo)
    {
        fillCheckForm( payeeName, payeeAddress, amount, memo , amountType,postageOption);
        driver.findElement(basicAdvancedButton).click();
        driver.findElement(sendDateOnCheck).click();
        selectDay(sendDay);
        driver.findElement(dateOnCheck).click();
        selectDay(dayOnCheck);
        Utilities.selectFromDropDown(driver,insertOnCheckDropDown,insert);
        driver.findElement(check).sendKeys(checkNum);
        driver.findElement(taxIdOnCheck).sendKeys(tax);
        driver.findElement(internetRefOnCheck).sendKeys(internalRef);
        Utilities.selectFromDropDown(driver,logoElement,logo);
        driver.findElement(onOffTriggerOnCheck).click();
        driver.findElement(onOffTriggerOnCheck).click();
        driver.findElement(submitPaymentButton).click();
        return this;
    }
    public CreatePaymentPage createACHFormWithoutAdvanced(String bank,String payeeName,String payeeAddress,String amount,String amountType,String memo ,String accountType,String accountNumber,String routingNumber )   {
        fillACHForm( bank, payeeName, payeeAddress, amount, amountType, memo , accountType, accountNumber, routingNumber);
        driver.findElement(submitPaymentButtonACH).click();
        return this;
    }
    public CreatePaymentPage createACHFormWithAdvanced(String bank,String payeeName,String payeeAddress,String amount,String amountType,String memo ,String accountType,String accountNumber,String routingNumber,String sendDay,String insert ,String tax,String internalRef)   {
        fillACHForm(  bank, payeeName, payeeAddress, amount, amountType, memo , accountType, accountNumber, routingNumber);
        driver.findElement(ACHBasicAdvancedTrigger).click();
        driver.findElement(sendDateOnACH).click();
        selectDay(sendDay);
        driver.findElement(taxIdOnACH).sendKeys(tax);
        driver.findElement(internetRefOnACH).sendKeys(internalRef);
        Utilities.selectFromDropDown(driver,insertOnACHDropDown,insert);
        driver.findElement(onOffTriggerOnaACH).click();
        driver.findElement(onOffTriggerOnaACH).click();
        driver.findElement(submitPaymentButtonACH).click();
        return this;
    }


}
