package Pages.Payments;

import Utilities.Utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewPaymentsPage extends PaymentsSection{

    // View Payment Elements
    private By viewPayment = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[8]//a[@title=\"View Payment\"]");
    private By paymentHeaderForVerifyingViewPayment = By.xpath("//h4[contains(text(),'Payment #')]");
    private By closeButtonOnViewPayments = By.xpath("//*[@id=\"upfFooter\"]/button");
    private By editPaymentButtonOnViewPayments = By.xpath("//*[@id=\"upfFooter\"]/a");

    // Edit Payment Elements
    private By editPayment = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[8]//a[@title=\"Edit Payment\"]");
    private By closeButtonOnEditPayments = By.xpath("//*[@id=\"editPaymentForm\"]/div[3]/input[1]");
    private By editPaymentButtonOnEditPayments = By.xpath("//*[@id=\"editPaymentForm\"]/div[3]/input[2]");
    private By paymentHeaderForVerifyingEditPayment = By.xpath("//h4[contains(text(),'To')]");

    // Attach Insert Elements
    private By attachInsert = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[8]//a[@title=\"Attach Insert\"]");
    private By insertDropDown = By.cssSelector("#ai_insert");
    private By cancelButtonOnInsertAttach = By.xpath("//*[@id=\"attachInsertForm\"]/div[3]/button[1]");
    private By attachButtonOnInsertAttach = By.xpath("//*[@id=\"paymentMdBtn\"]");
    private By attachFlash = By.xpath("/html/body/div[23]/div");
    private By paymentHeaderForVerifyingAttachPayment = By.xpath("//h5[contains(text(),'Attach insert to Payment')]");

    // Cancel Payment Elements
    private By cancelPayment = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[8]//a[@title=\"Cancel Payment\"]");
    private Alert alert;

    // Check Image Elements
    private By checkImage = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[8]//a[@title=\"Check Image\"]");
    private By cancelButtonOnCheckImage = By.xpath("//*[@id=\"checkImgModal\"]/div/div/div[3]/a[1]");
    private By downloadButtonOnCheckImage = By.xpath("//*[@id=\"checkImgDlBtn\"]");
    private By viewButtonOnCheckImage = By.xpath("//*[@id=\"checkImgViewBtn\"]");
    private By paymentHeaderForVerifyingCheckImage = By.xpath("//h4[contains(text(),'Check Image for Payment')]");

    // Approve Payment Elements
    private By approvePayment = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[8]//a[@title=\"Approve Payment\"]");
    private By approveFlash = By.xpath("/html/body/div[22]/div");

    // Delete Payment Elements
    private By deletePayment = By.xpath("//table[@id='paymentsList']/tbody/tr[1]/td[8]//a[@title=\"Delete Payment\"]");
    private By deleteFlash = By.xpath("/html/body/div[23]/div");
    public ViewPaymentsPage(WebDriver driver) {
        super(driver);
    }
    public ViewPaymentsPage clickOnViewPayment()
    {
        driver.findElement(viewPayment).click();
        return this;
    }
    public ViewPaymentsPage clickOnEditPayment()
    {
        driver.findElement(editPayment).click();
        return this;
    }
    public ViewPaymentsPage clickOnAttachInsert()
    {
        driver.findElement(attachInsert).click();
        return this;
    }
    public ViewPaymentsPage clickOnCancelPayment()
    {
        driver.findElement(cancelPayment).click();
        return this;
    }
    public ViewPaymentsPage clickOnCheckImage()
    {
        driver.findElement(checkImage).click();
        return this;
    }
    public ViewPaymentsPage clickOnApprovePayment()
    {
        driver.findElement(approvePayment).click();
        return this;
    }
    public ViewPaymentsPage clickOnDeletePayment()
    {
        driver.findElement(deletePayment).click();
        return this;
    }
    public boolean verifyThatViewPaymentAppears()
    {
        Utilities.explicitlyWaitForVisibility(driver,paymentHeaderForVerifyingViewPayment);
        return driver.findElement(paymentHeaderForVerifyingViewPayment).isDisplayed();
    }
    public boolean verifyThatEditPaymentAppears()
    {
        return driver.findElement(paymentHeaderForVerifyingEditPayment).isDisplayed();
    }
    public boolean verifyThatInsertAttachAppears()
    {
        Utilities.explicitlyWaitForVisibility(driver,paymentHeaderForVerifyingAttachPayment);
        return driver.findElement(paymentHeaderForVerifyingAttachPayment).isDisplayed();
    }
    public boolean verifyThatCancelPaymentAppears()
    {
        return !driver.switchTo().alert().getText().equalsIgnoreCase("");
    }
    public boolean verifyThatCheckImageAppears()
    {
        Utilities.explicitlyWaitForVisibility(driver,paymentHeaderForVerifyingCheckImage);
        return driver.findElement(paymentHeaderForVerifyingCheckImage).isDisplayed();
    }
    public boolean verifyThatApprovePaymentAppears()
    {
        return driver.findElement(approveFlash).isDisplayed();
    }
    public boolean verifyThatDeletePaymentAppears()
    {
        return !driver.switchTo().alert().getText().equalsIgnoreCase("");
    }

}
