package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.GroupPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupCheckTest extends BaseTest {
    private GroupPage groupPage;

    @BeforeEach
    public void openBrowser() {
        open("https://ok.ru/");
        groupPage = new GroupPage().get();
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
