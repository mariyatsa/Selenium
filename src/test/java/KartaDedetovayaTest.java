import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class KartaDedetovayaTest {
    private static WebDriver driver;
    @BeforeEach

    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    @AfterEach
    void rearDown() {
        driver.quit();
        driver = null;
    }

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }


    @Test
    void test1()  {
        // загружаем страницу
        driver.get("http://localhost:9999/");
       WebElement form = driver.findElement(By.cssSelector("[data-test-id=callback-form]"));
       form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Mariya");
       form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79200005544");
       form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
       form.findElement(By.cssSelector("[data-test-id=submit]")).click();
       String text = driver.findElement(By.className("alert-success")).getText();
       assertEquals(" Ваша заявка успешно отправлена!", text);

        // задержка открываемой страницы
       // Thread.sleep(5000);
    }
}