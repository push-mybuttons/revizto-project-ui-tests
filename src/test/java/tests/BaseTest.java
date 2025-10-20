package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;


public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://revizto.com/en/");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "128.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 30000;
        
        Configuration.remote = System.getProperty("remote", 
            "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

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