package Payments;

import Base.TestBase;
import Pages.Payments.CreatePaymentPage;
import Pages.Home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreatePaymentTest extends PaymentSectionTest {

    CreatePaymentPage createPaymentPage;
    @Test
    public void verifyCreatingPaymentOnCheckWithoutAdvanced() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createCheckFormWithoutAdvanced("CheckNotAdvancedTest","test@gmail.com","100","Test","USD","USPS First Class - $0.60");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"CheckNotAdvancedTest");
    }
    @Test
    public void verifyCreatingPaymentOnCheckWithAdvanced() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createCheckFormWithAdvanced("CheckAdvancedTest","test@gmail.com","100","Test","USD","USPS First Class - $0.60","2","20","Test PDF insert","","","","Test logo");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"CheckAdvancedTest");
    }

    @Test
    public void verifyCreatingPaymentOnACHWithoutAdvanced() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createACHFormWithoutAdvanced("Bank 34","ACHNotAdvancedTest","test@gmail.com","100","USD","test","Savings","301011214","301011214");
        Thread.sleep(200);
        Assert.assertEquals(createPaymentPage.getTheLastPayee(),"ACHNotAdvancedTest");
    }
    @Test
    public void verifyCreatingPaymentOnACHWithAdvanced() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        createPaymentPage=homePage.clickOnCreatePayment();
        createPaymentPage.createACHFormWithAdvanced("Bank 34","ACHAdvancedTest","test@gmail.com","100","USD","test","Savings","301011214","301011214","10","Test PDF insert","","");
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
