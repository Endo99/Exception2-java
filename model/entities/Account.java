package model.entities;

import model.exception.AccountException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit( double amount ) {
        this.balance += amount;
    }

    public void withdraw( double amount ) {
        if ( amount > withdrawLimit ) { // Se o amount for maior que o limite de Saque, então lança uma exceção.
            throw new AccountException("Withdraw error: The amount exceeds withdraw limit");
        }
        if ( amount > balance ) { // Se o saque for maior que o saldo, então lança exceção;
            throw new AccountException("Whithdraw error: Not enough balance");
        }
        this.balance -= amount;
    }

}
