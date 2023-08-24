package Home;

import Base.TestBase;
import Pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {

    @Test
    public void setFilterForPayments()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
       homePage.setFilterForPayments("This Week");

        Assert.assertEquals("This Week",homePage.getFilterForPayments());
    }
    @Test
    public void createPayment()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnCreatePayment();
        Assert.assertEquals("https://web.checkissuing.com/payments?send=1",driver.getCurrentUrl());

    }
    @Test
    public void uploadPayment()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnUploadPayment();
        Assert.assertEquals("https://web.checkissuing.com/payments?upload=1",driver.getCurrentUrl());

    }
    @Test
    public void payees()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPayees();
        Assert.assertEquals("https://web.checkissuing.com/payees",driver.getCurrentUrl());

    }
    @Test
    public void viewPayment()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPayees();
        Assert.assertEquals("https://web.checkissuing.com/payments",driver.getCurrentUrl());

    }
    @Test

    public void payBills()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPayBills();
        Assert.assertEquals("https://web.checkissuing.com/qbo",driver.getCurrentUrl());

    }
    @Test
    public void paymentFiles()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPaymentFiles();
        Assert.assertEquals("https://web.checkissuing.com/reports/payment-files",driver.getCurrentUrl());

    }
    @Test
    public void positivePays()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnPositivePays();
        Assert.assertEquals("https://web.checkissuing.com/reports/positive-pay",driver.getCurrentUrl());

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
        Assert.assertEquals("https://web.checkissuing.com/settings",driver.getCurrentUrl());

    }
    @Test
    public void fundingSources()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnFundingSources();
        Assert.assertEquals("https://web.checkissuing.com/settings#fundingsources",driver.getCurrentUrl());

    }
    @Test
    public void usersSetting()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnUsers();
        Assert.assertEquals("https://web.checkissuing.com/settings#users",driver.getCurrentUrl());
    }
    @Test
    public void logosSetting()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnLogos();
        Assert.assertEquals("https://web.checkissuing.com/settings#logos",driver.getCurrentUrl());
    }
    @Test
    public void whiteLabelsSetting()
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        homePage.clickOnWhiteLabels();
        Assert.assertEquals("https://web.checkissuing.com/whitelabels",driver.getCurrentUrl());
    }

}
