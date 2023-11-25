package Payments;

import Base.TestBase;
import Pages.Login.LoginPage;
import Pages.Payments.PayeesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PayeesTest extends TestBase {

    @Test
    public void verifyCreateNewPayee() {
        String expectedName = "New Man";
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnPayees().clickOnCreateNewPayee()
                .createNewPayee(fundingResource, expectedName, "ahmed@gmail.com", "Ahmoood", "ahmood@gmail",
                "123", "10", "1", "test", "10", "USPS First Class","Checking")
                .sortIds();
        //Thread.sleep(2000);
        Assert.assertEquals(new PayeesPage(driver).getPayeeName(),expectedName);
    }
    @Test(dependsOnMethods = "Payments.PayeesTest.verifyCreateNewPayee")
    public void verifyPayPayee() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnPayees()
                .clickOnPayPayee();
        Assert.assertTrue(new PayeesPage(driver).verifyThatPayPayeeAppears());
    }
    @Test(dependsOnMethods = "Payments.PayeesTest.verifyCreateNewPayee")
    public void verifyDisablePayee() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnPayees()
                .clickOnDisablePayee();
        Assert.assertEquals(new PayeesPage(driver).verifyThatDisablePayeeAppears(),"Disabled");
        //For enabling it for next test
        new PayeesPage(driver).clickOnEnablePayee();
    }
    @Test(dependsOnMethods = "Payments.PayeesTest.verifyCreateNewPayee")
    public void verifyPayeeDetails() throws InterruptedException {
       String expected = new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnPayees()
                .getPayeeName();
        new PayeesPage(driver).clickOnPayeeDetails();
        Thread.sleep(2000);
        Assert.assertEquals(new PayeesPage(driver).verifyThatPayeeDetailsAppears(),expected);
    }
    @Test(dependsOnMethods = "Payments.PayeesTest.verifyCreateNewPayee")
    public void verifyDeletingPayee() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnPayees()
                .clickOnDeletePayee();
        Assert.assertTrue(new PayeesPage(driver).verifyThatDeletePayeeAppears());
    }



}
