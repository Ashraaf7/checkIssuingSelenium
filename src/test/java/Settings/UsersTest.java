package Settings;

import Base.TestBase;
import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Pages.Settings.UsersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends TestBase {
    UsersPage usersPage ;

    @Test
    public void verifyAddingUser() throws InterruptedException {
        new LoginPage(driver).enterUsername(userName).enterPassword(password)
                .clickOnLoginButton()
                .clickOnUsers()
                .fillUserData("Ashrooof","ashooorf74","ashrooof@gmail.com")
                .setAllPermissions()
                .clickAddUserButton();
        Assert.assertEquals(usersPage.checkIfUserAdded(),"ashooorf74");
    }

}
