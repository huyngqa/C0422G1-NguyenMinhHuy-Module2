package util;

import model.Account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Write {
    public static void writeObjectToCSV(List<String> strings, String pathFile, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String str : strings) {
                bufferedWriter.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writePaymentToCSV(List<Account> paymentAccounts, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (Account account : paymentAccounts) {
            strings.add(account.getAccountToCSV());
        }
        writeObjectToCSV(strings, pathFile, append);
    }
}
