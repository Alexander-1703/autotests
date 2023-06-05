package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HobbiesCheckTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    public void openBrowser() {
        open("https://ok.ru/");
        mainPage = new MainPage().get();
    }

    @Test
    @DisplayName("hobbies text")
    public void isHobbiesDisplayed() {
        assertNotNull(mainPage.getHobbies());
    }

}
