package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration {

    public final WebDriver driver;

    public Registration(WebDriver webDriver) {
        this.driver = webDriver;
    }

    // Локаторы элементов страницы регистрации
    public final By regTitle = By.xpath(".//h2[text()='Регистрация']");
    public final By inputs = By.xpath(".//input[@class='text input__textfield text_type_main-default']");
    public final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    public final By errorMessage = By.xpath(".//p[text()='Некорректный пароль']");
    public final By authButton = By.xpath(".//a[@class='Auth_link__1fOlj']");
    public final By registerText = By.xpath(".//div/h2[text()='Регистрация']");


    @Step("Заполнение имени")
    public void setName(String name) {
        driver.findElements(inputs).get(0).sendKeys(name);
    }
    @Step("Заполнение email")
    public void setEmail(String email) {
        driver.findElements(inputs).get(1).sendKeys(email);
    }
    @Step("Заполнение password")
    public void setPassword(String password) {
        driver.findElements(inputs).get(2).sendKeys(password);
    }

    @Step("Нажатие на кнопку регистрации")
    public void clickRegisterButton() {
        // waitButtonIsClickable();
        driver.findElement(registerButton).click();
    }

    // Ожидание кликабельности кнопки
    private void waitButtonIsClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.invisibilityOf(driver.findElement(regTitle)));
    }

    // Ожидание успешной отправки формы
    public void waitFormSubmitted(String expectedTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBe(regTitle, expectedTitle));
    }

    // Ожидание появления ошибки
    public void waitErrorIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(errorMessage)));
    }

    // Получение текста ошибки
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // Регистрация пользователя
    public void registration(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    // Ожидание загрузки страницы регистрации
    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(registerText));
    }

}
