package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends LoadableComponent<LoginPage> {
    private static final By LOGIN_CONTAINER = byXpath("//*[@data-state-id=\"login\"]");
    private static final By LOGIN_FIELD = byXpath("//*[@name=\"st.email\"]");
    private static final By PASSWORD_FIELD = byXpath("//*[@name=\"st.password\"]");
    private static final By SUBMIT_BTN = byXpath("//*[@class=\"button-pro __wide\"]");
    private static final By INCORRECT_LOG_OR_PASS = byXpath("//*[@class=\"input-e login_error\"]");
    private static final By VK_LOGIN_ICON = byXpath("//*[@class=\"i ic social-icon __s __vk_id\"]");

    @Override
    protected void load() {
        //already on this page
    }

    @Override
    protected void isLoaded() throws Error {
        $(LOGIN_CONTAINER).shouldBe(visible.because("Container didn`t load"));
    }

    public LoginPage setLogin(String login) {
        $(LOGIN_FIELD).shouldBe(visible.because("No login field")).clear();
        $(LOGIN_FIELD).setValue(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        $(PASSWORD_FIELD).shouldBe(visible.because("No password field")).clear();
        $(PASSWORD_FIELD).setValue(password);
        return this;
    }

    public void submitLogin() {
        $(SUBMIT_BTN).shouldBe(visible.because("No submit login button")).click();
    }

    public String getErrLoginField() {
        return $(INCORRECT_LOG_OR_PASS).shouldBe(visible.because("No err login field")).text();
    }

    public SelenideElement getVkLogin() {
        return $(VK_LOGIN_ICON).shouldBe(visible.because("No vk login button"));
    }

}
