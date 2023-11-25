package Settings;

import Base.TestBase;
import Pages.Login.LoginPage;
import Pages.Settings.FundingSourcesPage;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FundingSourcesTest extends TestBase {

    @Ignore
    @Test
    public void verifyAddingNewFundingSource() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnFundingSources()
                .addingFundingSource(true,false,"Test Name","BankAshraf","Cairo",
                "Checking","10","123456789")
                .fillAccountInfoForm("ashroof","BankAshraf","1","10.5"
        ,"Test logo","Cairo","Cairo","Cairo","Cairo", "",
                  "All payments","AV Leads Test","Ashrooof");
        Assert.assertEquals(new FundingSourcesPage(driver).checkThatAccountAdded(),"Test Name");
    }
}
