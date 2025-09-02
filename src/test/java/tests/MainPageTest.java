package tests;1

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.DemoRequestPage;
import pages.SolutionsPage;
import pages.CareersPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.webdriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Main Page Functionality")
@Feature("Main Page Navigation")
public class MainPageTest extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final DemoRequestPage demoRequestPage = new DemoRequestPage();
    private final SolutionsPage solutionsPage = new SolutionsPage();
    private final CareersPage careersPage = new CareersPage();


    @Test
    @Story("Request Demo Button")
    @DisplayName("Header Request Demo button should be clickable and redirect")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("RequestDemoTest")
    void headerRequestDemoButtonShouldBeClickable() {
        mainPage.openPage();
        mainPage.getHeaderLogo().shouldBe(visible);
        mainPage.getHeaderRequestDemoButton().shouldBe(visible);
        mainPage.clickHeaderRequestDemoButton();
        
        assertTrue(webdriver().driver().url().contains("/demo-request/"), 
            "URL должен содержать '/demo-request/'");
        demoRequestPage.getFormBox().shouldBe(visible);
    }

    @Test
    @Story("Navigation menu should be clickable and redirect")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SolutionsMenuTest")
    @DisplayName("Solutions Menu should be clickable and redirect")
    void solutionsMenuShouldBeClickable() {
        mainPage.openPage();
        mainPage.getSolutionsMenu().shouldBe(visible);
        mainPage.clickSolutionsMenu();
        
        assertTrue(webdriver().driver().url().contains("/solutions/"), 
            "URL должен содержать '/solutions/'");
        solutionsPage.getSolutionsMenu().shouldBe(visible);
    }

    @Test
    @Story("Navigation menu should be clickable and redirect")
    @DisplayName("Careers Menu should be clickable and redirect")
    @Owner("MariiaP")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("CareersMenuTest")
    void careersMenuShouldBeClickable() {
        mainPage.openPage();
        mainPage.getCompanyMenu().shouldBe(visible);
        mainPage.hoverCompanyMenu();
        
        sleep(1000);
        
        mainPage.getCareersMenuItem().shouldBe(visible);
        mainPage.clickCareersMenuItem();

        assertTrue(webdriver().driver().url().contains("/careers/"), 
            "URL должен содержать '/careers/'");
        careersPage.getPageTitle().shouldBe(visible);
    }

}
