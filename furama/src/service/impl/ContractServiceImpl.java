package service.impl;

import common.Random;
import model.Booking;
import model.Contract;
import model.Customer;
import model.Facility;
import service.ContractService;
import util.ReadFurama;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContractServiceImpl implements ContractService {
    private final String PATH_FILE_BOOKING = "furama/src/data/booking.csv";
    private final String PATH_FILE_CUSTOMER = "furama/src/data/customer.csv";
    private final String PATH_FILE_CONTRACT = "furama/src/data/contract.csv";

    @Override
    public void add() {
        Set<Booking> bookingSet = ReadFurama.readBookingToCSV(PATH_FILE_BOOKING);
        if (bookingSet.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn chọn chức năng thêm mới dịch vụ!");
            return;
        }
        List<Customer> customers = ReadFurama.readCustomerToCSV(PATH_FILE_CUSTOMER);
        if (customers.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn chọn chức năng thêm mới khách hàng!");
            return;
        }
        List<Contract> contracts = ReadFurama.readContractToCSV(PATH_FILE_CONTRACT);
        String idContract = "CT-" + Random.getRandom();
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getBookingId().equals(idContract)) {
                idContract = "BK-" + Random.getRandom();
                i = 0;
            }
        }


    }

    @Override
    public void display() {

    }

    @Override
    public void editById(String id) {

    }
}
