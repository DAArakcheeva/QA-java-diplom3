package handlers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDrivers {

    private WebDriver driver;

    public WebDrivers(String browserName) {
        this.driver = openBrowser(browserName);
    }
    public WebDrivers() {

    }

    private WebDriver openBrowser(String browserName) {
        switch (browserName) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
                return new ChromeDriver();
            case "YANDEX":
                System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/usr/bin/yandex-browser" );
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Нераспознанный браузер: " + browserName);
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}

    /*protected WebDriver driver;

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
    }*/
