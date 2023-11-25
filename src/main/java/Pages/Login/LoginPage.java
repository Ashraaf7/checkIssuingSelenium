package Pages.Login;

import Pages.Home.HomePage;
import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage   {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("div.text-center > div.p-b-10> button");
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver= driver;
    }


    public  LoginPage enterUsername(String usernameText)
    {
        Utilities.explicitlyWaitForVisibility(driver, username);
        driver.findElement(username).sendKeys(usernameText);
        return this;
    }
    public  LoginPage enterPassword(String passwordText)
    {
        Utilities.explicitlyWaitForVisibility(driver, password);
        driver.findElement(password).sendKeys(passwordText);
        return this;
    }
    public HomePage clickOnLoginButton()
    {
        Utilities.explicitlyWaitForClickability(driver, loginButton);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
