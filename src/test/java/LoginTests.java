import client.UserRequest;
import pageobject.LoginPageBurger;
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
import static org.junit.Assert.*;

public class LoginTests {
    private UserRequest userRequest;
    private WebDriver driver;
    private LoginPageBurger loginPageBurger;

    @Before
    public void testCreateOrder() {
        userRequest = new UserRequest();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPageBurger = new LoginPageBurger(driver);
        User user = new User("tropi7@yandex.ru", "1234567", "Mary");
        userRequest.create(user);
    }
    @Test
    @DisplayName("Авторизация через кнопку Личный Кабинет")
    public void loginByPrivateAreaButton() {
        loginPageBurger.loginByPrivateArea(
                "tropi7@yandex.ru",
                "1234567");
        assertTrue(loginPageBurger.orderSubmitButtonIsDisplayed());
    }
    @Test
    @DisplayName("Авторизация через кнопку Войти в аккаунт")
    public void loginByEnterAccountButton() {
        loginPageBurger.loginByEnterAccountButton(
                "tropi7@yandex.ru",
                "1234567");
        assertTrue(loginPageBurger.orderSubmitButtonIsDisplayed());
    }
    @Test
    @DisplayName("Авторизация через кнопку Войти на странице восстановления пароля")
    public void loginByUpdatePasswordPage() {
        loginPageBurger.loginByChangePassword(
                "tropi7@yandex.ru",
                "1234567");
        assertTrue(loginPageBurger.orderSubmitButtonIsDisplayed());
    }
    @After
    public void tearDown() {
        User user = new User("tropi7@yandex.ru", "1234567");
        ValidatableResponse response = userRequest.login(user);
        String accessToken = response.extract().path("accessToken");
        userRequest.delete(accessToken);
        driver.quit();
    }
}
