package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage implements LoadablePage{
    private static final By FEED = byXpath("//*[@id=\"hook_Block_UserMainFullMRB\"]");
    private static final By NAME = byXpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");

    public MainPage() {
        checkPage();
    }

    public SelenideElement getNameField() {
        return $(NAME).shouldBe(visible.because("no name field"));
    }


    @Override
    public void checkPage() {
        $(FEED).shouldBe(visible.because("no feed field"));
    }
}
