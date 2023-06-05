package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VkLoginPage extends LoadableComponent<VkLoginPage> {
    private static final By INPUT_TEL_NUMBER = byXpath("//*[@class=\"vkuiInput__el\"]");
    private static final By LOGIN_FIELD = byXpath("//*[@class=\"vkc__AuthRoot__contentIn\"]");

    @Override
    protected void load() {
        LoginPage loginPage = new LoginPage();
        loginPage.getVkLogin().click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(LOGIN_FIELD).shouldBe(visible.because("no vk login"));
    }

    public SelenideElement getPhoneNumberInput() {
        return $(INPUT_TEL_NUMBER).shouldBe(visible.because("no vk login"));
    }
}
