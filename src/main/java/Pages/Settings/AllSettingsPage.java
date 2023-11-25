package Pages.Settings;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllSettingsPage extends SuperSettings {


    public AllSettingsPage(WebDriver driver) {
        super(driver);
    }
    // Locators for elements on the settings page
    private By companyName = By.cssSelector("input#edit_company_name");
    private By CompanyDBA = By.cssSelector("input#edit_company_dba");
    private By companyUrlInput = By.cssSelector("input#edit_company_url");
    private By PhysicalAddress = By.cssSelector("input#cm_physical_address");
    private By mailingAddress = By.cssSelector("input#cm_mailing_address");
    private By taxIdInput = By.cssSelector("input#cm_taxid");
    private By phoneInput = By.cssSelector("input#cm_phone");
    private By primaryContactSelect = By.cssSelector("select#cm_primary_contact");
    private By payableContactSelect = By.cssSelector("select#cm_ap_contact");
    private By invoiceEmailInput = By.cssSelector("input#cm_invoice_email");
    private By saveChangesButton = By.xpath("//input[@value='Save Changes']");
    private By assertionMessage = By.xpath("/html/body/div[21]/div");

    //Methods
    public void clickOnCompanyInfo(String name) {
        driver.findElement(companyName).sendKeys(name);
    }
    public void completeCompanyProfile(String url, String physicalAddress, String mailingAddress, String taxId, String phone,
                                       String primaryContact, String apContact, String invoiceEmail) {
        setCompanyUrl(url);
        setPhysicalAddress(physicalAddress);
        setMailingAddress(mailingAddress);
        setTaxId(taxId);
        setPhone(phone);
        selectPrimaryContact(primaryContact);
        selectAPContact(apContact);
        setInvoiceEmail(invoiceEmail);
        clickOnSaveChanges();
    }

    public void CompanyDBA(String dba) {
        driver.findElement(CompanyDBA).sendKeys(dba);
    }

    public void setCompanyUrl(String url) {
        WebElement companyUrl = driver.findElement(companyUrlInput);
        companyUrl.clear();
        companyUrl.sendKeys(url);
    }


    public void setPhysicalAddress(String address) {
        driver.findElement(PhysicalAddress).clear();
        driver.findElement(PhysicalAddress).sendKeys(address);
    }


    public void setMailingAddress(String address) {
        driver.findElement(mailingAddress).clear();
        driver.findElement(mailingAddress).sendKeys(address);
    }


    public void setTaxId(String taxId) {
        driver.findElement(taxIdInput).clear();
        driver.findElement(taxIdInput).sendKeys(taxId);
    }

    public void setPhone(String phone) {
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void selectPrimaryContact(String contact) {
        Utilities.selectFromDropDown(driver,primaryContactSelect,contact);
    }

    public void selectAPContact(String contact) {
        Utilities.selectFromDropDown(driver,payableContactSelect,contact);
    }

    public void setInvoiceEmail(String email) {
        driver.findElement(invoiceEmailInput).clear();
        driver.findElement(invoiceEmailInput).sendKeys(email);
    }

    public void clickOnSaveChanges() {
        driver.findElement(saveChangesButton).click();
    }
    public boolean assertionForSaving()
    {
        return driver.findElement(assertionMessage).isDisplayed();
    }
}
