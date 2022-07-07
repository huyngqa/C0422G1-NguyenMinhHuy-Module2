package model;

import java.time.LocalDate;

public class SavingAccount extends Account {
    private int savedMoney;
    private LocalDate dateSavingMoney;
    private double interestRate;
    private int term;

    public SavingAccount() {
    }

    public SavingAccount(int savedMoney, LocalDate dateSavingMoney, double interestRate, int term) {
        this.savedMoney = savedMoney;
        this.dateSavingMoney = dateSavingMoney;
        this.interestRate = interestRate;
        this.term = term;
    }

    public SavingAccount(int accountId, String accountCode, String accountName, LocalDate createDayAccount, int savedMoney, LocalDate dateSavingMoney, double interestRate, int term) {
        super(accountId, accountCode, accountName, createDayAccount);
        this.savedMoney = savedMoney;
        this.dateSavingMoney = dateSavingMoney;
        this.interestRate = interestRate;
        this.term = term;
    }

    public int getSavedMoney() {
        return savedMoney;
    }

    public void setSavedMoney(int savedMoney) {
        this.savedMoney = savedMoney;
    }

    public LocalDate getDateSavingMoney() {
        return dateSavingMoney;
    }

    public void setDateSavingMoney(LocalDate dateSavingMoney) {
        this.dateSavingMoney = dateSavingMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String getAccountToCSV() {
        return super.getAccountToCSV() + "," + savedMoney + "," + dateSavingMoney + "," + interestRate + "," + term;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                super.toString() + "\n" +
                "Số tiền gửi: " + savedMoney + "\n" +
                "Ngày gửi tiết kiệm: " + dateSavingMoney + "\n" +
                "Lãi suất: " + interestRate + "\n" +
                "Kì hạn: " + term +
                "}" + "\n" +
                "-----------------------------------";
    }
}
