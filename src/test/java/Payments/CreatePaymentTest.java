package Payments;

import Base.TestBase;
import Pages.Payments.CreatePaymentPage;
import Pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreatePaymentTest extends TestBase {

    HomePage homePage ;
    CreatePaymentPage createPaymentPage;
    SoftAssert softAssert ;
    @Test
    public void verifyCreatingPaymentOnCheckWithoutAdvanced() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createCheckFormWithoutAdvanced("CheckNotAdvancedTest","test@gmail.com","100","Test","USD","USPS First Class - $0.60");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"CheckNotAdvancedTest");
    }
    @Test
    public void verifyCreatingPaymentOnCheckWithAdvanced() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createCheckFormWithAdvanced("CheckAdvancedTest","test@gmail.com","100","Test","USD","USPS First Class - $0.60","2","20","Test PDF insert","","","","Test logo");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"CheckAdvancedTest");
    }

    @Test
    public void verifyCreatingPaymentOnACHWithoutAdvanced() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createACHFormWithoutAdvanced("Bank 34","ACHNotAdvancedTest","test@gmail.com","100","USD","test","Savings","301011214","301011214");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"ACHNotAdvancedTest");
    }
    @Test
    public void verifyCreatingPaymentOnACHWithAdvanced() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createACHFormWithAdvanced("Bank 34","ACHAdvancedTest","test@gmail.com","100","USD","test","Savings","301011214","301011214","10","Test PDF insert","","");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"ACHAdvancedTest");
    }
    @Test
    public void verifyClickingOnCreatePaymentButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.clickOnCreatePayment();
        Assert.assertEquals(createPaymentPage.checkVisibilityOfCreatePaymentForm(),false);
    }
    @Test
    public void verifyClickingOnUploadPaymentButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.clickOnUploadPayment();
        Assert.assertEquals(createPaymentPage.checkVisibilityOfUploadPaymentForm(),true);
    }
    @Test
    public void verifyClickingOnNACHAButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.clickOnNACHA();
        Assert.assertEquals(createPaymentPage.checkVisibilityOfNACHAForm(),true);
    }
    @Test
    public void verifySelectingNumberOfPages() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.selectNumberOfPages("25");
        boolean condition ;
                if(createPaymentPage.getPaymentsCount()<=25)
                    condition= true;
                else
                    condition=false;
        Assert.assertTrue(condition,"Condition for check number of pages");
    }
    @Test
    public void verifyFilteringWithDate() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.selectFilterDate("Cleared","15","15");
        Assert.assertTrue(createPaymentPage.verifyNoPaymentMessage());
    }
    @Test
    public void verifySelectingFromCustomizationDropDown( ) throws InterruptedException {
        softAssert = new SoftAssert();
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.selectFromCustomizationDropDown("Amount");
        softAssert.assertEquals(createPaymentPage.checkCustomization(),"Amount");
        softAssert.assertAll();
    }
    @Test
    public void verifySelectingFromExportPageDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.selectFromExportPageDropDown("Export as CSV");
        Thread.sleep(4000);
        Assert.assertTrue(createPaymentPage.verifyExportPage());
    }
    @Test
    public void verifySelectingFromWithSelectedDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.selectFromWithSelectedDropDown("Resend Claim Email(s)");
        Assert.assertTrue(createPaymentPage.verifyClaimFlash());
    }
    @Test
    public void verifySelectingFromSelectDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.selectFromSelectDropDown("Select All");
        Thread.sleep(2000);
        Assert.assertTrue(createPaymentPage.verifyNoMatchingFoundMessage());
    }
}
