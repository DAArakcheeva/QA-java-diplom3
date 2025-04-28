import handlers.User;
import pages.Login;
import pages.Main;
import pages.Profile;
import handlers.StellarBurgersEndpoints;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class MainPageTest extends BaseTest{

    private WebDriver driver;
    private User user;

    @Before
    @Step("Запуск браузера")
    public void startUp() {
        driver = getDriver(); // получаем драйвер, заданный внешними параметрами
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
        login.authorization(user.getEmail(), user.getPassword());
        main.waitForLoadMainPage();
        main.clickOnAccountButton();
        Profile profilePage = new Profile(driver);
        profilePage.waitForLoadProfilePage();
        profilePage.clickLogoutButton();
        main.waitForInvisibilityLoadingAnimation();
        Assert.assertTrue("Не удалось выйти", driver.findElement(login.entrance).isDisplayed());
    }

}