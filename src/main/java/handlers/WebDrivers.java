package handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDrivers {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "yandex":
                    System.setProperty("webdriver.chrome.driver", "./src/test/resources/yandexdriver.exe");
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            // Максимизация окна браузера
            driver.manage().window().maximize();
        }

        return driver;
    }
}