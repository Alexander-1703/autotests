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
import pages.MainPage;
import pages.MusicPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("main")
public class MainPageTest {

    private MainPage mainPage;

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
        mainPage = new MainPage().get();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("open music test")
    public void openMusicTest() {
        mainPage.getMusicButton().click();
        MusicPage musicPage = new MusicPage();
        assertTrue(musicPage.getMusicPlayer().exists());
    }

    @Test
    @DisplayName("play music button on main page test")
    public void playMusicFromMainPageTest() {
        mainPage.getMusicPlayButton().click();
        mainPage.getMusicButton().click();
        MusicPage musicPage = new MusicPage();
        assertTrue(musicPage.isMusicPlaying());
    }

    @Test
    @DisplayName("hobbies text")
    public void isHobbiesDisplayed() {
        assertNotNull(mainPage.getHobbies());
    }

}
