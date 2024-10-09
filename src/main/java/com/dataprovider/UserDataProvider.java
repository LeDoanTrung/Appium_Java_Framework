package com.dataprovider;

import com.github.javafaker.Faker;

public class UserDataProvider {

    private static final Faker faker = new Faker();

    public static String generateRandomName() {
        return faker.name().fullName();
    }

    public static String generateRandomMobileNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateRandomPassword() {
        return faker.internet().password(10, 10);
    }

}
