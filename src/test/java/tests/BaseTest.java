package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://revizto.com/en/");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 30000;
        
        boolean isLocal = Boolean.parseBoolean(System.getProperty("local", "false"));
        
        if (!isLocal) {
            String selenoidUser = System.getProperty("selenoidUser");
            String selenoidPassword = System.getProperty("selenoidPassword");
            String selenoidUrl = System.getProperty("selenoidUrl", "selenoid.autotests.cloud/wd/hub");
            
            Configuration.remote = String.format("https://%s:%s@%s", 
                    selenoidUser, selenoidPassword, selenoidUrl);
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", false
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("AllureSelenide");
    }
}