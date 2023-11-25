package Reports;

import Base.TestBase;
import Pages.Login.LoginPage;
import Pages.Reports.PositivePayPage;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class PositivePayTest extends TestBase {

    @Test
    public void verifyAccountFilter()   {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnPositivePays()
                .selectAccountFilter(fundingResource);
        Assert.assertEquals(new PositivePayPage(driver).verifyAccountFilter(),fundingResource);
    }
    @Test
    public void verifyDateFilter()   {
        String date = "This Week";
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnPositivePays()
                .selectDateFilter(date);
        Assert.assertEquals(new PositivePayPage(driver).verifyDateFilter(),date);
    }
    @Test
    public void verifyAddingNewSFTP()   {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnPositivePays()
                .clickSFTPUploaderIcon()
                .addSFTPAccount("testSFTP", fundingResource, sftpFormat, "http://0.0.0.0:8089", "test", "test", "YourDirectoryToUpload");
        Assert.assertTrue(new PositivePayPage(driver).verifyAddingSFTPAccount());
    }
    @Test
    public void verifyDeletingSFTP()   {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnPositivePays()
                .clickSFTPUploaderIcon()
                 .deleteSFTPAccount();
        Assert.assertTrue(new PositivePayPage(driver).verifyAddingSFTPAccount());
    }


    @Test
    public void verifyDownloadingSFTP() throws AWTException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnPositivePays()
                .clickSFTPDownloadIcon()
                .selectDownloadFormat(sftpFormat)
                .clickDoDownloadLink();
        String pattern = "^pp-smart-bank-\\d{8}-\\d{8}(\\.txt)?$";
        new Robot().delay(3000);
        Assert.assertTrue(Utilities.verifyDownloadedFiles(pattern));
    }
}

