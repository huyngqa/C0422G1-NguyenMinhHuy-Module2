package service.impl;

import model.Booking;
import model.Customer;
import service.PromotionService;
import util.ReadFurama;
import common.Random;
import util.WriteFurama;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    private final String PATH_FILE_BOOKING = "furama/src/data/booking.csv";
    private final String PATH_FILE_CUSTOMER = "furama/src/data/customer.csv";

    @Override
    public void displayCustomerTakePromotion() {
        Set<Booking> set = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
        if(set.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        Set<String> list = new LinkedHashSet<>();
        for (Booking booking : set) {
            if(booking.getStatus() == 1) {
                list.add(booking.getCustomerId().getPersonId());
                booking.setStatus(2);
            }
        }
        Map<Customer, Integer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        List<Integer> listPromotion = randomPromotion(list.size());
        Stack<Integer> stack = new Stack<>();
        for (Integer integer : listPromotion) {
            stack.push(integer);
        }
        System.out.println("Danh sách khách hàng đã nhận được voucher!!!");
        for (String str : list) {
            for (Customer customer : customers.keySet()) {
                if (str.equals(customer.getPersonId())) {
                    customers.replace(customer, stack.pop());
                    System.out.println(customer);
                    System.out.println("Nhận được thẻ giảm giá: " + customers.get(customer) +  "%");
                }
            }
        }
        WriteFurama.writeCustomerToCSV(customers, PATH_FILE_CUSTOMER, false);
        WriteFurama.writeBookingToCSV(set, PATH_FILE_BOOKING, false);
    }

    @Override
    public void displayCustomerUsedFacility() {
        Set<Booking> set = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
        if(set.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
        Set<String> list = new LinkedHashSet<>();
        for (Booking booking : set) {
            list.add(booking.getCustomerId().getPersonId());
        }
        Map<Customer, Integer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        System.out.println("Danh sách khách hàng đã sử dụng dịch vụ");
        for (String str : list) {
            for (Customer customer : customers.keySet()) {
                if (str.equals(customer.getPersonId())) {
                    System.out.println(customer);
                }
            }
        }
    }

    private List<Integer> randomPromotion(int countCustomer) {
        List<Integer> listPromotion = new ArrayList<>();
        for (int i = 0; i < countCustomer; i++) {
            listPromotion.add(Random.randomPromotion());
        }
        Collections.sort(listPromotion);
        return listPromotion;
    }
}
