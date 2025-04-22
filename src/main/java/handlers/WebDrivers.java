package handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDrivers {

    public static WebDriver getWebDriver(String browserName) {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver;

        switch (browserName) {
            case "chrome":
                options.setBinary("C:\\chrome-win64 (3)\\chrome-win64\\chrome.exe");
                driver = new ChromeDriver(options);
                break;

            case "yandex":
                driver = new ChromeDriver(options.setBinary("C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe"));
                break;

            default:
                throw new RuntimeException("Incorrect browser name");
        }

        // Максимизировать окно браузера
        driver.manage().window().maximize();

        return driver;
    }
}
