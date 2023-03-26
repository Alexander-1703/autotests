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

    private final SelenideElement group = $$(GROUP).first().shouldBe(visible.because("no group element"));

    public SelenideElement getRecommendGroupName() {
        return group.$(By.xpath(".//*[@class=\"group-detailed-card_name\"]"));
    }

    public SelenideElement getGroupEnterButton() {
        return group.$(By.xpath(".//*[@class=\"button-pro group-join_btn __small __sec\"]"));
    }

    public SelenideElement getRecommendedGroup() {
        return group;
    }

    @Override
    protected void load() {
        //already on this page
    }

    @Override
    protected void isLoaded() throws Error {
        $(group).shouldBe(visible.because("group page doesn`t load"));
    }
}
