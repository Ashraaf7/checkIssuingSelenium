package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Settings.AllSettingsPage;
import Pages.Settings.FundingSourcesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FundingSourcesTest extends TestBase {
    HomePage homePage;
    FundingSourcesPage fundingSourcesPage ;

    @Test
    public void verifyEditingCompanyInfo() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        fundingSourcesPage=homePage.clickOnFundingSources();
        fundingSourcesPage.addingFundingSource(true,false,"Ahroof","BankAshraf","Cairo",
                "Checking","10","123456789");
        fundingSourcesPage.fillAccountInfoForm("ashroof","BankAshraf","1","10.5"
        ,"Test logo","Cairo","Cairo","Cairo","Cairo", "",
                  "All payments","AV Leads Test","Ashrooof");
        Assert.assertEquals(fundingSourcesPage.checkThatAccountAdded(),"Ahroof");
    }
}
