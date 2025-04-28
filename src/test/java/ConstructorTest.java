import pages.Main;
import handlers.StellarBurgersEndpoints;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ConstructorTest extends BaseTest {

    private WebDriver driver;

    @Before
    @Step("Запуск браузера")
    public void startUp() {
        driver = getDriver(); // получаем драйвер, заданный внешними параметрами
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


}