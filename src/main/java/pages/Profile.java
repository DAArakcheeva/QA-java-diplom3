package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Profile {

    private WebDriver driver;

    public Profile(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы элементов страницы профиля
    private final By profileNavLink = By.xpath(".//a[contains(@class, 'Account_link_active')]");
    private final By logOutLink = By.xpath(".//nav[starts-with(@class, 'Account_nav')]/ul/li/button");
    private final By modalOverlay = By.xpath(".//div[starts-with(@class, 'App_App')]/div/div[starts-with(@class, 'Modal_modal_overlay')]");
    public final By textOnProfilePage = By.xpath(".//nav/p[text()='В этом разделе вы можете изменить свои персональные данные']");


    // Ожидание видимости активной ссылки профиля
    public void waitAuthFormVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(profileNavLink));
    }

    public void waitButtonIsClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(driver.findElement(modalOverlay)));
    }

    // Нажатие кнопки выхода
    public void clickLogoutButton() {
        waitButtonIsClickable();
        driver.findElement(logOutLink).click();
    }

    // Ожидание загрузки страницы профиля
    public void waitForLoadProfilePage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textOnProfilePage));
    }
}