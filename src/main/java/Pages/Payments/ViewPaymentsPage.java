package Pages.Payments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewPaymentsPage extends PaymentsSection{
    //Actions elements in the payment table
    //View payment and its elements
    By viewPayment = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[8] //a[@title=\"View Payment\"]");
    By paymentHeaderForVerifyingViewPayment = By.xpath("//h4[contains(text(),'Payment #')]");
    By closeButtonOnViewPayments = By.xpath("//*[@id=\"upfFooter\"]/button");
    By editPaymentButtonOnViewPayments = By.xpath("//*[@id=\"upfFooter\"]/a");

    //Edit payment and its elements
    By editPayment = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[8] //a[@title=\"Edit Payment\"]");
    By closeButtonOnEditPayments = By.xpath("//*[@id=\"editPaymentForm\"]/div[3]/input[1]");
    By editPaymentButtonOnEditPayments = By.xpath("//*[@id=\"editPaymentForm\"]/div[3]/input[2]");
    By paymentHeaderForVerifyingEditPayment = By.xpath("//h4[contains(text(),'To')]");

    //Attach Insert and its elements
    By attachInsert = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[8] //a[@title=\"Attach Insert\"]");
    By insertDropDown = By.cssSelector("#ai_insert");
    By cancelButtonOnInsertAttach = By.xpath("//*[@id=\"attachInsertForm\"]/div[3]/button[1]");
    By attachButtonOnInsertAttach = By.xpath("//*[@id=\"paymentMdBtn\"]");
    By attachFlash = By.xpath("/html/body/div[23]/div");
    By paymentHeaderForVerifyingAttachPayment = By.xpath("//h5[contains(text(),'Attach insert to Payment')]");

    //Cancel payment and its elements
    By cancelPayment = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[8] //a[@title=\"Cancel Payment\"]");
    Alert alert ;


    //Check Image and its elements
    By checkImage = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[8] //a[@title=\"Check Image\"]");
    By cancelButtonOnCheckImage = By.xpath("//*[@id=\"checkImgModal\"]/div/div/div[3]/a[1]");
    By downloadButtonOnCheckImage = By.xpath("//*[@id=\"checkImgDlBtn\"]");
    By viewButtonOnCheckImage = By.xpath("//*[@id=\"checkImgViewBtn\"]");
    By paymentHeaderForVerifyingCheckImage = By.xpath("//h4[contains(text(),'Check Image for Payment')]");

    //Approve payment and its elements
    By approvePayment = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[8] //a[@title=\"Approve Payment\"]");
    By approveFlash = By.xpath("/html/body/div[23]/div");

    //Delete payment and its elements
    By deletePayment = By.xpath("//table[@id='paymentsList'] /tbody /tr[1] /td[8] //a[@title=\"Delete Payment\"]");
    By deleteFlash = By.xpath("/html/body/div[23]/div");
    //Don't forget the alert that will be appeared


    public ViewPaymentsPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnViewPayment()
    {
        driver.findElement(viewPayment).click();
    }
    public void clickOnEditPayment()
    {
        driver.findElement(editPayment).click();
    }
    public void clickOnAttachInsert()
    {
        driver.findElement(attachInsert).click();
    }
    public void clickOnCancelPayment()
    {
        driver.findElement(cancelPayment).click();
    }
    public void clickOnCheckImage()
    {
        driver.findElement(checkImage).click();
    }
    public void clickOnApprovePayment()
    {
        driver.findElement(approvePayment).click();
    }
    public void clickOnDeletePayment()
    {
        driver.findElement(deletePayment).click();
    }
    public boolean verifyThatViewPaymentAppears()
    {
       return driver.findElement(paymentHeaderForVerifyingViewPayment).isDisplayed();
    }
    public boolean verifyThatEditPaymentAppears()
    {
        return driver.findElement(paymentHeaderForVerifyingEditPayment).isDisplayed();
    }
    public boolean verifyThatInsertAttachAppears()
    {
        return driver.findElement(paymentHeaderForVerifyingAttachPayment).isDisplayed();
    }
    public boolean verifyThatCancelPaymentAppears()
    {
        alert = driver.switchTo().alert();
        String flag ="";
        flag = alert.getText();
        if(!flag.equalsIgnoreCase(""))
            return true;
        else
            return false;
    }
    public boolean verifyThatCheckImageAppears()
    {
        return driver.findElement(paymentHeaderForVerifyingCheckImage).isDisplayed();
    }
    public boolean verifyThatApprovePaymentAppears()
    {
        return driver.findElement(approveFlash).isDisplayed();
    }
    public boolean verifyThatDeletePaymentAppears()
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
