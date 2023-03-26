package matchers;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codeborne.selenide.WebDriverRunner;

import pages.VkLoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class VkLoginMatcher extends TypeSafeMatcher<Boolean> {
    private static final By VK_LOGIN_ICON = byXpath("//*[@class=\"i ic social-icon __s __vk_id\"]");

    @Override
    protected boolean matchesSafely(Boolean bool) {
        $(VK_LOGIN_ICON).shouldBe(visible.because("No err login field")).click();
        String currentWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = WebDriverRunner.getWebDriver().getWindowHandles();
        allWindows.removeAll(Collections.singleton(currentWindow));
        String newWindow = allWindows.iterator().next();
        switchTo().window(newWindow);

        VkLoginPage vkLoginPage = new VkLoginPage();
        return vkLoginPage.getPhoneNumberInput() != null;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("vk login icon exist check");
    }
}
