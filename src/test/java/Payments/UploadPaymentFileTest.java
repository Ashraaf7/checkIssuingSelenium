package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Pages.Payments.UploadPaymentFilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class UploadPaymentFileTest extends TestBase {




    @Test
    public void verifyUploadingPaymentFile() throws InterruptedException, AWTException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnUploadPayment()
                 .uploadPayment("Checkissuing.csv");
        Assert.assertEquals(new UploadPaymentFilePage(driver).getTheLastPayee(),"csv");
    }

}
