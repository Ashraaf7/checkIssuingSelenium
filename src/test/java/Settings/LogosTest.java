package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Pages.Settings.LogosPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogosTest extends TestBase {
    @Test
    public void verifyAddingLogos() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnLogos()
                .addLogo("AshrafLogo","Logo Test","E:\\Projects\\checkIssuingSelenium\\src\\main\\resources\\Attachments\\Image.jpg");
        Assert.assertEquals(new LogosPage(driver).verifyIfLogoAdded(),"AshrafLogo");
    }

}
