import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderingCardTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void rearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void test1() {// проверка валидации полей
        // загружаем страницу
        // driver.get("http://localhost:9999/");
        // WebElement form = driver.findElement(By.cssSelector("[data-test-id=callback-form]"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Хоружевская Мария");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79200005544");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector("button.button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);

        // задержка открываемой страницы
        //Thread.sleep(5000);
    }
}