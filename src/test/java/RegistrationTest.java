import handlers.StellarBurgersEndpoints;
import handlers.User;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.Registration;
import pages.Main;
import pages.Login;

public class RegistrationTest extends BaseTest {

    private WebDriver driver;
    private User user;

    @Before
    @Step("Запуск браузера")
    public void startUp() {
        driver = getDriver(); // получаем драйвер, заданный внешними параметрами
        driver.get(StellarBurgersEndpoints.MAIN_PAGE);

    }

    @Test
    @DisplayName("Успешная регистрация.")
    public void successfulRegistrationTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton();
        Login login = new Login(driver);
        login.clickOnRegister();
        Registration registration = new Registration(driver);
        registration.waitForLoadRegisterPage();
        registration.registration(user.getName(), user.getEmail(), user.getPassword());
        registration.clickRegisterButton();
        login.waitForLoadEntrance();
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void failRegistrationTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton();
        Login login = new Login(driver);
        login.clickOnRegister();
        Registration registration = new Registration(driver);
        registration.waitForLoadRegisterPage();
        registration.registration(user.getName(), user.getEmail(), "false");
        registration.clickRegisterButton();
        registration.waitErrorIsVisible();
    }

    @After
    public void cleanUp() {
        // Удаляем тестового пользователя через API
        client.deleteTestUser(user.getEmail(), user.getPassword());
    }

}