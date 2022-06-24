package controller;

import service.IBikeService;
import service.ICarService;
import service.ITrunksService;
import service.impl.BikeService;
import service.impl.CarService;
import service.impl.RemoveAndSearch;
import service.impl.TrunksService;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static ITrunksService trunksService = new TrunksService();
    private static ICarService carService = new CarService();
    private static IBikeService bikeService = new BikeService();
    private static RemoveAndSearch removeAndSearch = new RemoveAndSearch();

    public static void displayMainMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
        System.out.println();
        boolean temp = true;
        do {
            System.out.println();
            System.out.println("Chọn chức năng: " +
                    "\n 1. Thêm mới phương tiện" +
                    "\n 2. Hiển thị phương tiện" +
                    "\n 3. Xoá phương tiện" +
                    "\n 4. Tìm kiếm theo phương tiện" +
                    "\n 5. Thoát\n");
            System.out.print("Mời bạn chọn chức năng: ");
            int choose = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choose) {
                case 1:
                    System.out.println("Chức năng thêm mới");
                    displayMenuAdd();
                    break;
                case 2:
                    System.out.println("Hiện thị phương tiện");
                    displayMenuTransport();
                    break;
                case 3:
                    System.out.println("Xoá phương tiện");
                    deleteTransport();
                    break;
                case 4:
                    System.out.println("Tìm kiếm phương tiện");
                    searchBySeaOfControl();
                    break;
                case 5:
                    System.out.println("Thoát khỏi chương trình");
                    temp = false;
                    break;
                default:
                    System.out.println("Lựa chọn bạn nhập không tồn tại");
            }
        } while (temp);
    }

    private static void displayMenuAdd() {
        System.out.println("Bạn muốn thêm phương tiện nào" +
                "\n 1. Thêm xe tải" +
                "\n 2. Thêm ô tô" +
                "\n 3. Thêm xe máy");
        System.out.print("Mời bạn lựa chọn: ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                System.out.println("Thêm mới xe tải");
                trunksService.add();
                break;
            case 2:
                System.out.println("Thêm mới xe oto");
                carService.add();
                break;
            case 3:
                System.out.println("Thêm mới xe máy");
                bikeService.add();
                break;
            default:
                System.out.println("Lựa chọn của bạn không có");
        }
    }

    private static void displayMenuTransport() {
        System.out.println("Bạn muốn hiển thị phương tiện nào" +
                "\n 1. Hiển thị xe tải" +
                "\n 2. Hiển thị ô tô" +
                "\n 3. Hiển thị xe máy");
        System.out.print("Mời bạn lựa chọn: ");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                System.out.println("Danh sách xe tải");
                trunksService.display();
                break;
            case 2:
                System.out.println("Danh sách xe oto");
                carService.display();
                break;
            case 3:
                System.out.println("Danh sách xe máy");
                bikeService.display();
                break;
            default:
                System.out.println("Lựa chọn của bạn không có");
        }
    }
    private static void deleteTransport() {
        System.out.print("Nhập biển kiểm soát cần xoá: ");
        String seaOfControl = scanner.nextLine();
        if(removeAndSearch.checkSeaOfControl(seaOfControl) != null) {
            System.out.println("Bạn có muốn xoá không?" +
                    "\n Yes" +
                    "\n No");
            String choose = scanner.nextLine().toLowerCase();
            switch (choose) {
                case "yes":
                    System.out.println(removeAndSearch.removeBySeaOfControl(seaOfControl));
                    break;
                case "no":
                    return;
                default:
                    System.out.println("Bạn lựa chọn không đúng chức năng");
            }
        } else {
            System.out.println("Biển kiểm soát không tồn tại");
        }
    }
    private static void searchBySeaOfControl() {
        System.out.print("Nhập bản kiểm soát cần tìm: ");
        String seaOfControl = scanner.nextLine();
        removeAndSearch.searchBySeaOfControl(seaOfControl);
    }
}
