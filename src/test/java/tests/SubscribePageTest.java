package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SubscribePage;
import helpers.TestData;


@Epic("Subscription Functionality")
@Feature("Newsletter Subscription")
public class SubscribePageTest extends BaseTest {

    private final SubscribePage subscribePage = new SubscribePage();

    @Test
    @Story("Newsletter subscription flow")
    @DisplayName("User should be able to subscribe to newsletter")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SubscribeFormTest")
    void userShouldBeAbleToSubscribeToNewsletter() {
        subscribePage.openPage()
                     .enterEmail(TestData.generateEmail())
                     .enterFirstName(TestData.getFirstName())
                     .enterLastName(TestData.getLastName())
                     .selectCountry(TestData.getCountry())
                     .selectStateIfPresent(TestData.getState())
                     .clickSubscribeButton()
                     .waitForThankYouPage()
                     .verifyThankYouPageTitle();
    }
}