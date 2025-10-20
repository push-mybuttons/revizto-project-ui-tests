package helpers;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import io.qameta.allure.Step;
import java.util.Locale;

@UtilityClass 
public class TestData {
    

    private static final Faker faker = new Faker(new Locale("en-US"));
        
    @Step("Сгенерировать email")
    public static String generateEmail() {
        return faker.internet().emailAddress();
    }
    
    @Step("Получить имя")
    public static String getFirstName() {
        return faker.name().firstName();
    }
    
    @Step("Получить фамилию")
    public static String getLastName() {
        return faker.name().lastName();
    }
    
    @Step("Получить страну")
    public static String getCountry() {
        return faker.address().country();
    }
    
    @Step("Получить штат")
    public static String getState() {
        return faker.address().state();
    }
    
    @Step("Получить негативный поисковый запрос")
    public static String getNegativeSearchQuery() {
        return faker.lorem().sentence(faker.random().nextInt(3, 5));
    }
    
}
