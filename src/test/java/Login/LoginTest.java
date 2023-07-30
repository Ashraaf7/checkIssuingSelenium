package Login;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validLogin()
    {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://web.checkissuing.com/");
    }}
