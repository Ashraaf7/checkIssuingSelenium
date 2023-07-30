package Pages.Payments;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreatePaymentPage extends PaymentsSection {
    public CreatePaymentPage(WebDriver driver) {
        super(driver);
    }
    //Create On Check Elements
    By createCheck = By.xpath("(//a[@data-toggle='tab'])[1]");
    By payeeNameOnCreateCheck = By.xpath("(//input[@placeholder='Payee Name'])[2]");

    By payeeAddressOnCreateCheck = By.xpath("(//input[@id='addr'])");
    By amountOnCreateCheck = By.cssSelector("input#spamt");
    By amountTypeDropDown = By.cssSelector("select#sp_currency");
    By memoOnCreateCheck = By.cssSelector("input#sp_memo");

    By postage = By.cssSelector("select#sp_postage");
    By onOffTriggerOnCheck = By.cssSelector("#sp_save_payee_wrap > label > div > div > span.bootstrap-switch-label");
    By submitPaymentButton = By.cssSelector("input#paymentSubmitBtn");
    By basicAdvancedButton = By.cssSelector("a#sp-advanced-link");

    //Advanced  On Check Elements
    By sendDateOnCheck = By.cssSelector("input#sp_senddate_fld");
    By date;
    By dateOnCheck = By.cssSelector("input#sp_checkdate_fld");

    By insertOnCheckDropDown = By.cssSelector("select#sp_insert");
    By check = By.cssSelector("input#sp_checknum");
    By taxIdOnCheck = By.cssSelector("input#sp_taxid");
    By internetRefOnCheck = By.cssSelector("#sp-advanced-opts > div:nth-child(8) > div > input");
    By logoElement = By.cssSelector("select#sp_logo");


    //Create an ACH Elements
    By createACH = By.xpath("(//a[@data-toggle='tab'])[2]");

    By bankDropDown = By.cssSelector("select#ach_sp_acct");
    By payeeNameOnACHCheck = By.xpath("(//input[@placeholder='Payee Name'])[3]");

    By payeeAddressOnACHCheck = By.cssSelector("input#ach_addr");
    By amountOnACHCheck = By.cssSelector("input#ach_spamt");

    By memoOnACHCheck = By.xpath("//*[@id=\"ach_sp_memo\"]");
    By amountDropDownACH = By.cssSelector("select#ach_sp_currency");
    By payeeAccountTypeDropDown = By.cssSelector("select#ach_sp_acct_type");
    By payeeAccountNumber= By.cssSelector("input#ach_sp_acct_num");

    By payeeRoutingNumber= By.cssSelector("#ach_sp_routing_num");
    By password= By.cssSelector("input#ach_sp_pass");
    By ACHBasicAdvancedTrigger = By.xpath("/html/body/div[2]/div/div/div[4]/div/div[2]/div[2]/form/ul/li[1]/div[7]/div/a");
    By submitPaymentButtonACH = By.cssSelector("input#achPaymentSubmitBtn");

    //Advanced On ACH Elements
    By sendDateOnACH = By.cssSelector("#ach_sp_senddate_fld");

    By insertOnACHDropDown = By.cssSelector("#ach_sp_insert");
    By taxIdOnACH = By.cssSelector("#ach_sp_taxid");
    By internetRefOnACH = By.cssSelector("#ach_sp_reference");
    By onOffTriggerOnaACH = By.cssSelector("#ach_sp_save_payee_wrap > label > div > div > span.bootstrap-switch-label");


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
         WebElement amountTypeDropDownElement = driver.findElement(amountTypeDropDown);
         helperSelect = new Select(amountTypeDropDownElement);
         helperSelect.selectByVisibleText(amountType);
         driver.findElement(memoOnCreateCheck).sendKeys(memo);
         WebElement postageDropDownElement = driver.findElement(postage);
         helperSelect = new Select(postageDropDownElement);
         helperSelect.selectByVisibleText(postageOption);
         driver.findElement(onOffTriggerOnCheck).click();
         driver.findElement(onOffTriggerOnCheck).click();
     }
    public void fillACHForm(String bank,String payeeName,String payeeAddress,String amount,String amountType,String memo ,String accountType,String accountNumber,String routingNumber)  {
        driver.findElement(createACH).click();
        WebElement bankDropDownElement = driver.findElement(bankDropDown);
        helperSelect = new Select(bankDropDownElement);
        helperSelect.selectByVisibleText(bank);
        driver.findElement(payeeNameOnACHCheck).sendKeys(payeeName);
        driver.findElement(payeeAddressOnACHCheck).sendKeys(payeeAddress);
        driver.findElement(amountOnACHCheck).sendKeys(amount);
        WebElement amountTypeDropDownElement = driver.findElement(amountDropDownACH);
        helperSelect = new Select(amountTypeDropDownElement);
        helperSelect.selectByVisibleText(amountType);
        driver.findElement(memoOnACHCheck).sendKeys(memo);
        WebElement AccountTypeDropDownElement = driver.findElement(payeeAccountTypeDropDown);
        helperSelect = new Select(AccountTypeDropDownElement);
        helperSelect.selectByVisibleText(accountType);
        driver.findElement(payeeAccountNumber).sendKeys(accountNumber);
        driver.findElement(payeeRoutingNumber).sendKeys(routingNumber);
        //driver.findElement(password).sendKeys(pass);
        PageBase.explicitWait(5,onOffTriggerOnaACH);
        driver.findElement(onOffTriggerOnaACH).click();
        driver.findElement(onOffTriggerOnaACH).click();
    }
    public void createCheckFormWithoutAdvanced(String payeeName,String payeeAddress,String amount,String memo ,String amountType,String postageOption)
    {
        fillCheckForm(payeeName, payeeAddress, amount, memo , amountType,postageOption);
        driver.findElement(submitPaymentButton).click();
    }
    public void createCheckFormWithAdvanced(String payeeName,String payeeAddress,String amount,String memo ,String amountType,String postageOption,String sendDay,String dayOnCheck ,String insert ,String checkNum,String tax,String internalRef,String logo)
    {
        fillCheckForm( payeeName, payeeAddress, amount, memo , amountType,postageOption);
        driver.findElement(basicAdvancedButton).click();
        driver.findElement(sendDateOnCheck).click();
        selectDay(sendDay);
        driver.findElement(dateOnCheck).click();
        selectDay(dayOnCheck);
        WebElement insertDropDown = driver.findElement(insertOnCheckDropDown);
        helperSelect = new Select(insertDropDown);
        helperSelect.selectByVisibleText(insert);
        driver.findElement(check).sendKeys(checkNum);
        driver.findElement(taxIdOnCheck).sendKeys(tax);
        driver.findElement(internetRefOnCheck).sendKeys(internalRef);
        WebElement logoDropDown = driver.findElement(logoElement);
        helperSelect = new Select(logoDropDown);
        helperSelect.selectByVisibleText(logo);
        driver.findElement(onOffTriggerOnCheck).click();
        driver.findElement(onOffTriggerOnCheck).click();
        driver.findElement(submitPaymentButton).click();

    }
    public void createACHFormWithoutAdvanced(String bank,String payeeName,String payeeAddress,String amount,String amountType,String memo ,String accountType,String accountNumber,String routingNumber )   {
        fillACHForm( bank, payeeName, payeeAddress, amount, amountType, memo , accountType, accountNumber, routingNumber);
        driver.findElement(submitPaymentButtonACH).click();
    }
    public void createACHFormWithAdvanced(String bank,String payeeName,String payeeAddress,String amount,String amountType,String memo ,String accountType,String accountNumber,String routingNumber,String sendDay,String insert ,String tax,String internalRef)   {
        fillACHForm(  bank, payeeName, payeeAddress, amount, amountType, memo , accountType, accountNumber, routingNumber);
        driver.findElement(ACHBasicAdvancedTrigger).click();
        driver.findElement(sendDateOnACH).click();
        selectDay(sendDay);
        driver.findElement(taxIdOnACH).sendKeys(tax);
        driver.findElement(internetRefOnACH).sendKeys(internalRef);
        WebElement insertDropDown = driver.findElement(insertOnACHDropDown);
        helperSelect = new Select(insertDropDown);
        helperSelect.selectByVisibleText(insert);
        driver.findElement(onOffTriggerOnaACH).click();
        driver.findElement(onOffTriggerOnaACH).click();
        driver.findElement(submitPaymentButtonACH).click();

    }


}
