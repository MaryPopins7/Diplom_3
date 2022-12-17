import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import pageobject.HomePageBurger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

 public class HomePageTests {
        private WebDriver driver;
        private HomePageBurger homePageBurger;

        @Before
        public void testCreateOrder() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://stellarburgers.nomoreparties.site/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            homePageBurger = new HomePageBurger(driver);
        }
        @Test
        @DisplayName("Переход на раздел с Булками")
        public void transitionBunsChapter() {
            String actual = homePageBurger.getClassNameBunsChapter();
            String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
            assertEquals(expected, actual);
        }
        @Test
        @DisplayName("Переход на раздел с Соусами")
        public void transitionSaucesChapter() {
            homePageBurger.clickSaucesChapter();
            String actual = homePageBurger.getClassNameSaucesChapter();
            String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
            assertEquals(expected, actual);
        }
        @Test
        @DisplayName("Переход на раздел с Начинками")
        public void transitionFillingChapter() {
            homePageBurger.clickFillingChapter();
            String actual = homePageBurger.getClassNameFillingChapter();
            String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
            assertEquals(expected, actual);
        }
        @After
        public void tearDown() {
            driver.quit();
        }
    }

