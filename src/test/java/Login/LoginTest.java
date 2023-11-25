package Login;

import Base.TestBase;
import Pages.Login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validLogin()
    {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://web.checkissuing.net/");
    }
}
