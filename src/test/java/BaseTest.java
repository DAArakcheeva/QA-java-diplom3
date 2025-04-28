import handlers.StellarBurgersClient;
import handlers.User;
import handlers.WebDrivers;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;

import java.util.Random;

public class BaseTest extends WebDrivers {

    protected StellarBurgersClient client = new StellarBurgersClient();
    protected User user; // Хранение пользователя в базовом классе

    @Before
    public void setupBeforeAllTests() {
        setup(); // Настройка драйвера через WebDrivers

        // Генерация случайного пользователя перед каждым тестом
        user = generateRandomUser();
        client.createUser(user); // Регистрация пользователя через API
    }

    @After
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit(); // Закрытие браузера
        }
    }

    // Метод для генерации случайного пользователя
    private User generateRandomUser() {
        Random random = new Random();
        int randNumber = random.nextInt(1000000);
        User user = new User();
        user.setEmail("test.user+" + randNumber + "@mail.ru");
        user.setPassword("passw0rd!" + randNumber);
        user.setName("Test " + randNumber);
        return user;
    }

}