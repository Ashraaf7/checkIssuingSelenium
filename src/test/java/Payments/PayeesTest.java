package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.PayeesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PayeesTest extends TestBase {

    PayeesPage payeesPage;
    @Test
    public void verifyCreateNewPayee() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnCreateNewPayee();
        String expectedName = "New Man";
        payeesPage.createNewPayee(fundingResource, expectedName, "ahmed@gmail.com", "Ahmoood", "ahmood@gmail",
                "123", "10", "1", "test", "10", "USPS First Class","Checking");
        Thread.sleep(2000);
        payeesPage.sortIds();
        Thread.sleep(2000);
        String actualName = payeesPage.getPayeeName();
        Assert.assertEquals(actualName,expectedName);
    }
    @Test(dependsOnMethods = "Payments.PayeesTest.verifyCreateNewPayee")
    public void verifyPayPayee() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnPayPayee();
        Thread.sleep(2000);
        Assert.assertTrue(payeesPage.verifyThatPayPayeeAppears());
    }
    @Test(dependsOnMethods = "Payments.PayeesTest.verifyCreateNewPayee")
    public void verifyDisablePayee() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnDisablePayee();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatDisablePayeeAppears(),"Disabled");
        //For enabling it for next test
        payeesPage.clickOnEnablePayee();
    }
    @Test(dependsOnMethods = "Payments.PayeesTest.verifyCreateNewPayee")
    public void verifyPayeeDetails() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        String expected = payeesPage.getPayeeName();
        payeesPage.clickOnPayeeDetails();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatPayeeDetailsAppears(),expected);
    }
    @Test(dependsOnMethods = "Payments.PayeesTest.verifyCreateNewPayee")
    public void verifyDeletingPayee() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();

        payeesPage.clickOnDeletePayee();
        Thread.sleep(2000);
        Assert.assertTrue(payeesPage.verifyThatDeletePayeeAppears());
    }



}
