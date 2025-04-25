import pages.ForgotPass;
import pages.Login;
import pages.Main;
import handlers.StellarBurgersEndpoints;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static handlers.WebDrivers.getDriver;

@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

    private WebDriver driver;
    private final String browserName;
    private User user;
    private final static String EMAIL = "arakcheeva-dasha@yandex.ru";
    private final static String PASSWORD = "123456789";

    @Parameterized.Parameters(name="Browser {0}")
    public static Object[][] initParams() {
        return new Object[][]{
                {"chrome"},
                {"yandex"},
        };
    }

    public LoginTest(String browserName) {
        this.browserName = browserName;
    }

    @Before
    @Step("Запуск браузера")
    public void startUp() {
        System.setProperty("browser", browserName);
        driver = getDriver();
        driver.get(StellarBurgersEndpoints.MAIN_PAGE);
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт'.")
    public void enterByLoginButtonTest() {
        Main main = new Main(driver);
        main.clickOnLoginButton();
        Login login = new Login(driver);
        login.authorization(EMAIL, PASSWORD);
        main.waitForLoadMainPage();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void enterByPersonalAccountButtonTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton();
        Login login = new Login(driver);
        login.authorization(EMAIL, PASSWORD);
        main.waitForLoadMainPage();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации,")
    public void enterByRegistrationFormTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton();
        Login login = new Login(driver);
        login.authorization(EMAIL, PASSWORD);
        main.waitForLoadMainPage();
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    public void enterByPasswordRecoveryFormatTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton();
        Login login = new Login(driver);
        login.clickOnForgotPasswordLink();
        ForgotPass password = new ForgotPass(driver);
        password.waitForLoadedRecoverPassword();
        password.clickOnLoginButton();
        login.authorization(EMAIL, PASSWORD);
        main.waitForLoadMainPage();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}