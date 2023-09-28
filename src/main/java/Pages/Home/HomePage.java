package Pages.Home;

import Base.PageBase;
import Pages.Payments.CreatePaymentPage;
import Pages.Payments.PayeesPage;
import Pages.Payments.UploadPaymentFilePage;
import Pages.Payments.ViewPaymentsPage;
import Pages.Reports.CheckImagesPage;
import Pages.Reports.PaymentFilesPage;
import Pages.Reports.PositivePayPage;
import Pages.Settings.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    //Payment List
    By paymentButton =By.xpath("(//ul[@id='sidebarnav'] /li)[1]") ;
    By createPaymentButton =By.xpath("((//ul[@id='sidebarnav']  /li)[1] /ul / li )[1]") ;
    By uploadPaymentButton =By.xpath("((//ul[@id='sidebarnav']  /li)[1] /ul / li )[2]") ;
    By payeesButton =By.xpath("((//ul[@id='sidebarnav']  /li)[1] /ul / li )[3]") ;
    By viewPaymentButton =By.xpath("((//ul[@id='sidebarnav']  /li)[1] /ul / li )[4]") ;

    //QuickBooks List
    By quickBooksButton =By.xpath("(//ul[@id='sidebarnav'] /li)[2]") ;
    By payBillsButton =By.xpath("((//ul[@id='sidebarnav']  /li)[2] /ul / li )[1]") ;

    //Reports List
    By reportsButton =By.xpath("(//ul[@id='sidebarnav'] /li)[3]") ;
    By paymentFilesButton =By.xpath("((//ul[@id='sidebarnav']  /li)[3] /ul / li )[1]") ;
    By positivePayButton =By.xpath("((//ul[@id='sidebarnav']  /li)[3] /ul / li )[2]") ;
    By checkImagesButton =By.xpath("((//ul[@id='sidebarnav']  /li)[3] /ul / li )[3]") ;
    By downloadCheckImages = By.cssSelector("form[id='dciForm'] >div.modal-header > h4[id='vcenter']");

    //Settings List
    By settingsButton =By.xpath("(//ul[@id='sidebarnav'] /li)[4]") ;
    By allSettingsButton =By.xpath("((//ul[@id='sidebarnav']  /li)[4] /ul / li )[1]") ;
    By fundingSourcesButton =By.xpath("((//ul[@id='sidebarnav']  /li)[4] /ul / li )[2]") ;
    By usersButton =By.xpath("((//ul[@id='sidebarnav']  /li)[4] /ul / li )[3]") ;
    By logosButton =By.xpath("((//ul[@id='sidebarnav']  /li)[4] /ul / li )[4]") ;
    By whiteLabelsButton =By.xpath("((//ul[@id='sidebarnav']  /li)[4] /ul / li )[5]") ;

    //Filter Button
    By filterButton = By.xpath("//select[@id='dr_shortcuts']") ;

    By allPaymentButton = By.cssSelector("div.bg-success");
    By sentPaymentButton = By.cssSelector("div.bg-warning");
    By unApprovedPaymentButton = By.cssSelector("div.bg-info");
    By heldPaymentButton = By.cssSelector("div.bg-danger");

    By contactSupportButton = By.linkText("Contact support");

    Select helperSelect ;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CreatePaymentPage clickOnCreatePayment()
    {
        PageBase.explicitWait(10,paymentButton);
        driver.findElement(paymentButton).click();
        PageBase.explicitWait(10,createPaymentButton);
        driver.findElement(createPaymentButton).click();
        return new CreatePaymentPage(driver);
    }
    public UploadPaymentFilePage clickOnUploadPayment()
    {
        PageBase.explicitWait(10,paymentButton);
        driver.findElement(paymentButton).click();
        PageBase.explicitWait(10,uploadPaymentButton);
        driver.findElement(uploadPaymentButton).click();
        return  new UploadPaymentFilePage(driver);
    }
    public PayeesPage clickOnPayees()
    {
        PageBase.explicitWait(10,paymentButton);
        driver.findElement(paymentButton).click();
        PageBase.explicitWait(10,payeesButton);
        driver.findElement(payeesButton).click();
        return new PayeesPage(driver);
    }
    public ViewPaymentsPage clickOnViewPayments()
    {
        PageBase.explicitWait(10,paymentButton);
        driver.findElement(paymentButton).click();
        PageBase.explicitWait(10,viewPaymentButton);
        driver.findElement(viewPaymentButton).click();
        return new ViewPaymentsPage(driver);
    }

    public void clickOnPayBills()
    {
        PageBase.explicitWait(10,quickBooksButton);
        driver.findElement(quickBooksButton).click();
        PageBase.explicitWait(10,payBillsButton);
        driver.findElement(payBillsButton).click();
    }
    public PaymentFilesPage clickOnPaymentFiles()
    {
        PageBase.explicitWait(10,reportsButton);
        driver.findElement(reportsButton).click();
        PageBase.explicitWait(10,paymentFilesButton);
        driver.findElement(paymentFilesButton).click();
        return new PaymentFilesPage(driver);
    }
    public PositivePayPage clickOnPositivePays()
    {
        PageBase.explicitWait(10,reportsButton);
        driver.findElement(reportsButton).click();
        PageBase.explicitWait(10,positivePayButton);
        driver.findElement(positivePayButton).click();
        return new PositivePayPage(driver);
    }
    public CheckImagesPage clickOnCheckImages()
    {
        PageBase.explicitWait(10,reportsButton);
        driver.findElement(reportsButton).click();
        PageBase.explicitWait(10,checkImagesButton);
        driver.findElement(checkImagesButton).click();
        return new CheckImagesPage(driver);
    }
    public boolean verifyGettingCheckImagesTitle()
    {

        PageBase.explicitWait(10,downloadCheckImages);
       return driver.findElement(downloadCheckImages).isDisplayed();
    }
    public AllSettingsPage clickOnAllSettings()
    {
        PageBase.explicitWait(10,settingsButton);
        driver.findElement(settingsButton).click();
        PageBase.explicitWait(10,allSettingsButton);
        driver.findElement(allSettingsButton).click();
        return new AllSettingsPage(driver);
    }
    public FundingSourcesPage clickOnFundingSources()
    {
        PageBase.explicitWait(10,settingsButton);
        driver.findElement(settingsButton).click();
        PageBase.explicitWait(10,fundingSourcesButton);
        driver.findElement(fundingSourcesButton).click();
        return new FundingSourcesPage(driver);
    }
    public UsersPage clickOnUsers()
    {
        PageBase.explicitWait(10,settingsButton);
        driver.findElement(settingsButton).click();
        PageBase.explicitWait(10,usersButton);
        driver.findElement(usersButton).click();
        return new UsersPage(driver);
    }
    public LogosPage clickOnLogos()
    {
        PageBase.explicitWait(10,settingsButton);
        driver.findElement(settingsButton).click();
        PageBase.explicitWait(10,logosButton);
        driver.findElement(logosButton).click();
        return new LogosPage(driver);
    }
    public WhitelabelPage clickOnWhiteLabels()
    {
        PageBase.explicitWait(10,settingsButton);
        driver.findElement(settingsButton).click();
        PageBase.explicitWait(10,whiteLabelsButton);
        driver.findElement(whiteLabelsButton).click();
        return new WhitelabelPage(driver);
    }

    public void setFilterForPayments(String filterOption)
    {
        PageBase.explicitWait(10,filterButton);
        WebElement filterElement= driver.findElement(filterButton);
        helperSelect = new Select(filterElement);
        helperSelect.selectByVisibleText(filterOption);
    }
    public String getFilterForPayments()
    {
        PageBase.explicitWait(10,filterButton);
        WebElement filterElement= driver.findElement(filterButton);
        helperSelect = new Select(filterElement);
        WebElement selectedElement = helperSelect.getFirstSelectedOption();
        return selectedElement.getText();
    }
    public void clickOnAllPayment()
    {
        PageBase.explicitWait(10,allPaymentButton);
        driver.findElement(allPaymentButton).click();
    }
    public void clickOnSentPayment()
    {
        PageBase.explicitWait(10, sentPaymentButton);
        driver.findElement(sentPaymentButton).click();
    }
    public void clickOnUnApprovedPayment()
    {
        PageBase.explicitWait(10,unApprovedPaymentButton);
        driver.findElement(unApprovedPaymentButton).click();
    }
    public void clickOnHeldPayment()
    {
        PageBase.explicitWait(10,heldPaymentButton);
        driver.findElement(heldPaymentButton).click();
    }
    public void clickOnContactSupportButton()
    {
        PageBase.explicitWait(10,contactSupportButton);
        driver.findElement(contactSupportButton).click();
    }

}
