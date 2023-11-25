package Settings;

import Base.TestBase;
import Pages.Login.LoginPage;
import Pages.Settings.AllSettingsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSettingsTest extends TestBase {


    @Test
    public void verifyEditingCompanyInfo()   {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnAllSettings()
        .completeCompanyProfile("www.test.com","cairo","ahmed esmat","1","(011) 461-9615","Chys custom body shop - Chyannelitchfield13@gmail.com","Chys custom body shop - Chyannelitchfield13@gmail.com","ashroof");
        Assert.assertTrue(new AllSettingsPage(driver).assertionForSaving());
    }
}
