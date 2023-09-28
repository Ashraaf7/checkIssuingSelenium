package Reports;

import Base.TestBase;
import Pages.Reports.PositivePayPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositivePayTest extends TestBase {

    PositivePayPage positivePayPage ;
    @Test
    public void verifyAccountFilter() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        positivePayPage.selectAccountFilter(fundingResource);
        Thread.sleep(2000);
        Assert.assertEquals(positivePayPage.verifyAccountFilter(),fundingResource);
    }
    @Test
    public void verifyDateFilter() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        String date = "This Week";
        positivePayPage.selectDateFilter(date);
        Thread.sleep(2000);
        Assert.assertEquals(positivePayPage.verifyDateFilter(),date);
    }
    @Test
    public void verifyAddingNewSFTP() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        positivePayPage.clickSFTPUploaderIcon();
        positivePayPage.addSFTPAccount("testSFTP", fundingResource, sftpFormat, "http://0.0.0.0:8089", "test", "test", "YourDirectoryToUpload");
        Thread.sleep(2000);
        Assert.assertTrue(positivePayPage.verifyAddingSFTPAccount());
    }
    @Test
    public void verifyDeletingSFTP() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        positivePayPage.clickSFTPUploaderIcon();
        positivePayPage.deleteSFTPAccount();
        Thread.sleep(2000);
        Assert.assertTrue(positivePayPage.verifyAddingSFTPAccount());
    }


    @Test
    public void verifyDownloadingSFTP() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        positivePayPage=homePage.clickOnPositivePays();
        positivePayPage.clickSFTPDownloadIcon();
        positivePayPage.selectDownloadFormat(sftpFormat);
        positivePayPage.clickDoDownloadLink();
        Thread.sleep(2000);
        String pattern = "^pp-smart-bank-\\d{8}-\\d{8}(\\.txt)?$";
        Assert.assertTrue(positivePayPage.verifyDownloadSFTP(pattern));
    }
}

