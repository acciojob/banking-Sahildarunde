package com.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

import static java.lang.Math.min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum<0 || sum>digits*9){
            throw new AccountNumberCannotBeGeneratedException("Account number cannot generated");
        }
        String acNo = "";
        Random rand = new Random();
        int n;
        int remainingSum = sum;
        for(int i=0;i<digits;i++) {
            int max = min(remainingSum+1, 10); //5
            n = rand.nextInt(max);
            acNo += String.valueOf(n);
            remainingSum -= n;
        }
        return acNo;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance - amount < this.minBalance){
            throw new Exception("Insufficient balance");
        }
        this.balance -= amount;
    }

}