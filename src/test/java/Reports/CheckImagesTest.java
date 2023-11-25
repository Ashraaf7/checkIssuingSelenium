package Reports;

import Base.TestBase;
import Pages.Login.LoginPage;
import Pages.Reports.CheckImagesPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckImagesTest extends TestBase {
    SoftAssert softAssert ;

    @Test
    public void verifyDownloadingImages() throws InterruptedException {
        String type ="Sent Payments";
        String date = "15";
        String actualPaymentVerifier =  new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCheckImages()
                .selectPaymentType(type)
                .verifyPaymentType();
        boolean actualDateVerifier =new CheckImagesPage(driver)
                .selectDate(date,date)
                .verifyDate(date);
        new CheckImagesPage(driver).clickDownloadButton();
        softAssert = new SoftAssert();
        softAssert.assertEquals(actualPaymentVerifier,type,"PaymentTypeAssertion");
        softAssert.assertTrue(actualDateVerifier,"DateFilterAssertion");
        softAssert.assertAll();
    }

}
