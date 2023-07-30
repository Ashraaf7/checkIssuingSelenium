package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.UploadPaymentFilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class UploadPaymentFileTest extends TestBase {

    HomePage homePage ;
    UploadPaymentFilePage uploadPaymentFilePage;
    SoftAssert softAssert ;

    @Test
    public void verifyClickingOnCreatePaymentButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage =homePage.clickOnUploadPayment();
        uploadPaymentFilePage.clickOnCreatePayment();
        Assert.assertEquals(uploadPaymentFilePage.checkVisibilityOfCreatePaymentForm(),true);
    }
    @Test
    public void verifyUploadingPaymentFile() throws InterruptedException, AWTException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.uploadPayment();
        Assert.assertEquals(uploadPaymentFilePage.getTheLastPayee(),"csv");
    }
    @Test
    public void verifyClickingOnUploadPaymentButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage =homePage.clickOnUploadPayment();
        uploadPaymentFilePage.clickOnUploadPayment();
        Assert.assertEquals(uploadPaymentFilePage.checkVisibilityOfUploadPaymentForm(),true);
    }
    @Test
    public void verifyClickingOnNACHAButton() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.clickOnNACHA();
        Assert.assertEquals(uploadPaymentFilePage.checkVisibilityOfNACHAForm(),true);
    }
    @Test
    public void verifySelectingNumberOfPages() {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.selectNumberOfPages("25");
        boolean condition ;
                if(uploadPaymentFilePage.getPaymentsCount()<=25)
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
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.selectFilterDate("Cleared","15","15");
        Assert.assertTrue(uploadPaymentFilePage.verifyNoPaymentMessage());
    }
    @Test
    public void verifySelectingFromCustomizationDropDown( ) throws InterruptedException {
        softAssert = new SoftAssert();
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.selectFromCustomizationDropDown("Amount");
        softAssert.assertEquals(uploadPaymentFilePage.checkCustomization(),"Amount");
        softAssert.assertAll();
    }
    @Test
    public void verifySelectingFromExportPageDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.selectFromExportPageDropDown("Export as CSV");
        Thread.sleep(4000);
    }
    @Test
    public void verifySelectingFromWithSelectedDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.selectFromWithSelectedDropDown("Resend Claim Email(s)");
        Assert.assertTrue(uploadPaymentFilePage.verifyClaimFlash());
    }
    @Test
    public void verifySelectingFromSelectDropDown( ) throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.selectFromSelectDropDown("Select All");
        Thread.sleep(2000);
        Assert.assertTrue(uploadPaymentFilePage.verifyNoMatchingFoundMessage());
    }
}
