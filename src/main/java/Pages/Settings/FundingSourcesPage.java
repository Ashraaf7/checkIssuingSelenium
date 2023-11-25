package Pages.Settings;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FundingSourcesPage extends SuperSettings {

    public FundingSourcesPage(WebDriver driver) {
        super(driver);
    }
    private By addFundingSource = By.cssSelector("a#maaBtn");
    private By plaidCheckbox = By.cssSelector("input#ma_use_plaid");
    private By businessCheckbox = By.cssSelector("input#ma_is_business");
    private By accountName = By.cssSelector("input#ma_name");
    private By bankName = By.cssSelector("input#ma_institution_name");
    private By bankAddress = By.cssSelector("input#ma_institution_addr");
    private By accountType = By.cssSelector("select#ma_acct_type");
    private By accountNumber = By.cssSelector("input#ma_acct_num");
    private By routingNumber = By.cssSelector("input#ma_routing_num");
    private By addAccountButton = By.id("maSubmitBtn");
    //Account Info
    private By nameOnCheck = By.id("md_name_on_checks");
    private By bankNameOnAccountInfo = By.id("md_bank_name");
    private By startingCheckNum = By.id("md_starting_check_num");
    private By fractionalRoutingNum = By.id("md_fractional_routing");
    private By selectLogo = By.id("md_logo");
    private By addressReturnTo = By.id("md_return_mailto");
    private By addressOnChecks = By.id("md_address_on_checks");
    private By returnAddress = By.id("md_return_address");
    private By bankAddressOnAccountInfo = By.id("md_bank_address");
    private By voidText = By.id("md_void_text");
    private By approvalThreshold = By.id("md_approval_threshold");
    private By defaultWhitelabel = By.id("md_default_wl");
    private By nextButtonOnAccountInfo = By.cssSelector("button#acctMdNextBtn");
    private By addOneSignature = By.xpath("//*[@id=\"addNewSigBtn\"]");
    private By printYourNameSignature = By.xpath("//*[@id=\"sigpad_name\"]");
    private By addButtonSignature = By.xpath("//*[@id=\"addSigBtn\"]");
    private By nextButtonOnSignatureIfAdded = By.cssSelector("//*[@id=\"acctSigsPreviewBtn\"]");
    private By nextButtonOnSignatureIfNotAdded = By.xpath("//*[@id=\"acctSigsNextBtn\"]");
    private By closeButtonOnSignatureIfNotAdded = By.xpath("//*[@id=\"acctMdForm\"]/div[3]/button[1]");
    private By headerElement = By.xpath("//*[@id=\"sigDlgHeader\"]");
    private By generateProof = By.cssSelector("button#genProofBtn");
    private By closeButtonOnGenerateProof = By.cssSelector("button#checkPreviewBtn");

    private By accountNameOnTheTable = By.xpath("//*[@id=\"fsList\"]/tbody/tr[1]/td[2]");

    public FundingSourcesPage addingFundingSource( boolean business, boolean plaid,String name,
     String bname,String baddress,String type,String anumber, String rnumber)
    {
        clickOnAddFundingSource();
        if(business)
            clickOnCheckBusinessCheckbox();
        if (plaid){}
        clickOnCheckPlaidCheckbox();
        setAccountName(name);
        setBankName(bname);
        setBankAddress(baddress);
        Utilities.selectFromDropDown(driver,accountType,type);
        setAccountNumber(anumber);
        setRoutingNumber(rnumber);
        clickOnAddAccountButton();
        return this;
    }
    //Methods
    public void clickOnAddFundingSource() {
        driver.findElement(addFundingSource).click();
    }

    public void clickOnCheckPlaidCheckbox() {
        driver.findElement(plaidCheckbox).click();
    }

    public void clickOnCheckBusinessCheckbox() {
        driver.findElement(businessCheckbox).click();
    }

    public void setAccountName(String name) {
        driver.findElement(accountName).clear();
        driver.findElement(accountName).sendKeys(name);
    }

    public void setBankName(String name) {
        driver.findElement(bankName).clear();
        driver.findElement(bankName).sendKeys(name);
    }

    public void setBankAddress(String address) {
        driver.findElement(bankAddress).clear();
        driver.findElement(bankAddress).sendKeys(address);
    }


    public void setAccountNumber(String number) {
        driver.findElement(accountNumber).clear();
        driver.findElement(accountNumber).sendKeys(number);
    }

    public void setRoutingNumber(String number) {
        driver.findElement(routingNumber).clear();
        driver.findElement(routingNumber).sendKeys(number);
    }

    public void clickOnAddAccountButton() {
        driver.findElement(addAccountButton).click();
    }


    /////////////////////////////////////////////////////////////////////////////////
    public void fillAccountInfoForm(String name, String bankName, String startingCheckNum, String fractionalRoutingNum,
                            String logoPath, String addressReturnTo, String addressOnChecks, String returnAddress,
                            String bankAddressOnChecks, String voidText, String threshold, String whitelabel,String sname) throws InterruptedException {
        // Set name on check
        setNameOnCheck(name);
        // Set bank name on account info
        setBankNameOnAccountInfo(bankName);
        // Set starting check number
        setStartingCheckNumber(startingCheckNum);
        // Set fractional routing number
        setFractionalRoutingNumber(fractionalRoutingNum);
        // Select logo
        Utilities.selectFromDropDown(driver,selectLogo,logoPath);
        // Set address return to
        setAddressReturnTo(addressReturnTo);
        // Set address on checks
        setAddressOnChecks(addressOnChecks);
        // Set return address
        setReturnAddress(returnAddress);
        // Set bank address on checks
        setBankAddressOnChecks(bankAddressOnChecks);
        // Set void text
        setVoidText(voidText);
        // Set approval threshold
        Utilities.selectFromDropDown(driver,approvalThreshold,threshold);

        // Set default whitelabel
        Utilities.selectFromDropDown(driver,defaultWhitelabel,whitelabel);
        // Click on next button on account info
        clickOnNextButtonOnAccountInfo();
        //addingSignature(sname);
        // Click on next button on signature
        clickOnNextButtonOnSignatureWithoutSignature();
        // Click on generate proof button
        clickOnGenerateProof();
        Thread.sleep(2000);
        // Click on close button on generate proof
        clickOnCloseOnGenerateProof();
    }

    //Account Info Methods
    public void setNameOnCheck(String name) {
        driver.findElement(nameOnCheck).clear();
        driver.findElement(nameOnCheck).sendKeys(name);
    }

    public void setBankNameOnAccountInfo(String name) {
        driver.findElement(bankNameOnAccountInfo).clear();
        driver.findElement(bankNameOnAccountInfo).sendKeys(name);
    }

    public void setStartingCheckNumber(String number) {
        driver.findElement(startingCheckNum).clear();
        driver.findElement(startingCheckNum).sendKeys(number);
    }

    public void setFractionalRoutingNumber(String number) {
        driver.findElement(fractionalRoutingNum).clear();
        driver.findElement(fractionalRoutingNum).sendKeys(number);
    }

    public void setAddressReturnTo(String address) {
        driver.findElement(addressReturnTo).clear();
        driver.findElement(addressReturnTo).sendKeys(address);
    }

    public void setAddressOnChecks(String address) {
        driver.findElement(addressOnChecks).clear();
        driver.findElement(addressOnChecks).sendKeys(address);
    }

    public void setReturnAddress(String address) {
        driver.findElement(returnAddress).clear();
        driver.findElement(returnAddress).sendKeys(address);
    }

    public void setBankAddressOnChecks(String address) {
        driver.findElement(bankAddressOnAccountInfo).clear();
        driver.findElement(bankAddressOnAccountInfo).sendKeys(address);
    }

    public void setVoidText(String voidText) {
        driver.findElement(this.voidText).clear();
        driver.findElement(this.voidText).sendKeys(voidText);
    }

    public void setApprovalThreshold(String threshold) {
       new Select(driver.findElement(approvalThreshold)).selectByVisibleText(threshold);
    }

    public void setDefaultWhitelabel(String whitelabel) {
        new Select(driver.findElement(defaultWhitelabel)).selectByVisibleText(whitelabel);

    }

    public void clickOnNextButtonOnAccountInfo() {
        driver.findElement(nextButtonOnAccountInfo).click();
    }

    public void addingSignature(String name) throws InterruptedException {
        driver.findElement(addOneSignature).click();
        Thread.sleep(4000);
        driver.findElement(closeButtonOnSignatureIfNotAdded).click();
        driver.findElement(printYourNameSignature).click();
        driver.findElement(printYourNameSignature).sendKeys(name);
        driver.findElement(addButtonSignature).click();
        driver.findElement(nextButtonOnSignatureIfAdded).click();
    }
    public void clickOnNextButtonOnSignatureWithoutSignature() {
        driver.findElement(nextButtonOnSignatureIfNotAdded).click();
    }
    public void clickOnGenerateProof() {
        driver.findElement(generateProof).click();
    }
    public void clickOnCloseOnGenerateProof() {
        driver.findElement(closeButtonOnGenerateProof).click();
    }

    public String checkThatAccountAdded () throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(accountNameOnTheTable).getText();
    }
}
