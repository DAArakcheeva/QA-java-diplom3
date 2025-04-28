import handlers.StellarBurgersClient;
import handlers.User;
import handlers.UserCredentials;
import pages.ForgotPass;
import pages.Login;
import pages.Main;
import handlers.StellarBurgersEndpoints;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class LoginTest extends BaseTest {

    private WebDriver driver;
    private User user;

    @Before
    @Step("Запуск браузера")
    public void startUp() {
        driver = getDriver(); // получаем драйвер, заданный внешними параметрами
        driver.get(StellarBurgersEndpoints.MAIN_PAGE); // переходим на главную страницу
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт'")
    public void enterByLoginButtonTest() {
        Main main = new Main(driver);
        main.clickOnLoginButton(); // нажимаем на кнопку "Войти в аккаунт"
        Login login = new Login(driver);
        login.authorization(user.getEmail(), user.getPassword()); // вводим почту и пароль main.waitForLoadMainPage(); // ждем загрузки главной страницы
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void enterByPersonalAccountButtonTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton(); // нажимаем на кнопку "Личный кабинет"
        Login login = new Login(driver);
        login.authorization(user.getEmail(), user.getPassword()); // вводим почту и пароль
        main.waitForLoadMainPage(); // ждем загрузки главной страницы
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void enterByRegistrationFormTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton(); // нажимаем на кнопку "Личный кабинет"
        Login login = new Login(driver);
        login.clickOnRegister(); // переходим в форму регистрации
        login.authorization(user.getEmail(), user.getPassword()); // вводим почту и пароль
        main.waitForLoadMainPage(); // ждем загрузки главной страницы
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void enterByPasswordRecoveryFormatTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton(); // нажимаем на кнопку "Личный кабинет"
        Login login = new Login(driver);
        login.clickOnForgotPasswordLink(); // переходим в форму восстановления пароля
        ForgotPass password = new ForgotPass(driver);
        password.waitForLoadedRecoverPassword(); // ждем загрузки формы восстановления пароля
        password.clickOnLoginButton(); // возвращаемся к форме входа
        login.authorization(user.getEmail(), user.getPassword()); // вводим почту и пароль
        main.waitForLoadMainPage(); // ждем загрузки главной страницы
    }

    @After
    public void cleanUp() {
        // Удаляем тестового пользователя через API
        client.deleteTestUser(user.getEmail(), user.getPassword());
    }

}