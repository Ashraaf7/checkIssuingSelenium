package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.PayeesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PayeesTest extends TestBase {

    HomePage homePage ;
    PayeesPage payeesPage;
    SoftAssert softAssert ;
    @Test
    public void verifyCreateNewPayee() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnCreateNewPayee();
        String expectedName = "New Man";
        payeesPage.createNewPayee("Bank 34", expectedName, "ahmed@gmail.com", "Ahmoood", "ahmood@gmail",
                "123", "10", "1", "test", "10", "USPS First Class","Checking");
        Thread.sleep(2000);
        payeesPage.sortIds();
        Thread.sleep(2000);
        String actualName = payeesPage.getPayeeName();
        Assert.assertEquals(actualName,expectedName);
    }
    @Test
    public void verifyPayPayee() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnPayPayee();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatPayPayeeAppears(),true);
    }
    @Test
    public void verifyDisablePayee() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnDisablePayee();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatDisablePayeeAppears(),"Disabled");
    }
    @Test
    public void verifyPayeeDetails() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        String expected = payeesPage.getPayeeName();
        payeesPage.clickOnPayeeDetails();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatPayeeDetailsAppears(),expected);
    }
    @Test
    public void verifyDeletingPayee() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnDeletePayee();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatDeletePayeeAppears(),true);
    }
    @Test
    public void verifyClickingOnCreatePaymentButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnCreatePayment();
        Assert.assertEquals(payeesPage.checkVisibilityOfCreatePaymentForm(),true);
    }

    @Test
    public void verifyClickingOnUploadPaymentButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnUploadPayment();
        Assert.assertEquals(payeesPage.checkVisibilityOfUploadPaymentForm(),true);
    }
    @Test
    public void verifyClickingOnNACHAButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage=homePage.clickOnPayees();
        payeesPage.clickOnNACHA();
        Assert.assertEquals(payeesPage.checkVisibilityOfNACHAForm(),true);
    }
    @Test
    public void verifySelectingNumberOfPages() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage=homePage.clickOnPayees();
        payeesPage.selectNumberOfPages("25");
        boolean condition ;
        if(payeesPage.getPaymentsCount()<=25)
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
        payeesPage=homePage.clickOnPayees();
        payeesPage.selectFilterDate("Cleared","15","15");
        Assert.assertTrue(payeesPage.verifyNoPaymentMessage());
    }
    @Test
    public void verifySelectingFromCustomizationDropDown( ) throws InterruptedException {
        softAssert = new SoftAssert();
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage=homePage.clickOnPayees();
        payeesPage.selectFromCustomizationDropDown("Amount");
        softAssert.assertEquals(payeesPage.checkCustomization(),"Amount");
        softAssert.assertAll();
    }
    @Test
    public void verifySelectingFromExportPageDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage=homePage.clickOnPayees();
        payeesPage.selectFromExportPageDropDown("Export as CSV");
        Thread.sleep(4000);
    }
    @Test
    public void verifySelectingFromWithSelectedDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage=homePage.clickOnPayees();
        payeesPage.selectFromWithSelectedDropDown("Resend Claim Email(s)");
        Assert.assertTrue(payeesPage.verifyClaimFlash());
    }
    @Test
    public void verifySelectingFromSelectDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        payeesPage=homePage.clickOnPayees();
        payeesPage.selectFromSelectDropDown("Select All");
        Thread.sleep(2000);
        Assert.assertTrue(payeesPage.verifyNoMatchingFoundMessage());
    }
}
