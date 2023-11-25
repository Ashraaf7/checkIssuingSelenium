package Reports;

import Base.TestBase;
import Pages.Login.LoginPage;
import Pages.Reports.PaymentFilesPage;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentFilesTest extends TestBase {

    @Test(dependsOnMethods = {"Payments.UploadPaymentFileTest.verifyUploadingPaymentFile"})
    public void verifyFilterOption()  {
        String option = "Today" ;
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnPaymentFiles()
                .selectFilterPayments(option);
        Assert.assertTrue(new PaymentFilesPage(driver).verifyFilteringOption());
    }

    @Test(dependsOnMethods = {"Payments.UploadPaymentFileTest.verifyUploadingPaymentFile"})
    public void verifyDownloadingPayment()   {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnPaymentFiles()
                .clickOnDownloadIcon();
        String filenamePattern = "checkissuing\\.\\d+\\.csv";
        Assert.assertTrue(Utilities.verifyDownloadedFiles(filenamePattern));
    }
}
