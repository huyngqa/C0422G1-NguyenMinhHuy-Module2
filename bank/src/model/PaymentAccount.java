package model;

import java.time.LocalDate;

public class PaymentAccount extends Account {
    private String cardCode;
    private long money;

    public PaymentAccount() {
    }

    public PaymentAccount(String cardCode, long money) {
        this.cardCode = cardCode;
        this.money = money;
    }

    public PaymentAccount(int accountId, String accountCode, String accountName, LocalDate createDayAccount, String cardCode, long money) {
        super(accountId, accountCode, accountName, createDayAccount);
        this.cardCode = cardCode;
        this.money = money;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String getAccountToCSV() {
        return super.getAccountToCSV() + "," + cardCode + "," + money;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                super.toString() + "\n" +
                "Số thẻ: " + cardCode + "\n" +
                "Số tiền trong thẻ: " + money + "\n" +
                "}" + "\n" +
                "-----------------------------------";
    }
}
