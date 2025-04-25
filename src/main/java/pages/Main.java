package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Main {

    private WebDriver driver;
    public Main(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы элементов
    private final By logo = By.xpath(".//div/a[@href='/']");
    public final By placeAnOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By accountButton = By.xpath(".//a[@href='/account']");
    public final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By saucesButton = By.xpath("//span[@class='text text_type_main-default'][text()='Соусы']");
    public final By bunsButton = By.xpath(".//span[text()='Булки']");
    public final By fillingsButton = By.xpath(".//span[text()='Начинки']");
    private final By header = By.xpath(".//main//h1");
    public By textBurgerMainPage = By.xpath(".//section/h1[text()='Соберите бургер']");
    private final By activityTopping = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]//span");


    // Элементы изображений и подписей компонентов
    public By bunsImg = By.xpath(".//img[@alt='Краторная булка N-200i']");
    public By bunsText = By.xpath(".//h2[text()='Булки']");
    public By saucesImg = By.xpath(".//p[text()='Соус с шипами Антарианского плоскоходца']");
    public By fillingsImg = By.xpath(".//img[@alt='Плоды Фалленианского дерева']");


    public void scrollToFillings(){
        WebElement element = driver.findElement(By.xpath(".//h2[text()= 'Начинки']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOnLoginButton() {
        // Ждем исчезновение модала
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[starts-with(@class, 'Modal_modal_overlay')]")));

        // Пытаемся совершить обычный клик
        try {
            driver.findElement(loginButton).click();
        } catch (Exception e) {
            // Если клик не сработал, используем JavaScript клик
            WebElement button = driver.findElement(loginButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
        waitForInvisibilityLoadingAnimation();
    }

    public void clickOnAccountButton() {
        // Ждем исчезновение модала
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[starts-with(@class, 'Modal_modal_overlay')]")));

        // Пытаемся совершить обычный клик
        try {
            driver.findElement(accountButton).click();
        } catch (Exception e) {
            // Если клик не сработал, используем JavaScript клик
            WebElement button = driver.findElement(accountButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
        waitForInvisibilityLoadingAnimation();
    }

    public void clickOnLogo() {
        // Ждем исчезновение модала
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[starts-with(@class, 'Modal_modal_overlay')]")));

        // Пытаемся совершить обычный клик
        try {
            driver.findElement(logo).click();
        } catch (Exception e) {
            // Если клик не сработал, используем JavaScript клик
            WebElement button = driver.findElement(logo);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
        waitForInvisibilityLoadingAnimation();
    }

    public void clickOnConstructorButton() {
        // Ждем исчезновение модала
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[starts-with(@class, 'Modal_modal_overlay')]")));

        // Пытаемся совершить обычный клик
        try {
            driver.findElement(constructorButton).click();
        } catch (Exception e) {
            // Если клик не сработал, используем JavaScript клик
            WebElement button = driver.findElement(constructorButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
        waitForInvisibilityLoadingAnimation();
    }

    public void clickOnBunsButton() {
        // Ждем исчезновение модала
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[starts-with(@class, 'Modal_modal_overlay')]")));

        // Пытаемся совершить обычный клик
        try {
            driver.findElement(bunsButton).click();
        } catch (Exception e) {
            // Если клик не сработал, используем JavaScript клик
            WebElement button = driver.findElement(bunsButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }

    public void clickOnSaucesButton() {
        // Ждем исчезновение модала
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[starts-with(@class, 'Modal_modal_overlay')]")));

        // Пытаемся совершить обычный клик
        try {
            driver.findElement(saucesButton).click();
        } catch (Exception e) {
            // Если клик не сработал, используем JavaScript клик
            WebElement button = driver.findElement(saucesButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }

    public void clickOnFillingButton() {
        // Ждем исчезновение модала
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[starts-with(@class, 'Modal_modal_overlay')]")));

        // Пытаемся совершить обычный клик
        try {
            driver.findElement(fillingsButton).click();
        } catch (Exception e) {
            // Если клик не сработал, используем JavaScript клик
            WebElement button = driver.findElement(fillingsButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }

    public void checkToppingBun() {
        String countActivity = waitForElementToBeVisible(activityTopping).getText();
        assertEquals("Булки", countActivity); // соус, потому что таков функционал
    }

    public void checkToppingSauce() {
        String countActivity = waitForElementToBeVisible(activityTopping).getText();
        assertEquals("Соусы", countActivity);
    }

    public void checkToppingFillings() {
        String countActivity = waitForElementToBeVisible(activityTopping).getText();
        assertEquals("Начинки", countActivity);
    }

    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(textBurgerMainPage));
    }

    public void waitForLoadBunsHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsImg));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsText));
    }

    public void waitForLoadSaucesHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesImg));
        waitDocReady();
    }

    public void waitForLoadFillingsHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsImg));
        waitDocReady();
    }

    public void waitForInvisibilityLoadingAnimation() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath(".//img[@src='./static/media/loading.89540200.svg' and @alt='loading animation']")));
        waitDocReady();
    }

    public void waitDocReady() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until((ExpectedCondition<Boolean>) wd ->
                        ((JavascriptExecutor) wd)
                                .executeScript("return document.readyState")
                                .equals("complete"));
    }

    private WebElement waitForElementToBeClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitForElementToBeVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}