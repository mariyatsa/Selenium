import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class KartaDedetovayaTest {
    private static WebDriver driver;

    @BeforeEach
    void setUp() {
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
    void test1() throws InterruptedException {
        // загружаем страницу
        driver.get("http://http://localhost:9999/");
       // WebElement form = driver.findElement(By.cssSelector("[data-test-id=callback-form]"));
        //form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Mariya");
        //form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79200005544");
        //form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        //form.findElement(By.cssSelector("[data-test-id=submit]")).click();
        //String text = driver.findElement(By.className("alert-success")).getText();
        //Assert.assertEquals(" Ваша заявка успешно отправлена!", text);

        // задержка открываемой страницы
        Thread.sleep(5000);
    }
}