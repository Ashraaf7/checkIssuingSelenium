package Payments;

import Base.TestBase;
import Pages.Login.LoginPage;
import Pages.Payments.ViewPaymentsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewPaymentsTest extends TestBase {




    @Test
    public void verifyViewingPayment()   {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnViewPayments()
                .clickOnViewPayment();
        Assert.assertTrue(new ViewPaymentsPage(driver).verifyThatViewPaymentAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyEditingPayment() {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnViewPayments()
                .clickOnEditPayment();
        Assert.assertTrue(new ViewPaymentsPage(driver).verifyThatEditPaymentAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithoutAdvanced")
    public void verifyInsertingAttach()   {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnViewPayments()
                .clickOnAttachInsert();
        Assert.assertTrue(new ViewPaymentsPage(driver).verifyThatInsertAttachAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithAdvanced")
    public void verifyCancelingPayment() {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnViewPayments()
                .clickOnCancelPayment();
        Assert.assertTrue(new ViewPaymentsPage(driver).verifyThatCancelPaymentAppears());
    }
    @Test
    public void verifyCheckingImage()   {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnViewPayments()
                .clickOnCheckImage();
        Assert.assertTrue(new ViewPaymentsPage(driver).verifyThatCheckImageAppears());
    }
    @Test(dependsOnMethods = "Payments.UploadPaymentFileTest.verifyUploadingPaymentFile")
    public void verifyApprovePayment() {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnViewPayments()
                .clickOnApprovePayment();
        Assert.assertTrue(new ViewPaymentsPage(driver).verifyThatApprovePaymentAppears());
    }
    @Test(dependsOnMethods = "Payments.CreatePaymentTest.verifyCreatingPaymentOnCheckWithoutAdvanced")
    public void verifyDeletingPayment() {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnViewPayments()
                .clickOnDeletePayment();
        Assert.assertTrue(new ViewPaymentsPage(driver).verifyThatDeletePaymentAppears());
    }

}
