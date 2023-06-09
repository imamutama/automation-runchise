package helper;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class GeneratedString {
    public static String email;
    public static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        GeneratedString.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        GeneratedString.email = email;
    }

    static Faker faker = new Faker();

    public static String nameDummy() {
        return faker.name().fullName();
    }

    public static String emailDummy() {
        return faker.internet().emailAddress();
    }

}
