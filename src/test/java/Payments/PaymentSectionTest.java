package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Pages.Payments.CreatePaymentPage;
import Pages.Payments.PaymentsSection;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PaymentSectionTest extends TestBase {
    protected SoftAssert softAssert ;

    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifySelectingNumberOfPages() {
        String numberOfPages = "25";
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().selectNumberOfPages(numberOfPages);;
        boolean condition ;
        condition= new PaymentsSection(driver).getPaymentsCount() <= Integer.parseInt(numberOfPages);
        Assert.assertTrue(condition,"Condition for check number of pages");
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyFilteringWithDate() throws InterruptedException {
        String status = "Cleared";
        String from = "15";
        String to = "15" ;
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().selectFilterDate(status,from,to);;
        Assert.assertTrue(new PaymentsSection(driver).verifyNoPaymentMessage());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifySelectingFromCustomizationDropDown( ) throws InterruptedException {
        String customizationOption = "Amount" ;
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().selectFromCustomizationDropDown(customizationOption);
        softAssert.assertEquals(new PaymentsSection(driver).checkCustomization(),customizationOption);
        softAssert.assertAll();
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifySelectingFromExportPageDropDown( ) throws InterruptedException {
        String exportOption ="Export as CSV" ;
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().selectFromExportPageDropDown(exportOption);

        Thread.sleep(4000);
        Assert.assertTrue(Utilities.verifyExportPage("Checkissuing.csv"));
    }
    @Test(dependsOnMethods = {"Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced"})
    public void verifySelectingFromWithSelectedDropDown( ) throws InterruptedException {
        String option = "Resend Claim Email(s)" ;
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().selectFromWithSelectedDropDown(option);
        Assert.assertTrue(new PaymentsSection(driver).verifyClaimFlash());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifySelectingFromSelectDropDown( ) throws InterruptedException {
        String selectOption = "Select All" ;
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().selectFromSelectDropDown(selectOption);
        Thread.sleep(2000);
        Assert.assertTrue(new PaymentsSection(driver).verifyNoMatchingFoundMessage());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyClickingOnCreatePaymentButton() {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().clickOnUploadPayment()
                .clickOnCreatePayment();
        Assert.assertTrue(new PaymentsSection(driver).checkVisibilityOfCreatePaymentForm());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyClickingOnUploadPaymentButton() {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().clickOnUploadPayment();
        Assert.assertTrue(new PaymentsSection(driver).checkVisibilityOfUploadPaymentForm());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyClickingOnNACHAButton() {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment().clickOnNACHA();
        Assert.assertTrue(new PaymentsSection(driver).checkVisibilityOfNACHAForm());
    }
}
