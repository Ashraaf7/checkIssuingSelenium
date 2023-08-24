package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Settings.LogosPage;
import Pages.Settings.WhitelabelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WhitelabelTest extends TestBase {
    WhitelabelPage whitelabelPage ;
    @Test
    public void verifyAddingUser() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        whitelabelPage=homePage.clickOnWhiteLabels();
        whitelabelPage.addWhitelabel("AshrafLabel","ashraf.label@gmail.com",true,false);
        Thread.sleep(2000);
        Assert.assertEquals(whitelabelPage.verifyIfLabelAdded(),"AshrafLabel");
    }
}
