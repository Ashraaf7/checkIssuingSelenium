package Pages.Login;

import Pages.Home.HomePage;
import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.cssSelector("div.text-center > div.p-b-10> button");
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public  void enterUsername(String usernameText)
    {
        PageBase.explicitWait(10,username);
        driver.findElement(username).sendKeys(usernameText);
    }
    public  void enterPassword(String passwordText)
    {
        PageBase.explicitWait(10,password);
        driver.findElement(password).sendKeys(passwordText);
    }
    public HomePage clickOnLoginButton()
    {
        PageBase.explicitWait(10,loginButton);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
