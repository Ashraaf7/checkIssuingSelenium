package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.ViewPaymentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewPaymentsTest extends TestBase {

    HomePage homePage ;
    ViewPaymentsPage viewPaymentsPage;
    SoftAssert softAssert ;

    @Test
    public void verifyViewingPayment() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnViewPayment();
        Thread.sleep(2000);
        Assert.assertEquals(viewPaymentsPage.verifyThatViewPaymentAppears(),true);
    }
    @Test
    public void verifyEditingPayment() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnEditPayment();
        Assert.assertEquals(viewPaymentsPage.verifyThatEditPaymentAppears(),true);
    }
    @Test
    public void verifyInsertingAttach() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnAttachInsert();
        Thread.sleep(2000);
        Assert.assertEquals(viewPaymentsPage.verifyThatInsertAttachAppears(),true);
    }
    @Test
    public void verifyCancelingPayment() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnCancelPayment();
        Assert.assertEquals(viewPaymentsPage.verifyThatCancelPaymentAppears(),true);
    }
    @Test
    public void verifyCheckingImage() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnCheckImage();
        Thread.sleep(2000);
        Assert.assertEquals(viewPaymentsPage.verifyThatCheckImageAppears(),true);
    }
    @Test
    public void verifyApprovePayment() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnApprovePayment();
        Assert.assertEquals(viewPaymentsPage.verifyThatApprovePaymentAppears(),true);
    }
    @Test
    public void verifyDeletingPayment() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnDeletePayment();
        Assert.assertEquals(viewPaymentsPage.verifyThatDeletePaymentAppears(),true);
    }
    @Test
    public void verifyClickingOnCreatePaymentButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnCreatePayment();
        Assert.assertEquals(viewPaymentsPage.checkVisibilityOfCreatePaymentForm(),true);
    }

    @Test
    public void verifyClickingOnUploadPaymentButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnUploadPayment();
        Assert.assertEquals(viewPaymentsPage.checkVisibilityOfUploadPaymentForm(),true);
    }
    @Test
    public void verifyClickingOnNACHAButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage=homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnNACHA();
        Assert.assertEquals(viewPaymentsPage.checkVisibilityOfNACHAForm(),true);
    }
    @Test
    public void verifySelectingNumberOfPages() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage=homePage.clickOnViewPayments();
        viewPaymentsPage.selectNumberOfPages("25");
        boolean condition ;
        if(viewPaymentsPage.getPaymentsCount()<=25)
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
        viewPaymentsPage=homePage.clickOnViewPayments();
        viewPaymentsPage.selectFilterDate("Cleared","15","15");
        Assert.assertTrue(viewPaymentsPage.verifyNoPaymentMessage());
    }
    @Test
    public void verifySelectingFromCustomizationDropDown( ) throws InterruptedException {
        softAssert = new SoftAssert();
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage=homePage.clickOnViewPayments();
        viewPaymentsPage.selectFromCustomizationDropDown("Amount");
        softAssert.assertEquals(viewPaymentsPage.checkCustomization(),"Amount");
        softAssert.assertAll();
    }
    @Test
    public void verifySelectingFromExportPageDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage=homePage.clickOnViewPayments();
        viewPaymentsPage.selectFromExportPageDropDown("Export as CSV");
        Thread.sleep(4000);
    }
    @Test
    public void verifySelectingFromWithSelectedDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage=homePage.clickOnViewPayments();
        viewPaymentsPage.selectFromWithSelectedDropDown("Resend Claim Email(s)");
        Assert.assertTrue(viewPaymentsPage.verifyClaimFlash());
    }
    @Test
    public void verifySelectingFromSelectDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage=homePage.clickOnViewPayments();
        viewPaymentsPage.selectFromSelectDropDown("Select All");
        Thread.sleep(2000);
        Assert.assertTrue(viewPaymentsPage.verifyNoMatchingFoundMessage());
    }
}
