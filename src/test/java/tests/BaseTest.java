package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://revizto.com/en/");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 30000;
        
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserVersion = "128.0";
        
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new java.util.HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", false);
        }});
        
        Configuration.browserCapabilities = options;
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