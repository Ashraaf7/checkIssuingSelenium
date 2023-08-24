package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Settings.AllSettingsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSettingsTest extends TestBase {

    AllSettingsPage allSettingsPage ;

    @Test
    public void verifyEditingCompanyInfo()   {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        allSettingsPage=homePage.clickOnAllSettings();
        allSettingsPage.completeCompanyProfile("www.test.com","cairo","ahmed esmat","1","(011) 461-9615","ahmed - ahmedashraaf09@gmail.com","ahmed - ahmedashraaf09@gmail.com","ashroof");
        Assert.assertEquals(allSettingsPage.assertionForSaving(),true);
    }
}
