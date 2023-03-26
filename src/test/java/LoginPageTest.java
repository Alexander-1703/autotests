import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;
import matchers.VkLoginMatcher;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest {

    private static final String LOGIN = "botS23AT6";
    private static final String PASSWORD = "autotests2023";
    private static final String ERR_LOGIN_STRING = "Неправильно указан логин и/или пароль";

    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.driverManagerEnabled = true;
        Configuration.browser = "chrome";
        Configuration.timeout = 4000;

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
    public void validLoginTest() {
        loginPage
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .submitLogin();
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.getNameField().exists(), "Main page didn`load, but was valid login/password");
    }

    @Test
    public void invalidLoginTest() {
        loginPage
                .setLogin("qwdqwdqdq")
                .setPassword("wdq23wewef")
                .submitLogin();
//        assertEquals(loginPage.getErrLoginField(), ERR_LOGIN_STRING,
//                "there is no message about wrong username or password");
        assertThat(loginPage.getErrLoginField(), equalToIgnoringCase(ERR_LOGIN_STRING));
    }

    @Test
    public void vkLoginTest() {
        assertThat(true, new VkLoginMatcher());
    }
}
