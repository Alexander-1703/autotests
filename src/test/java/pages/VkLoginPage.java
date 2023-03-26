package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VkLoginPage implements LoadablePage{
    private static final By INPUT_TEL_NUMBER = byXpath("//*[@class=\"vkuiInput__el\"]");
    private static final By LOGIN_FIELD = byXpath("//*[@class=\"vkc__AuthRoot__contentIn\"]");

    public VkLoginPage() {
        checkPage();
    }

    public SelenideElement getPhoneNumberInput() {
        return $(INPUT_TEL_NUMBER).shouldBe(visible.because("no vk login"));
    }

    @Override
    public void checkPage() {
        $(LOGIN_FIELD).shouldBe(visible.because("no vk login"));
    }
}
