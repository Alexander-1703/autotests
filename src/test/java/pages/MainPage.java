package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends LoadableComponent<MainPage> {
    private static final String LOGIN = "botS23AT6";
    private static final String PASSWORD = "autotests2023";

    private static final By FEED = byXpath("//*[@class=\"filter filter__nowrap h-mod\"]");
    private static final By USER_NAME_BUTTON = byXpath("//*[@class=\"tico ellip\"]");
    private static final By MUSIC_TOOL_BAR_BUTTON = byXpath("//*[@class=\"toolbar_nav_a toolbar_nav_a__audio h-mod\"]");
    private static final By MUSIC_PLAY_BUTTON = byXpath("//*[@class=\"toolbar_music-play h-mod\"]");
    private static final By HOBBIES = byXpath("//*[@class=\"feed js-video-scope __no-ava __compact h-mod\"]");
    private static final By GROUPS = byXpath("//*[@aria-label=\"Группы\"]");

    @Override
    protected void load() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .submitLogin();
    }

    @Override
    protected void isLoaded() throws Error {
        $(FEED).shouldBe(visible.because("no feed field"));
    }

    public SelenideElement getUserNameButton() {
        return $(USER_NAME_BUTTON).shouldBe(visible.because("no name button on the main page"));
    }

    public SelenideElement getMusicButton() {
        return $(MUSIC_TOOL_BAR_BUTTON).shouldBe(visible.because("no music button on the main page"));
    }

    public SelenideElement getMusicPlayButton() {
        return $(MUSIC_PLAY_BUTTON).shouldBe(visible.because("no music play button on the main page"));
    }

    public SelenideElement getHobbies() {
        return $(HOBBIES).shouldBe(visible.because("no hobbies on the main page"));
    }

    public SelenideElement getGroups() {
        return $(GROUPS).shouldBe(visible.because("no groups on the main page"));
    }
}
