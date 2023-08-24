package Reports;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Reports.PaymentFilesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentFilesTest extends TestBase {
    PaymentFilesPage paymentFilesPage ;
    HomePage homePage;
    @Test
    public void verifyFilterOption() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentFilesPage=homePage.clickOnPaymentFiles();
        String option = "Today" ;
        paymentFilesPage.selectFilterPayments(option);
        Thread.sleep(2000);
        Assert.assertTrue(paymentFilesPage.verifyFilteringOption());
    }

    @Test
    public void verifyDownloadingPayment() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        paymentFilesPage=homePage.clickOnPaymentFiles();
        paymentFilesPage.clickOnDownloadIcon();
        Thread.sleep(2000);
        String fileName = paymentFilesPage.getFileName();
        Assert.assertTrue(paymentFilesPage.verifyDownloadPayments(fileName));
    }
}
