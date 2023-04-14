package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GroupPage extends LoadableComponent<GroupPage> {
    private static final By GROUP = byXpath("//*[@class=\"ucard-v __h __none-border soh-s __trimmed\"]");

    public SelenideElement getRecommendGroupName() {

        return $$(GROUP).first().shouldBe(visible.because("no group element"))
                .$(By.xpath(".//*[@class=\"group-detailed-card_name\"]"));
    }

    public SelenideElement getGroupEnterButton() {
        return $$(GROUP).first().shouldBe(visible.because("no group element"))
                .$(By.xpath(".//*[@class=\"button-pro group-join_btn __small __sec\"]"));
    }

    public SelenideElement getRecommendedGroup() {
        return $$(GROUP).first().shouldBe(visible.because("no group element"));
    }

    @Override
    protected void load() {
        MainPage mainPage = new MainPage().get();
        mainPage.getGroups().click();
    }

    @Override
    protected void isLoaded() throws Error {
        $($$(GROUP).first().shouldBe(visible.because("no group element"))).shouldBe(visible.because("group page doesn`t load"));
    }
}
