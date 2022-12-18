import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class RegisterWrongTest {
    private WebDriver driver;
    private RegisterPage registerPage;

    @Before
    public void testCreateOrder() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        registerPage = new RegisterPage(driver);
    }
    @Test
    @DisplayName("Неккоректный пароль при Регистрации")
    public void registrationFail() {
        registerPage.registrationFailed(
                "Mary",
                "tropi7@yandex.ru",
                "1234");
        assertTrue(registerPage.getPasswordError());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

