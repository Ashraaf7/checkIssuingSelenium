package Home;

import Base.TestBase;
import Pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {

    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithoutAdvanced")
    public void setFilterForPayments()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
       homePage.setFilterForPayments("This Week");
        Assert.assertEquals(homePage.getFilterForPayments(),"This Week");
    }
    @Test
    public void createPayment()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnCreatePayment();
        Assert.assertEquals(driver.getCurrentUrl(),url+"payments?send=1");

    }
    @Test
    public void uploadPayment()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnUploadPayment();
        Assert.assertEquals(driver.getCurrentUrl(),url+"payments?upload=1");

    }
    @Test
    public void payees()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPayees();
        Assert.assertEquals(driver.getCurrentUrl(),url+"payees");

    }
    @Test
    public void viewPayment()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnViewPayments();
        Assert.assertEquals(driver.getCurrentUrl(),url+"payments");
    }
    @Test

    public void payBills()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPayBills();
        Assert.assertEquals(driver.getCurrentUrl(),url+"qbo");

    }
    @Test
    public void paymentFiles()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPaymentFiles();
        Assert.assertEquals(driver.getCurrentUrl(),url+"reports/payment-files");
    }
    @Test
    public void positivePays()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPositivePays();
        Assert.assertEquals(driver.getCurrentUrl(),url+"reports/positive-pay");

    }
    @Test
    public void checkImages()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnCheckImages();
        Assert.assertTrue(homePage.verifyGettingCheckImagesTitle());

    }
    @Test
    public void allSettings()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnAllSettings();
        Assert.assertEquals(driver.getCurrentUrl(),url+"settings");

    }
    @Test
    public void fundingSources()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnFundingSources();
        Assert.assertEquals(driver.getCurrentUrl(),url+"settings#fundingsources");

    }
    @Test
    public void usersSetting()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnUsers();
        Assert.assertEquals(driver.getCurrentUrl(),url+"settings#users");
    }
    @Test
    public void logosSetting()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnLogos();
        Assert.assertEquals(driver.getCurrentUrl(),url+"settings#logos");
    }
    @Test
    public void whiteLabelsSetting()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnWhiteLabels();
        Assert.assertEquals(driver.getCurrentUrl(),url+"whitelabels");
    }

}
