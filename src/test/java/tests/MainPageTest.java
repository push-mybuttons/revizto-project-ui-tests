package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.DemoRequestPage;
import pages.SolutionsPage;
import pages.CareersPage;
import pages.SubscribePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;

@Epic("Main Page Functionality")
@Feature("Main Page Navigation")
public class MainPageTest extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final DemoRequestPage demoRequestPage = new DemoRequestPage();
    private final SolutionsPage solutionsPage = new SolutionsPage();
    private final CareersPage careersPage = new CareersPage();
    private final SubscribePage subscribePage = new SubscribePage();

    @Test
    @Story("Demo request navigation")
    @DisplayName("Header Request Demo button should redirect to demo page")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("RequestDemoTest")
    void headerRequestDemoButtonShouldRedirectToDemoPage() {
        mainPage.openPage()
                .clickHeaderRequestDemoButton();
        
        verifyUrlContains("/demo-request/");
        demoRequestPage.getFormBox().shouldBe(visible);
    }

    @Test
    @Story("Solutions navigation")
    @DisplayName("Solutions menu should redirect to solutions page")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SolutionsMenuTest")
    void solutionsMenuShouldRedirectToSolutionsPage() {
        mainPage.openPage()
                .clickSolutionsMenu();
        
        verifyUrlContains("/solutions/");
        solutionsPage.getSolutionsMenu().shouldBe(visible);
    }

    @Test
    @Story("Company navigation")
    @DisplayName("Careers menu should redirect to careers page")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CareersMenuTest")
    void careersMenuShouldRedirectToCareersPage() {
        mainPage.openPage()
                .hoverCompanyMenu()
                .clickCareersMenuItem();

        verifyUrlContains("/careers/");
        careersPage.getPageTitle().shouldBe(visible);
    }

    @Test
    @Story("Newsletter subscription navigation")
    @DisplayName("Subscribe button should redirect to subscription page")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SubscribeButtonTest")
    void subscribeButtonShouldRedirectToSubscriptionPage() {
        mainPage.openPage()
                .clickSubscribeButton();

        verifyUrlContains("/subscribe-to-revizto-reporter/");
        subscribePage.getPageTitle().shouldBe(visible);
    }

    @Test
    @Story("News and media functionality")
    @DisplayName("News and media slides should be switchable")
    @Owner("MariiaP")
    @Severity(SeverityLevel.NORMAL)
    @Tag("NewsAndMediaTest")
    void newsAndMediaSlidesShouldBeSwitchable() {
        mainPage.openPage()
                .scrollToNewsMediaSection();
        
        String titleBefore = mainPage.getFirstVisibleCardKey();

        mainPage.clickPreviousNewsButton();
        String titleAfter = mainPage.getFirstVisibleCardKey();
        
        Assertions.assertNotEquals(titleBefore, titleAfter, 
                                  "News slide should change after clicking Previous button");
    }

    private void verifyUrlContains(String expectedPath) {
        assertTrue(webdriver().driver().url().contains(expectedPath), 
                   "URL should contain: " + expectedPath);
    }
}
