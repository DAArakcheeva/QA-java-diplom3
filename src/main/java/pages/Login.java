package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    private final WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы элементов страницы
    private final By inputEmail = By.xpath(".//input[@name='name']");
    private final By inputPassword = By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    public final By entrance = By.xpath(".//h2[text()='Вход']");
    private final By forgotPasswordButton = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    public final By logo = By.xpath(".//div/a[@href='/']");

    // Ввод email
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    // Ввод пароля
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    // Нажатие кнопки "Войти"
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Нажатие кнопки "Зарегистрироваться"
    public void clickOnRegister() {
        driver.findElement(registerButton).click();
    }

    // Нажатие ссылки "Восстановить пароль"
    public void clickOnForgotPasswordLink() {
        driver.findElement(forgotPasswordButton).click();
    }

    // Авторизация пользователя
    public void authorization(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickOnLoginButton();
    }

    // Ожидание загрузки страницы входа
    public void waitForLoadEntrance() { // ожидание загрузки страницы "вход"
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(entrance));
    }

    // Нажатие кнопки "Конструктор"
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    // Нажатие на лого
    public void clickOnLogo() {
        driver.findElement(logo).click();
    }

}