package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.ViewPaymentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewPaymentsTest extends TestBase {


    ViewPaymentsPage viewPaymentsPage;


    @Test
    public void verifyViewingPayment() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnViewPayment();
        Thread.sleep(2000);
        Assert.assertTrue(viewPaymentsPage.verifyThatViewPaymentAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyEditingPayment() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnEditPayment();
        Assert.assertTrue(viewPaymentsPage.verifyThatEditPaymentAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyInsertingAttach() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnAttachInsert();
        Thread.sleep(2000);
        Assert.assertTrue(viewPaymentsPage.verifyThatInsertAttachAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyCancelingPayment() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnCancelPayment();
        Assert.assertTrue(viewPaymentsPage.verifyThatCancelPaymentAppears());
    }
    @Test
    public void verifyCheckingImage() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnCheckImage();
        Thread.sleep(2000);
        Assert.assertTrue(viewPaymentsPage.verifyThatCheckImageAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyApprovePayment() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnApprovePayment();
        Assert.assertTrue(viewPaymentsPage.verifyThatApprovePaymentAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyDeletingPayment() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnDeletePayment();
        Assert.assertTrue(viewPaymentsPage.verifyThatDeletePaymentAppears());
    }

}
