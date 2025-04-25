import handlers.StellarBurgersClient;
import handlers.WebDrivers;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
;
import java.time.Duration;

public class BaseTest {

    protected StellarBurgersClient client = new StellarBurgersClient();
    protected WebDriver driver;

    @After
    public void after() {
        driver.quit();
    }

    @Before
    public void setUp() {
        driver = WebDrivers.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}