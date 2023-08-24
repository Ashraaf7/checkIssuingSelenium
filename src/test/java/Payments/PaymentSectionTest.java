package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.CreatePaymentPage;
import Pages.Payments.PaymentsSection;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PaymentSectionTest extends TestBase {
    private PaymentsSection paymentsSection;
    protected SoftAssert softAssert ;
    @Test
    public void verifySelectingNumberOfPages() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection=homePage.clickOnCreatePayment();
        String numberOfPages = "25";
        paymentsSection.selectNumberOfPages(numberOfPages);
        boolean condition ;
        if(paymentsSection.getPaymentsCount()<=Integer.parseInt(numberOfPages))
            condition= true;
        else
            condition=false;
        Assert.assertTrue(condition,"Condition for check number of pages");
    }
    @Test
    public void verifyFilteringWithDate() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection=homePage.clickOnCreatePayment();
        String status = "Cleared";
        String from = "15";
        String to = "15" ;
        paymentsSection.selectFilterDate(status,from,to);
        Assert.assertTrue(paymentsSection.verifyNoPaymentMessage());
    }
    @Test
    public void verifySelectingFromCustomizationDropDown( ) throws InterruptedException {
        softAssert = new SoftAssert();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection=homePage.clickOnCreatePayment();
        String customizationOption = "Amount" ;
        paymentsSection.selectFromCustomizationDropDown(customizationOption);
        softAssert.assertEquals(paymentsSection.checkCustomization(),customizationOption);
        softAssert.assertAll();
    }
    @Test
    public void verifySelectingFromExportPageDropDown( ) throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection=homePage.clickOnCreatePayment();
        String exportOption ="Export as CSV" ;
        paymentsSection.selectFromExportPageDropDown(exportOption);
        Thread.sleep(4000);
        Assert.assertTrue(paymentsSection.verifyExportPage());
    }
    @Test
    public void verifySelectingFromWithSelectedDropDown( ) throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection=homePage.clickOnCreatePayment();
        String option = "Resend Claim Email(s)" ;
        paymentsSection.selectFromWithSelectedDropDown(option);
        Assert.assertTrue(paymentsSection.verifyClaimFlash());
    }
    @Test
    public void verifySelectingFromSelectDropDown( ) throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection=homePage.clickOnCreatePayment();
        String selectOption = "Select All" ;
        paymentsSection.selectFromSelectDropDown(selectOption);
        Thread.sleep(2000);
        Assert.assertTrue(paymentsSection.verifyNoMatchingFoundMessage());
    }
    @Test
    public void verifyClickingOnCreatePaymentButton() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection =homePage.clickOnUploadPayment();
        paymentsSection.clickOnCreatePayment();
        Assert.assertEquals(paymentsSection.checkVisibilityOfCreatePaymentForm(),true);
    }
    @Test
    public void verifyClickingOnUploadPaymentButton() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection=homePage.clickOnCreatePayment();
        paymentsSection.clickOnUploadPayment();
        Assert.assertEquals(paymentsSection.checkVisibilityOfUploadPaymentForm(),true);
    }
    @Test
    public void verifyClickingOnNACHAButton() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentsSection=homePage.clickOnCreatePayment();
        paymentsSection.clickOnNACHA();
        Assert.assertEquals(paymentsSection.checkVisibilityOfNACHAForm(),true);
    }
}
