package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;
import matchers.VkLoginMatcher;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("login")
public class LoginPageTest {

    private static final String LOGIN = "botS23AT6";
    private static final String PASSWORD = "autotests2023";
    private static final String ERR_LOGIN_STRING = "Неправильно указан логин и/или пароль";

    private LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.driverManagerEnabled = true;
        Configuration.browser = "chrome";
        Configuration.timeout = 4000;
        Configuration.headless = true;

    }

    @BeforeEach
    public void openBrowser() {
        open("https://ok.ru/");
        loginPage = new LoginPage();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("login test with valid login and password")
    public void validLoginTest() {
        loginPage
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .submitLogin();
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.getUserNameButton().exists(), "Main page didn`load, but was valid login/password");
    }

    @Test
    @DisplayName("login test with INVALID login and password")
    public void invalidLoginTest() {
        loginPage
                .setLogin("qwdqwdqdq")
                .setPassword("wdq23wewef")
                .submitLogin();
        assertEquals(loginPage.getErrLoginField(), ERR_LOGIN_STRING,
                "there is no message about wrong username or password");
    }

    @Test
    @DisplayName("through vk login button operation test")
    public void vkLoginTest() {
        assertThat(true, new VkLoginMatcher());
    }
}
