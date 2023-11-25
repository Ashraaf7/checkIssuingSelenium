package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Pages.Settings.LogosPage;
import Pages.Settings.WhitelabelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WhitelabelTest extends TestBase {

    @Test
    public void verifyAddingUser() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnWhiteLabels()
                .addWhitelabel("AshrafLabel","ashraf.label@gmail.com",true,false);
        Assert.assertEquals(new WhitelabelPage(driver).verifyIfLabelAdded(),"AshrafLabel");
    }
}
