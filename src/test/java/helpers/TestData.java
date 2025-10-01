package helpers;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@UtilityClass 
public class TestData {
    
    private static final Random random = new Random();
    
    public static String generateEmail() {
        return "test" + System.currentTimeMillis() + "@example.com";
    }
    
    public static String generateRandomEmail() {
        String[] domains = {"example.com", "test.com", "mail.com", "demo.org"};
        String domain = domains[random.nextInt(domains.length)];
        return "user" + random.nextInt(9999) + "@" + domain;
    }
    
    public static String getFirstName() {
        return "AutoTest";
    }
    
    public static String getLastName() {
        return "User";
    }
    
    public static String getRandomFirstName() {
        List<String> names = Arrays.asList("John", "Jane", "Alex", "Emma", "Mike", "Sarah");
        return names.get(random.nextInt(names.size()));
    }
    
    public static String getRandomLastName() {
        List<String> surnames = Arrays.asList("Smith", "Johnson", "Brown", "Davis", "Wilson", "Taylor");
        return surnames.get(random.nextInt(surnames.size()));
    }
    
    public static String getCountry() {
        return "United States";
    }
    
    public static String getState() {
        return "California";
    }

    public static String getSearchQuery() {
        return "kiwi";
    }

    public static String getNegativeSearchQuery() {
        return "lorem ipsum";
    }
    
    public static List<String> getValidSearchQueries() {
        return Arrays.asList("kiwi", "construction", "architecture", "building", "design");
    }
    
    public static List<String> getInvalidSearchQueries() {
        return Arrays.asList("qwerty123", "xyzabc", "lorem ipsum dolor");
    }
    
    public static String getRandomValidSearchQuery() {
        List<String> queries = getValidSearchQueries();
        return queries.get(random.nextInt(queries.size()));
    }
}
