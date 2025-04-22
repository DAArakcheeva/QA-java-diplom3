import PageObjects.Login;
import PageObjects.Main;
import PageObjects.Profile;
import handlers.StellarBurgersEndpoints;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static handlers.WebDrivers.getWebDriver;

@RunWith(Parameterized.class)
    public class MainPageTest {
        private WebDriver driver;
        private String browserName;
        private final static String EMAIL = "arakcheeva-dasha@yandex.ru";
        private final static String PASSWORD = "123456789";

        @Parameterized.Parameters(name = "Browser {0}")
        public static Object[][] initParams() {
            return new Object[][]{
                    {"chrome"},
                    {"yandex"},
            };
        }

        public MainPageTest(String browserName) {
            this.browserName = browserName;
        }

        @Before
        @Step("Запуск браузера")
        public void startUp() {
            driver = getWebDriver(browserName);
            driver.get(StellarBurgersEndpoints.MAIN_PAGE);
        }

        @Test
        @DisplayName("Переход в личный кабинет.")
        public void toProfilePageTest() {
            Main main = new Main(driver);
            main.clickOnAccountButton();
            Login login = new Login(driver);
            login.waitForLoadEntrance();
            Assert.assertTrue("Страница авторизации не отобразилась", driver.findElement(login.entrance).isDisplayed());
        }

        @Test
        @DisplayName("Переход в конструктор из личного кабинета.")
        public void fromProfileToConstructorPageTest() {
            Main main = new Main(driver);
            main.waitForInvisibilityLoadingAnimation();
            main.clickOnAccountButton();
            Login login = new Login(driver);
            login.waitForLoadEntrance();
            login.clickOnConstructorButton();
            main.waitForLoadMainPage();
            Assert.assertTrue("Не удалось перейти", driver.findElement(main.textBurgerMainPage).isDisplayed());
        }

        @Test
        @DisplayName("Клик по логотипу 'Stellar Burgers' из личного кабинета.")
        public void toStellarBurgersFromProfilePageTest() {
            Main main = new Main(driver);
            main.clickOnAccountButton();
            Login login = new Login(driver);
            login.waitForLoadEntrance();
            login.clickOnLogo();
            main.waitForLoadMainPage();
            Assert.assertTrue("Не удалось перейти", driver.findElement(main.textBurgerMainPage).isDisplayed());
        }

        @Test
        @DisplayName("Выход из аккаунта")
        public void exitFromProfileTest() {
            Main main = new Main(driver);
            main.clickOnAccountButton();
            Login login = new Login(driver);
            login.waitForLoadEntrance();
            login.authorization(EMAIL, PASSWORD);
            main.waitForLoadMainPage();
            main.clickOnAccountButton();
            Profile profilePage = new Profile(driver);
            profilePage.waitForLoadProfilePage();
            profilePage.clickLogoutButton();
            main.waitForInvisibilityLoadingAnimation();
            Assert.assertTrue("Не удалось выйти", driver.findElement(login.entrance).isDisplayed());
        }

        @After
        public void teardown() {
            driver.quit();
        }
    }

