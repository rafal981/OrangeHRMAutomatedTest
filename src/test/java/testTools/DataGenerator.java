package testTools;

import com.github.javafaker.Faker;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    private static final StringBuffer stringBuffer = new StringBuffer();

    public DataGenerator() {
    }

    public static String generateLogin() {
        Faker faker = new Faker();
        String var10000 = faker.superhero().prefix();
        return var10000 + faker.name().firstName() + faker.address().buildingNumber();
    }

    public static String generatePassword(int passwordLength) {
        String smallLetter = "abcdefghij";
        String upperLetter = "ABCDEFGHIJ";
        String digit = "0123456789";
        String chars = "!@#%^&!@#$";
        String password = smallLetter + upperLetter + digit + chars;

        for(int i = 0; i < passwordLength; ++i) {
            stringBuffer.append(password.charAt(ThreadLocalRandom.current().nextInt(password.length())));
        }

        return stringBuffer.toString();
    }
}