package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Settings.LogosPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogosTest extends TestBase {
    HomePage homePage ;
    LogosPage logosPage ;
    @Test
    public void verifyAddingLogos() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        logosPage=homePage.clickOnLogos();
        logosPage.addLogo("AshrafLogo","Logo Test","E:\\Projects\\checkIssuingSelenium\\src\\main\\resources\\Attachments\\Image.jpg");
        Thread.sleep(2000);
        Assert.assertEquals(logosPage.verifyIfLogoAdded(),"AshrafLogo");
    }

}
