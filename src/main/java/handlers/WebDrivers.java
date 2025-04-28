package handlers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDrivers {

    protected WebDriver driver;

    public static void main(String[] args) {
        WebDrivers app = new WebDrivers();
        app.setup(); // Вызываем метод setup для инициализации драйвера и открытия URL
    }

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Остальные настройки
        driver.manage().window().maximize(); // Разворачиваем окно браузера на полный экран
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    public WebDriver getDriver() {
        return driver;
    }


}