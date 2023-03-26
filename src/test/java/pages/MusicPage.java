package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage extends LoadableComponent<MusicPage> {
    private static final By MUSIC_PLAY_BUTTON_ACTIVE = byXpath("//*[@class=\"pause __active\"]");
    private static final By MUSIC_PLAYER = byXpath("//wm-player-controls");

    public SelenideElement getMusicPlayer() {
        return $(MUSIC_PLAYER).shouldBe(visible.because("no music player on the main page"));
    }

    @Override
    protected void load() {
        //already on this page
    }

    @Override
    protected void isLoaded() throws Error {
        $(MUSIC_PLAY_BUTTON_ACTIVE).shouldBe(visible.because("no music player button on the music page"));
    }


    public boolean isMusicPlaying() {
        return $(MUSIC_PLAY_BUTTON_ACTIVE).shouldBe(visible.because("no music mini player on the main page")).exists();
    }
}
