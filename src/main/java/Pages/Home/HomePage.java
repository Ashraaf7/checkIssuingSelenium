package Pages.Home;

import Pages.Payments.CreatePaymentPage;
import Pages.Payments.PayeesPage;
import Pages.Payments.UploadPaymentFilePage;
import Pages.Payments.ViewPaymentsPage;
import Pages.Reports.CheckImagesPage;
import Pages.Reports.PaymentFilesPage;
import Pages.Reports.PositivePayPage;
import Pages.Settings.*;
import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage   {

    // Payment Section
    private By paymentButton = By.xpath("(//ul[@id='sidebarnav']/li)[1]");
    private By createPaymentButton = By.xpath("((//ul[@id='sidebarnav']/li)[1]/ul/li)[1]");
    private By uploadPaymentButton = By.xpath("((//ul[@id='sidebarnav']/li)[1]/ul/li)[2]");
    private By payeesButton = By.xpath("((//ul[@id='sidebarnav']/li)[1]/ul/li)[3]");
    private By viewPaymentButton = By.xpath("((//ul[@id='sidebarnav']/li)[1]/ul/li)[4]");

    // QuickBooks List
    private By quickBooksButton = By.xpath("(//ul[@id='sidebarnav']/li)[2]");
    private By payBillsButton = By.xpath("((//ul[@id='sidebarnav']/li)[2]/ul/li)[1]");

    // Reports List
    private By reportsButton = By.xpath("(//ul[@id='sidebarnav']/li)[3]");
    private By paymentFilesButton = By.xpath("((//ul[@id='sidebarnav']/li)[3]/ul/li)[1]");
    private By positivePayButton = By.xpath("((//ul[@id='sidebarnav']/li)[3]/ul/li)[2]");
    private By checkImagesButton = By.xpath("((//ul[@id='sidebarnav']/li)[3]/ul/li)[3]");
    private By downloadCheckImages = By.cssSelector("form[id='dciForm']>div.modal-header>h4[id='vcenter']");

    // Settings List
    private By settingsButton = By.xpath("(//ul[@id='sidebarnav']/li)[4]");
    private By allSettingsButton = By.xpath("((//ul[@id='sidebarnav']/li)[4]/ul/li)[1]");
    private By fundingSourcesButton = By.xpath("((//ul[@id='sidebarnav']/li)[4]/ul/li)[2]");
    private By usersButton = By.xpath("((//ul[@id='sidebarnav']/li)[4]/ul/li)[3]");
    private By logosButton = By.xpath("((//ul[@id='sidebarnav']/li)[4]/ul/li)[4]");
    private By whiteLabelsButton = By.xpath("((//ul[@id='sidebarnav']/li)[4]/ul/li)[5]");

    // Filter Button
    private By filterButton = By.xpath("//select[@id='dr_shortcuts']");

    // Payment Status Buttons
    private By allPaymentButton = By.cssSelector("div.bg-success");
    private By sentPaymentButton = By.cssSelector("div.bg-warning");
    private By unApprovedPaymentButton = By.cssSelector("div.bg-info");
    private By heldPaymentButton = By.cssSelector("div.bg-danger");

    // Contact Support Button
    private By contactSupportButton = By.linkText("Contact support");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CreatePaymentPage clickOnCreatePayment()
    {
        Utilities.explicitlyWaitForClickability(driver,paymentButton);
        driver.findElement(paymentButton).click();
        Utilities.explicitlyWaitForClickability(driver,createPaymentButton);
        driver.findElement(createPaymentButton).click();
        return new CreatePaymentPage(driver);
    }
    public UploadPaymentFilePage clickOnUploadPayment()
    {
        Utilities.explicitlyWaitForClickability(driver,paymentButton);
        driver.findElement(paymentButton).click();
        Utilities.explicitlyWaitForClickability(driver,uploadPaymentButton);
        driver.findElement(uploadPaymentButton).click();
        return  new UploadPaymentFilePage(driver);
    }
    public PayeesPage clickOnPayees()
    {
        Utilities.explicitlyWaitForClickability(driver,paymentButton);
        driver.findElement(paymentButton).click();
        Utilities.explicitlyWaitForClickability(driver,payeesButton);
        driver.findElement(payeesButton).click();
        return new PayeesPage(driver);
    }
    public ViewPaymentsPage clickOnViewPayments()
    {
        Utilities.explicitlyWaitForClickability(driver,paymentButton);
        driver.findElement(paymentButton).click();
        Utilities.explicitlyWaitForClickability(driver,viewPaymentButton);
        driver.findElement(viewPaymentButton).click();
        return new ViewPaymentsPage(driver);
    }

    public HomePage clickOnPayBills()
    {
        Utilities.explicitlyWaitForClickability(driver,quickBooksButton);
        driver.findElement(quickBooksButton).click();
        Utilities.explicitlyWaitForClickability(driver,payBillsButton);
        driver.findElement(payBillsButton).click();
        return this;
    }
    public PaymentFilesPage clickOnPaymentFiles()
    {
        Utilities.explicitlyWaitForClickability(driver,reportsButton);
        driver.findElement(reportsButton).click();
        Utilities.explicitlyWaitForClickability(driver,paymentFilesButton);
        driver.findElement(paymentFilesButton).click();
        return new PaymentFilesPage(driver);
    }
    public PositivePayPage clickOnPositivePays()
    {
        Utilities.explicitlyWaitForClickability(driver,reportsButton);
        driver.findElement(reportsButton).click();
        Utilities.explicitlyWaitForClickability(driver,positivePayButton);
        driver.findElement(positivePayButton).click();
        return new PositivePayPage(driver);
    }
    public CheckImagesPage clickOnCheckImages()
    {
        Utilities.explicitlyWaitForClickability(driver,reportsButton);
        driver.findElement(reportsButton).click();
        Utilities.explicitlyWaitForClickability(driver,checkImagesButton);
        driver.findElement(checkImagesButton).click();
        return new CheckImagesPage(driver);
    }
    public boolean verifyGettingCheckImagesTitle()
    {

        Utilities.explicitlyWaitForVisibility(driver,downloadCheckImages);
       return driver.findElement(downloadCheckImages).isDisplayed();
    }
    public AllSettingsPage clickOnAllSettings()
    {
        Utilities.explicitlyWaitForClickability(driver,settingsButton);
        driver.findElement(settingsButton).click();
        Utilities.explicitlyWaitForClickability(driver,allSettingsButton);
        driver.findElement(allSettingsButton).click();
        return new AllSettingsPage(driver);
    }
    public FundingSourcesPage clickOnFundingSources()
    {
        Utilities.explicitlyWaitForClickability(driver,settingsButton);
        driver.findElement(settingsButton).click();
        Utilities.explicitlyWaitForClickability(driver,fundingSourcesButton);
        driver.findElement(fundingSourcesButton).click();
        return new FundingSourcesPage(driver);
    }
    public UsersPage clickOnUsers()
    {
        Utilities.explicitlyWaitForClickability(driver,settingsButton);
        driver.findElement(settingsButton).click();
        Utilities.explicitlyWaitForClickability(driver,usersButton);
        driver.findElement(usersButton).click();
        return new UsersPage(driver);
    }
    public LogosPage clickOnLogos()
    {
        Utilities.explicitlyWaitForClickability(driver,settingsButton);
        driver.findElement(settingsButton).click();
        Utilities.explicitlyWaitForClickability(driver,logosButton);
        driver.findElement(logosButton).click();
        return new LogosPage(driver);
    }
    public WhitelabelPage clickOnWhiteLabels()
    {
        Utilities.explicitlyWaitForClickability(driver,settingsButton);
        driver.findElement(settingsButton).click();
        Utilities.explicitlyWaitForClickability(driver,whiteLabelsButton);
        driver.findElement(whiteLabelsButton).click();
        return new WhitelabelPage(driver);
    }

    public HomePage setFilterForPayments(String filterOption)
    {
        Utilities.explicitlyWaitForClickability(driver,filterButton);
        Utilities.selectFromDropDown(driver,filterButton,filterOption);
        return this;
    }
    public String getFilterForPayments()
    {
        Utilities.explicitlyWaitForVisibility(driver,filterButton);
        return Utilities.getSelectedOptionFromDropDown(driver,filterButton).getText();
    }
    public  HomePage clickOnAllPayment()
    {
        Utilities.explicitlyWaitForClickability(driver,allPaymentButton);
        driver.findElement(allPaymentButton).click();
        return this;
    }
    public HomePage clickOnSentPayment()
    {
        Utilities.explicitlyWaitForClickability(driver,sentPaymentButton);
        driver.findElement(sentPaymentButton).click();
        return this;
    }
    public HomePage clickOnUnApprovedPayment()
    {
        Utilities.explicitlyWaitForClickability(driver,unApprovedPaymentButton);
        driver.findElement(unApprovedPaymentButton).click();
        return this;
    }
    public HomePage clickOnHeldPayment()
    {
        Utilities.explicitlyWaitForClickability(driver,heldPaymentButton);
        driver.findElement(heldPaymentButton).click();
        return this;
    }
    public HomePage clickOnContactSupportButton()
    {
        Utilities.explicitlyWaitForClickability(driver,contactSupportButton);
        driver.findElement(contactSupportButton).click();
        return this;
    }

}
