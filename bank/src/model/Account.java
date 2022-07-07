package model;

import java.time.LocalDate;

public abstract class Account {
    private int accountId;
    private String accountCode;
    private String accountName;
    private LocalDate createDayAccount;

    public Account() {
    }

    public Account(int accountId, String accountCode, String accountName, LocalDate createDayAccount) {
        this.accountId = accountId;
        this.accountCode = accountCode;
        this.accountName = accountName;
        this.createDayAccount = createDayAccount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDate getCreateDayAccount() {
        return createDayAccount;
    }

    public void setCreateDayAccount(LocalDate createDayAccount) {
        this.createDayAccount = createDayAccount;
    }

    public String getAccountToCSV() {
        return accountId + "," + accountCode + "," + accountName + "," + createDayAccount;
    }

    @Override
    public String toString() {
        return "Id tài khoản: " + accountId + "\n" +
                "Mã tài khoản: " + accountCode + "\n" +
                "Tên tài khoản: " + accountName + "\n" +
                "Ngày tạo tài khoản: " + createDayAccount;
    }
}
