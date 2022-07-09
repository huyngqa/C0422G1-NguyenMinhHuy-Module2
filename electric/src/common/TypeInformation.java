package common;

import util.Read;

import java.util.List;
import java.util.Scanner;

public class TypeInformation {
    private static Scanner scanner = new Scanner(System.in);

    public static String getInformationTypeCustomer(String pathFile) {
        List<String> list = Read.readObjectToCSV(pathFile);
        System.out.println("Chọn loại khách hàng trong danh sách");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        int choose;
        while (true) {
            try {
                System.out.print("Mời bạn chọn(1-3): ");
                choose = Integer.parseInt(scanner.nextLine());
                if(choose < 1 || choose > 3 ) {
                    System.err.println("chọn từ 1->3!!!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!!");
            }
        }
        String typeCustomer = list.get(choose - 1).substring(list.get(choose - 1).indexOf(",") + 1);
        return typeCustomer;
    }
}
