package com.firebaseapp.todolistapp.todolistapptest.helper;

import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RandomStringHelper {
    private WebDriver driver;

    public RandomStringHelper(WebDriver driver) { this.driver = driver; }

    public String randomString7Characters() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
