import PageObjects.Main;
import handlers.StellarBurgersEndpoints;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static handlers.WebDrivers.getWebDriver;

@RunWith(Parameterized.class)
public class ConstructorTest {

    private WebDriver driver;
    private String browserName;
    @Parameterized.Parameters(name="Browser {0}")
    public static Object[][] initParams() {
        return new Object[][]{
                {"chrome"},
                {"yandex"},
        };
    }
    public ConstructorTest(String browserName){
        this.browserName = browserName;
    }
    @Before
    @Step("Запуск браузера")
    public void startUp() {
        driver = getWebDriver(browserName);
        driver.get(StellarBurgersEndpoints.MAIN_PAGE);
    }

    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void transitionToBunsInConstructorTest() throws InterruptedException {
        Main main = new Main(driver);
        main.clickOnSaucesButton();
        main.clickOnBunsButton();
        main.checkToppingBun();
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'.")
    public void transitionToSaucesInConstructorTest() throws InterruptedException {
        Main main = new Main(driver);
        main.clickOnSaucesButton();
        main.checkToppingSauce();
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'.")
    public void transitionToFillingsInConstructorTest() throws InterruptedException {
        Main main = new Main(driver);
        main.clickOnFillingButton();
        main.checkToppingFillings();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
