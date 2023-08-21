package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Settings.UsersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends TestBase {
    HomePage homePage;
    UsersPage usersPage ;

    @Test
    public void verifyAddingUser() throws InterruptedException {
        loginPage.enterUsername("admin@checkissuing.com");
        loginPage.enterPassword("1qaz!QAZ");
        homePage=loginPage.clickOnLoginButton();
        usersPage=homePage.clickOnUsers();
        usersPage.fillUserData("Ashrooof","ashooorf74","ashrooof@gmail.com");
        usersPage.setAllPermissions();
        usersPage.clickAddUserButton();
        Thread.sleep(3000);
        Assert.assertEquals(usersPage.checkIfUserAdded(),"ashooorf74");
    }

}
