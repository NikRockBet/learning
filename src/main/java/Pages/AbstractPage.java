package Pages;

import Helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Абстрактный класс, родитель всех Page'ей
 * Сделан для того, чтобы все Page'и наследовали конструктор и поле с драйвером
 */

public class AbstractPage {
    protected WebDriver driver; // здесь будет хранится драйвер




    /**
     * Дефолтный конструктор. Тут сразу получаем драйвер для взаимодействия с ним
     * А так же инициализируем элементы на Page'ах, которые были заданы с помощью аннотаций @FindBy
     */
    public  AbstractPage(){
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }
}
