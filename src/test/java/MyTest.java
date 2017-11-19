import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class MyTest {

    WebDriver driver;
    WebDriverWait wait;
    public static final String user_name = "user";
    public static final String user_password = "user";

    // создаем 2 константы, для логина под админом

    public static final String superuser_name = "admin";
    public static final String superuser_password = "admin";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nik\\Desktop\\googledriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }


    @After
    public void Endings() {
        driver.quit();
    }


    @Test
    public void LoginTest() {

        driver.navigate().to("http://at.pflb.ru/matrixboard2/");
        WebElement loginField =     driver.findElement(By.id("login-username"));
        WebElement passwordField =  driver.findElement(By.id("login-password"));
        WebElement submitButton =   driver.findElement(By.id("login-button"));

        loginField.sendKeys(superuser_name);
        passwordField.sendKeys(superuser_password);
        submitButton.click();

        //  проверка логина
        WebElement usernameContainer = driver.findElement(By.cssSelector("#profile span"));
        Assert.assertEquals(superuser_name, usernameContainer.getText());
        //  если не совпадает, то вызывается исключение

    }


    @Test
    public void adminTest()

    {
        driver.navigate().to("http://at.pflb.ru/matrixboard2/");
        WebElement loginField =     driver.findElement(By.id("login-username"));
        WebElement passwordField =  driver.findElement(By.id("login-password"));
        WebElement submitButton =   driver.findElement(By.id("login-button"));

        loginField.sendKeys(superuser_name);
        passwordField.sendKeys(superuser_password);
        submitButton.click();

        // находим по id, элемент который добавляет пользователя
        WebElement adduserButton = driver.findElement(By.id("add-person"));

        // проверяем, отображается он или нет. Если нет, то админ прав нет
        Assert.assertTrue("Ошибка, админ прав нет",adduserButton.isDisplayed() == true);
    }


}




