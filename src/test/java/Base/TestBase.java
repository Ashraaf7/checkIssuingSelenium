package Base;

import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public WebDriver driver ;
    private EdgeOptions edgeOptions;
    public LoginPage loginPage ;
    public HomePage homePage;
    private final String url ="https://web.checkissuing.com/login" ;
    protected final String userName = "admin@checkissuing.com";
    protected final String password = "1qaz!QAZ";
    @BeforeMethod
    public void setup()
    {

        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }

}
