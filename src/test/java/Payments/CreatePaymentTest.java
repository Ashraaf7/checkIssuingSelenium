package Payments;

import Base.TestBase;
import Pages.Login.LoginPage;
import Pages.Payments.CreatePaymentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePaymentTest extends TestBase {
    @Test
    public void verifyCreatingPaymentOnCheckWithoutAdvanced() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment()
                .createCheckFormWithoutAdvanced("CheckWithoutAdvancedTest","test@gmail.com","100","Test","USD","USPS First Class - $0.60");
        Thread.sleep(200);
        Assert.assertEquals(new CreatePaymentPage(driver).getTheLastPayee(),"CheckWithoutAdvancedTest");
    }
    @Test
    public void verifyCreatingPaymentOnCheckWithAdvanced() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment()
        .createCheckFormWithAdvanced("CheckAdvancedTest","test@gmail.com","100","Test","USD","USPS First Class - $0.60","2","20","No Insert","","","","No Logo");
        Thread.sleep(200);
        Assert.assertEquals(new CreatePaymentPage(driver).getTheLastPayee(),"CheckAdvancedTest");
    }

    @Test
    public void verifyCreatingPaymentOnACHWithoutAdvanced() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment()
        .createACHFormWithoutAdvanced(fundingResource,"ACHNotAdvancedTest","test@gmail.com","100","USD","test","Savings","301011214","301011214");
        Thread.sleep(200);
        Assert.assertEquals(new CreatePaymentPage(driver).getTheLastPayee(),"ACHNotAdvancedTest");
    }
    @Test
    public void verifyCreatingPaymentOnACHWithAdvanced() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment()
        .createACHFormWithAdvanced(fundingResource,"ACHAdvancedTest","test@gmail.com","100","USD","test","Savings","301011214","301011214","10","No Insert","","");
        Thread.sleep(200);
        Assert.assertEquals(new CreatePaymentPage(driver).getTheLastPayee(),"ACHAdvancedTest");
    }
    @Test
    public void verifyClickingOnCreatePaymentButton() {
        new LoginPage(driver).enterUsername(userName).enterPassword(password).clickOnLoginButton()
                .clickOnCreatePayment();
        Assert.assertFalse(new CreatePaymentPage(driver).checkVisibilityOfCreatePaymentForm());
    }


}
