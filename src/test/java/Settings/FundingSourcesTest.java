package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Settings.AllSettingsPage;
import Pages.Settings.FundingSourcesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FundingSourcesTest extends TestBase {
    FundingSourcesPage fundingSourcesPage ;

    @Test
    public void verifyAddingNewFundingSource() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        fundingSourcesPage=homePage.clickOnFundingSources();
        fundingSourcesPage.addingFundingSource(true,false,"Test Name","BankAshraf","Cairo",
                "Checking","10","123456789");
        /*fundingSourcesPage.fillAccountInfoForm("ashroof","BankAshraf","1","10.5"
        ,"Test logo","Cairo","Cairo","Cairo","Cairo", "",
                  "All payments","AV Leads Test","Ashrooof");*/
        Assert.assertEquals(fundingSourcesPage.checkThatAccountAdded(),"Test Name");
    }
}
