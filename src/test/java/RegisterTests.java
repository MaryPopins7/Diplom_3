
import client.UserRequest;
import pageobject.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class RegisterTests {
    private UserRequest userClient;
    private WebDriver driver;
    private RegisterPage registerPage;

    @Before
    public void testCreateOrder() {
        userClient = new UserRequest();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        registerPage = new RegisterPage(driver);
    }
    @Test
    @DisplayName("Успешная Регистрация")
    public void successfullyRegistration() {
        registerPage.registration(
                "Mary",
                "tropi7@yandex.ru",
                "1234567");
        assertTrue(registerPage.enterButtonIsDisplayed());
    }
    @After
    public void tearDown() {
        User user = new User("tropi7@yandex.ru", "1234567");
        ValidatableResponse response = userClient.login(user);
        String accessToken = response.extract().path("accessToken");
        userClient.delete(accessToken);

        driver.quit();
    }
}