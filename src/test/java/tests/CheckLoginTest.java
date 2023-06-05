package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import matchers.VkLoginMatcher;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckLoginTest extends BaseTest {

    private static final String LOGIN = "";
        private static final String PASSWORD = "";

    private LoginPage loginPage;

    @BeforeEach
    public void openBrowser() {
        open("https://ok.ru/");
        loginPage = new LoginPage();
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
        assertEquals(loginPage.getErrLoginField(), "Неправильно указан логин и/или пароль",
                "there is no message about wrong username or password");
    }

    @Test
    @DisplayName("through vk login button operation test")
    public void vkLoginTest() {
        assertThat(true, new VkLoginMatcher());
    }
}
