package Reports;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Reports.CheckImagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckImagesTest extends TestBase {
    CheckImagesPage checkImagesPage;
    HomePage homePage;
    SoftAssert softAssert ;
    @Test
    public void verifyDownloadingImages() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        checkImagesPage=homePage.clickOnCheckImages();
        String type ="Sent Payments";
        checkImagesPage.selectPaymentType(type);
        String actualPaymentVerifier = checkImagesPage.verifyPaymentType();
        String date = "15";
        checkImagesPage.selectDate(date,date);
        boolean actualDateVerifier = checkImagesPage.verifyDate(date);
        checkImagesPage.clickDownloadButton();
        Thread.sleep(4000);
        softAssert = new SoftAssert();
        softAssert.assertEquals(actualPaymentVerifier,type,"PaymentTypeAssertion");
        softAssert.assertTrue(actualDateVerifier,"DateFilterAssertion");
        softAssert.assertAll();
    }

}
