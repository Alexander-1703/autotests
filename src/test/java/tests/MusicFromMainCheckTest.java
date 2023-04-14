package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.MainPage;
import pages.MusicPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicFromMainCheckTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void openBrowser() {
        open("https://ok.ru/");
        mainPage = new MainPage().get();
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
}
