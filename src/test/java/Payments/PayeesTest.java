package Payments;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Payments.PayeesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PayeesTest extends PaymentSectionTest {

    PayeesPage payeesPage;
    @Test
    public void verifyCreateNewPayee() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnCreateNewPayee();
        String expectedName = "New Man";
        payeesPage.createNewPayee("Bank 34", expectedName, "ahmed@gmail.com", "Ahmoood", "ahmood@gmail",
                "123", "10", "1", "test", "10", "USPS First Class","Checking");
        Thread.sleep(2000);
        payeesPage.sortIds();
        Thread.sleep(2000);
        String actualName = payeesPage.getPayeeName();
        Assert.assertEquals(actualName,expectedName);
    }
    @Test
    public void verifyPayPayee() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnPayPayee();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatPayPayeeAppears(),true);
    }
    @Test
    public void verifyDisablePayee() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnDisablePayee();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatDisablePayeeAppears(),"Disabled");
    }
    @Test
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
    @Test
    public void verifyDeletingPayee() throws InterruptedException {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnDeletePayee();
        Thread.sleep(2000);
        Assert.assertEquals(payeesPage.verifyThatDeletePayeeAppears(),true);
    }
    @Test
    public void verifyClickingOnCreatePaymentButton() {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        homePage=loginPage.clickOnLoginButton();
        payeesPage =homePage.clickOnPayees();
        payeesPage.clickOnCreatePayment();
        Assert.assertEquals(payeesPage.checkVisibilityOfCreatePaymentForm(),true);
    }


}
