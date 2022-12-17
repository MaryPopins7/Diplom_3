import client.UserRequest;
import pageobject.LoginPageBurger;
import pageobject.PrivateAreaPage;
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

public class PrivateAreaPageTests {
    private UserRequest userClient;
    private WebDriver driver;
    private PrivateAreaPage privateAreaPage;
    private LoginPageBurger objAuthorizationPage;

    @Before
    public void testCreateOrder() {
        userClient = new UserRequest();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        objAuthorizationPage = new LoginPageBurger(driver);
        privateAreaPage = new PrivateAreaPage(driver);
        User user = new User("tropi7@yandex.ru", "1234567", "Mary");
        userClient.create(user);
        objAuthorizationPage.loginByPrivateArea("tropi7@yandex.ru", "1234567");
    }
    @Test
    @DisplayName("Вход в 'Личный кабинет' с описанием")
    public void transitionInPrivateArea() {
        privateAreaPage.clickPrivateAreaButton();
        assertTrue(privateAreaPage.privateAreaDescriptionIsDisplayed());
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void transitionInBurgerConstructor() {
        privateAreaPage.clickPrivateAreaButton();
        privateAreaPage.clickConstructor();
        assertTrue(objAuthorizationPage.orderSubmitButtonIsDisplayed());
    }
    @Test
    @DisplayName("Переход на главную страницу по нажатию на лого")
    public void transitionInLogo() {
        privateAreaPage.clickPrivateAreaButton();
        privateAreaPage.clickLogo();
        assertTrue(objAuthorizationPage.orderSubmitButtonIsDisplayed());
    }
    @Test
    @DisplayName("выход по кнопке 'Выйти' в личном кабинете")
    public void transitionToLoginPageFromPrivateAreaPage() {
        privateAreaPage.logoutFromPrivateArea();
        assertTrue(privateAreaPage.loginTextIsDisplayed());
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