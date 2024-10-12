package com.dataprovider;

import com.github.javafaker.Faker;
import com.model.Account;

public class AccountDataProvider {

    private final Faker faker = new Faker();

    public  String generateRandomName() {
        return faker.name().fullName();
    }

    public  String generateRandomMobileNumber() {
        return faker.number().digits(10);
    }

    public  String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public  String generateRandomPassword() {
        return faker.internet().password(8, 16);
    }

    public  Account generateRandomAccount() {
        return new Account(generateRandomName(), generateRandomMobileNumber(), generateRandomEmail(), generateRandomPassword());
    }
}
