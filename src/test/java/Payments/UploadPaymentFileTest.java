package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.UploadPaymentFilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class UploadPaymentFileTest extends TestBase {


    UploadPaymentFilePage uploadPaymentFilePage;


    @Test
    public void verifyUploadingPaymentFile() throws InterruptedException, AWTException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        uploadPaymentFilePage=homePage.clickOnUploadPayment();
        uploadPaymentFilePage.uploadPayment();
        Assert.assertEquals(uploadPaymentFilePage.getTheLastPayee(),"csv");
    }

}
