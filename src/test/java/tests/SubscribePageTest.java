package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SubscribePage;

import static com.codeborne.selenide.Selenide.webdriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubscribePageTest extends BaseTest {

    private final SubscribePage subscribePage = new SubscribePage();

    @Test
    @Story("Subscribing should be possible")
    @DisplayName("Subscribing should be possible")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SubscribeFormTest")
    void subscribeFormShouldBeVisible() {
        subscribePage.openPage();
        subscribePage.waitForFormLoad();
        subscribePage.enterEmail("test@test.com");
        subscribePage.enterFirstName("test");
        subscribePage.enterLastName("test");
        subscribePage.selectCountry("United States");
        subscribePage.selectStateIfPresent("California");
        subscribePage.clickSubscribeButton();
        assertTrue(webdriver().driver().url().contains("/thank-you-for-subscribing/"), 
            "URL должен содержать '/thank-you-for-subscribing/'");
        subscribePage.waitForThankYouPage();
        subscribePage.getThankYouPageTitle();
    }
}