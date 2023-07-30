package Reports;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Reports.PositivePayPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositivePayTest extends TestBase {
    HomePage homePage;
    PositivePayPage positivePayPage ;
    @Test
    public void verifyAccountFilter() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        String bank ="Bank 34";
        positivePayPage.selectAccountFilter(bank);
        Thread.sleep(2000);
        Assert.assertEquals(positivePayPage.verifyAccountFilter(),bank);
    }
    @Test
    public void verifyDateFilter() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        String date = "This Week";
        positivePayPage.selectDateFilter(date);
        Thread.sleep(2000);
        Assert.assertEquals(positivePayPage.verifyDateFilter(),date);
    }
    @Test
    public void verifyAddingNewSFTP() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        positivePayPage.clickSFTPUploaderIcon();
        positivePayPage.addSFTPAccount("testSFTP", "Bank 34","Arcadia Power", "http://0.0.0.0:8089", "test", "test", "YourDirectoryToUpload");
        Thread.sleep(2000);
        Assert.assertTrue(positivePayPage.verifyAddingSFTPAccount());
    }
    @Test
    public void verifyDeletingSFTP() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        positivePayPage.clickSFTPUploaderIcon();
        positivePayPage.deleteSFTPAccount();
        Thread.sleep(2000);
        Assert.assertTrue(positivePayPage.verifyAddingSFTPAccount());
    }


    @Test
    public void verifyDownloadingSFTP() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        positivePayPage.clickSFTPDownloadIcon();
        positivePayPage.selectDownloadFormat("Arcadia Power - CSV");
        positivePayPage.clickDoDownloadLink();
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }
}
