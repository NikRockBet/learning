package Steps;


import Pages.Main;
import Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class LoginPageSteps {
    private LoginPage loginPage;
    private Main mainPage;

    //Статический блок инициализации
    static {System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nik\\Desktop\\googledriver\\geckodriver.exe");}

    //Помечаем метод аннотацией и передаем в нее регулярку. Все что регулярка "вытащит" между скобок будет
    // передано вкаестве строкового аргумента
    @Given("^user navigates to '(.+)'$")
    public void openLoginPage(String url) {
        loginPage = new LoginPage().load();
    }

    @When("^he fill (login|password) field with '(.+)'$")
    public void fillLoginFiled(String fieldName, String text) {
        if (fieldName.equals("login")) {
            loginPage.fillLoginField(text);
        } else {
            loginPage.fillPasswordField(text);
        }
    }

    //    @And("^he fill password field with '(.+)'$")
    //    public void fillPasswordField(String text) {
    //        loginPage.fillPasswordField(text);
    //    }

    @And("^he click submit button$")
    public void submit(){
        loginPage.submit();
    }

    @Then("^he should see '(.+)' in profile box$")
    public void checkUsername(String username) {
        mainPage = new Main();
        Assert.assertEquals(username, mainPage.getUsername());
    }

    @Then("^he should see error message$")
    public void checkForErrorMsg() {
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @And("^user logging out$")
    public void logout() {mainPage.logout();}


}