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

public class ValidationCheckTest {
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
public void test2(){
    driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Mariya Hkoruzhevskaya");
    driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79200005544");
    driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
    driver.findElement(By.cssSelector("button.button")).click();
    String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText().trim();
    assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text);
    }
    @Test
    public void test3(){
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Мария Хоружевская");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+792000055444");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector("button.button")).click();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.",
                driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText().trim());
    }
    @Test
    public void test4(){
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Мария хоружевская");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button.button")).click();
        assertEquals("Поле обязательно для заполнения",
                driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText().trim());
    }
    }


