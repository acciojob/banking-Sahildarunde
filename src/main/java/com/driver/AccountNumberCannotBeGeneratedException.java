package com.driver;

public class AccountNumberCannotBeGeneratedException extends Exception {
    public AccountNumberCannotBeGeneratedException(String accountNumberCannotGenerated) {
        super(accountNumberCannotGenerated);
    }
}
