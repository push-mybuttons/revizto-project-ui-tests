package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.sleep;    
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.codeborne.selenide.Condition.text;

public class SubscribePage {

    private final SelenideElement pageTitle = $("h1"),
                                  subscribeForm = $("form"),
                                  emailInput = $("input[type='email']"),
                                  firstNameInput = $("input[name='fname']"),
                                  lastNameInput = $("input[name='lname']"),
                                  countryDropdown = $("#nf-field-382"),
                                  stateDropdown = $("#nf-field-386"),
                                  subscribeButton = $("input[type='submit']"),
                                  processingButton = $("input[type='submit'][value='Processing']"),
                                  thankYouPageTitle = $("h1");
                               

    public static final String SUBSCRIBE_URL = "https://revizto.com/en/subscribe-to-revizto-reporter/";

    public SelenideElement getPageTitle() {
        pageTitle.shouldBe(visible);
        pageTitle.shouldHave(text("Subscribe to Revizto Reporter"));
        return pageTitle;

    }

    public SubscribePage openPage() {
        open(SUBSCRIBE_URL);
        waitForFormLoad();
        return this;
    }

    public void waitForFormLoad() {
        sleep(1000);
        subscribeForm.should(appear);
        countryDropdown.should(appear)
                       .shouldBe(enabled);
    }


    public void enterEmail(String email) {
        emailInput.scrollIntoView(true)
                  .shouldBe(visible, enabled)
                  .setValue(email);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
       
    }
    public void enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void selectCountry(String country) {
        countryDropdown.shouldBe(visible, enabled)
                       .selectOption(country);
        }


    public void selectStateIfPresent(String state) {
        if (stateDropdown.isDisplayed()) {
            stateDropdown.shouldBe(visible, enabled)
                         .selectOption(state);
                        
        }
    }

    public void clickSubscribeButton() {
        subscribeButton.shouldBe(visible, enabled)
                       .click();

        processingButton.shouldBe(visible);
        sleep(5000);
        

    }

    public SelenideElement getThankYouPageTitle() {
        thankYouPageTitle.shouldBe(visible);
        thankYouPageTitle.shouldHave(text("Thank You for Subscribing"));
        return thankYouPageTitle;
    }

    public void waitForThankYouPage() {
        
        assertTrue(webdriver().driver().url().contains("/thank-you-for-subscribing/"), 
            "URL должен содержать '/thank-you-for-subscribing/'");
        thankYouPageTitle.shouldBe(visible);
    }
}
