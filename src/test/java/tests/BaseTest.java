package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;


public class BaseTest {

    // Экземпляры PageObject классов для переиспользования в тестах
    // protected MainPage mainPage = new MainPage();
    // protected LoginPage loginPage = new LoginPage();
    // protected DashboardPage dashboardPage = new DashboardPage();

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://revizto.com/en/");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "131.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        
        String remote = System.getProperty("remote");
        if (remote != null) {
            Configuration.remote = remote;
        }
        
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 30000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        
        Selenide.closeWebDriver();
    }
}