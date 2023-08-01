import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KartaDedetovayaTest {
    private static WebDriver driver;
    @BeforeEach
    void setUp () {
        driver = new ChromeDriver();
    }
    @AfterEach
    void rearDown () {
        driver.quit();
        driver = null;
    }
    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    void test1() {
        driver.get("http://0.0.0.0:9999");
    }
}