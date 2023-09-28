package Payments;

import Base.TestBase;
import Pages.Payments.CreatePaymentPage;
import Pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreatePaymentTest extends TestBase {

    CreatePaymentPage createPaymentPage;
    @Test
    public void verifyCreatingPaymentOnCheckWithoutAdvanced() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createCheckFormWithoutAdvanced("CheckWithoutAdvancedTest","test@gmail.com","100","Test","USD","USPS First Class - $0.60");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"CheckWithoutAdvancedTest");
    }
    @Test
    public void verifyCreatingPaymentOnCheckWithAdvanced() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createCheckFormWithAdvanced("CheckAdvancedTest","test@gmail.com","100","Test","USD","USPS First Class - $0.60","2","20","No Insert","","","","No Logo");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"CheckAdvancedTest");
    }

    @Test
    public void verifyCreatingPaymentOnACHWithoutAdvanced() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createACHFormWithoutAdvanced(fundingResource,"ACHNotAdvancedTest","test@gmail.com","100","USD","test","Savings","301011214","301011214");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"ACHNotAdvancedTest");
    }
    @Test
    public void verifyCreatingPaymentOnACHWithAdvanced() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createACHFormWithAdvanced(fundingResource,"ACHAdvancedTest","test@gmail.com","100","USD","test","Savings","301011214","301011214","10","Test PDF insert","","");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"ACHAdvancedTest");
    }
    @Test
    public void verifyClickingOnCreatePaymentButton() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.clickOnCreatePayment();
        Assert.assertEquals(createPaymentPage.checkVisibilityOfCreatePaymentForm(),false);
    }


}
