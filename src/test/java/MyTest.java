import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MyTest {

    WebDriver driver;
    WebDriverWait wait;
    public static final String user_name = "user";
    public static final String PASSWORD = "user";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nik\\Desktop\\googledriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }




    @Test
    public void LoginTest() {
        driver.navigate().to("http://at.pflb.ru/matrixboard2/");
        WebElement loginField = driver.findElement(By.id("login-username"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));


        loginField.sendKeys(user_name);
        passwordField.sendKeys(PASSWORD);
        submitButton.click();

        WebElement usernameContainer = driver.findElement(By.cssSelector("#profile span"));

        if (usernameContainer.getText() == user_name)
            {
                System.out.println("Все окей, все совпало, можно выпить вина");
            }
            else
                System.out.println("Найден баг, несоответствие");
            }



    @After
    public void Endings() {
        //driver.quit();
    }

}
