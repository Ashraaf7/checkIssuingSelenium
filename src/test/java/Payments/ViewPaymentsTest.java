package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.ViewPaymentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewPaymentsTest extends PaymentSectionTest {


    ViewPaymentsPage viewPaymentsPage;


    @Test
    public void verifyViewingPayment() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnViewPayment();
        Thread.sleep(2000);
        Assert.assertEquals(viewPaymentsPage.verifyThatViewPaymentAppears(),true);
    }
    @Test
    public void verifyEditingPayment() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnEditPayment();
        Assert.assertEquals(viewPaymentsPage.verifyThatEditPaymentAppears(),true);
    }
    @Test
    public void verifyInsertingAttach() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnAttachInsert();
        Thread.sleep(2000);
        Assert.assertEquals(viewPaymentsPage.verifyThatInsertAttachAppears(),true);
    }
    @Test
    public void verifyCancelingPayment() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnCancelPayment();
        Assert.assertEquals(viewPaymentsPage.verifyThatCancelPaymentAppears(),true);
    }
    @Test
    public void verifyCheckingImage() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnCheckImage();
        Thread.sleep(2000);
        Assert.assertEquals(viewPaymentsPage.verifyThatCheckImageAppears(),true);
    }
    @Test
    public void verifyApprovePayment() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnApprovePayment();
        Assert.assertEquals(viewPaymentsPage.verifyThatApprovePaymentAppears(),true);
    }
    @Test
    public void verifyDeletingPayment() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        viewPaymentsPage =homePage.clickOnViewPayments();
        viewPaymentsPage.clickOnDeletePayment();
        Assert.assertEquals(viewPaymentsPage.verifyThatDeletePaymentAppears(),true);
    }

}
