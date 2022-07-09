package util;

import model.Account;
import model.PaymentAccount;
import model.SavingAccount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Read {
    private static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException exception) {
            System.err.println(exception.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return strings;
    }

    public static List<Account> readAccountToCSV(String pathFile) {
        List<Account> accounts = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (String str : strings) {
            arr = str.split(",");
            if (arr.length == 8) {
                accounts.add(new SavingAccount(Integer.parseInt(arr[0]), arr[1], arr[2], LocalDate.parse(arr[3]), Integer.parseInt(arr[4]), LocalDate.parse(arr[5]), Double.parseDouble(arr[6]), Integer.parseInt(arr[7])));
            } else if (arr.length == 6) {
                accounts.add(new PaymentAccount(Integer.parseInt(arr[0]), arr[1], arr[2], LocalDate.parse(arr[3]), arr[4], Long.parseLong(arr[5])));
            }
        }
        return accounts;
    }

    public static int readLastBankId(String pathFile) {
        List<String> strings = readObjectToCSV(pathFile);
        return Integer.parseInt(strings.get(0));
    }
}
