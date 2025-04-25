import handlers.StellarBurgersClient;
import handlers.StellarBurgersEndpoints;
import handlers.User;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Registration;
import pages.Main;
import pages.Login;

import java.util.concurrent.TimeUnit;
import static handlers.WebDrivers.getDriver;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest {

    private WebDriver driver;
    private final String browserName;
    private User user;

    String NAME = "user_" + System.currentTimeMillis();
    String EMAIL = "mail_" + System.currentTimeMillis() + "@mail.ru";
    String PASSWORD = "12345678";
    String PASSWORD_FAILED = "12345";

    @Parameterized.Parameters(name="Browser {0}")
    public static Object[][] initParams() {
        return new Object[][]{
                {"chrome"},
                {"yandex"},
        };
    }
    public RegistrationTest(String browserName) {
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
    @DisplayName("Успешная регистрация.")
    public void successfulRegistrationTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton();
        Login login = new Login(driver);
        login.clickOnRegister();
        Registration registration = new Registration(driver);
        registration.waitForLoadRegisterPage();
        registration.registration(NAME, EMAIL, PASSWORD);
        registration.clickRegisterButton();
        login.waitForLoadEntrance();

    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов..")
    public void failRegistrationTest() {
        Main main = new Main(driver);
        main.clickOnAccountButton();
        Login login = new Login(driver);
        login.clickOnRegister();
        Registration registration = new Registration(driver);
        registration.waitForLoadRegisterPage();
        registration.registration(NAME, EMAIL, PASSWORD_FAILED);
        registration.clickRegisterButton();
        registration.waitErrorIsVisible();

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
        new StellarBurgersClient().deleteTestUser(EMAIL, PASSWORD);
    }
}