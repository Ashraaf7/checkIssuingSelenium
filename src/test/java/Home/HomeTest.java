package Home;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {

    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithoutAdvanced")
    public void setFilterForPayments()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .setFilterForPayments("This Week");
        Assert.assertEquals(new HomePage(driver).getFilterForPayments(),"This Week");
    }
    @Test
    public void createPayment()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment();
        Assert.assertEquals(driver.getCurrentUrl(),url+"payments?send=1");
    }
    @Test
    public void uploadPayment()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnUploadPayment();
        Assert.assertEquals(driver.getCurrentUrl(),url+"payments?upload=1");
    }
    @Test
    public void payees()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnPayees();
        Assert.assertEquals(driver.getCurrentUrl(),url+"payees");

    }
    @Test
    public void viewPayment()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnViewPayments();
        Assert.assertEquals(driver.getCurrentUrl(),url+"payments");
    }
    @Test

    public void payBills()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnPayBills();
        Assert.assertEquals(driver.getCurrentUrl(),url+"qbo");

    }
    @Test
    public void paymentFiles()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnPaymentFiles();
        Assert.assertEquals(driver.getCurrentUrl(),url+"reports/payment-files");
    }
    @Test
    public void positivePays()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnPositivePays();
        Assert.assertEquals(driver.getCurrentUrl(),url+"reports/positive-pay");

    }
    @Test
    public void checkImages()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnCheckImages();
        Assert.assertTrue(new HomePage(driver).verifyGettingCheckImagesTitle());
    }
    @Test
    public void allSettings()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnAllSettings();
        Assert.assertEquals(driver.getCurrentUrl(),url+"settings");

    }
    @Test
    public void fundingSources()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnFundingSources();
        Assert.assertEquals(driver.getCurrentUrl(),url+"settings#fundingsources");
    }
    @Test
    public void usersSetting()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnUsers();
        Assert.assertEquals(driver.getCurrentUrl(),url+"settings#users");
    }
    @Test
    public void logosSetting()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnLogos();
        Assert.assertEquals(driver.getCurrentUrl(),url+"settings#logos");
    }
    @Test
    public void whiteLabelsSetting()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
        .clickOnWhiteLabels();
        Assert.assertEquals(driver.getCurrentUrl(),url+"whitelabels");
    }

}
