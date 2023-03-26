package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GroupPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("group")
public class GroupPageTest {
    private GroupPage groupPage;

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
        MainPage mainPage = new MainPage().get();
        mainPage.getGroups().click();
        groupPage = new GroupPage().get();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    public void groupsNameDisplayedTest() {
        assertTrue(groupPage.getRecommendGroupName().getText().length() > 0);
    }

    @Disabled
    @Test
    @DisplayName("group recommendation display test")
    public void groupRecommendationTest() {
        assertTrue(groupPage.getRecommendedGroup().exists());
    }

    @Test
    @DisplayName("recommended groups has entrance button")
    public void groupEntranceButtonTest() {
        assertTrue(groupPage.getGroupEnterButton().exists());
    }

}
