package util;

import model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ReadFurama {
    private static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }


    public static Map<Customer,Integer> readCustomerToCSV(String pathFile) {
        Map<Customer,Integer> customers = new LinkedHashMap<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (int i = 0; i < strings.size(); i++) {
            arr = strings.get(i).split(",");
            customers.put(new Customer(arr[0], arr[1], LocalDate.parse(arr[2]), arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]),Integer.parseInt(arr[9]));
        }
        return customers;
    }

    public static List<Employee> readEmployeeToCSV(String pathFile) {
        List<Employee> employees = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (int i = 0; i < strings.size(); i++) {
            arr = strings.get(i).split(",");
            employees.add(new Employee(arr[0], arr[1], LocalDate.parse(arr[2]), arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], Integer.parseInt(arr[9])));
        }
        return employees;
    }

    public static Map<Facility, Integer> readFacilityToCSV(String pathFile) {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (String str : strings) {
            arr = str.split(",");
            if (arr[0].contains("VL")) {
                facilityMap.put(new Villa(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], Double.parseDouble(arr[7]), Integer.parseInt(arr[8])), Integer.parseInt(arr[9]));
            } else if (arr[0].contains("HO")) {
                facilityMap.put(new House(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], Byte.parseByte(arr[7])), Integer.parseInt(arr[8]));
            } else {
                facilityMap.put(new Room(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6]), Integer.parseInt(arr[7]));
            }
        }
        return facilityMap;
    }

    public static Set<Booking> readBookingToCSV(String pathFile) {
        Set<Booking> bookings = new TreeSet<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        Map<Customer, Integer> customers = readCustomerToCSV("furama/src/data/customer.csv");
        Map<Facility, Integer> facilityMap = readFacilityToCSV("furama/src/data/facility.csv");
        Set<Facility> set = facilityMap.keySet();
        Customer customer = null;
        Facility facility = null;
        for (String str : strings) {
            arr = str.split(",");
            for (Customer c : customers.keySet()) {
                if (c.getPersonId().equals(arr[3]))
                    customer = c;
            }
            for (Facility f : set) {
                if (f.getNameService().equals(arr[4]))
                    facility = f;
            }
            bookings.add(new Booking(arr[0], LocalDate.parse(arr[1]), LocalDate.parse(arr[2]), customer, facility, Integer.parseInt(arr[5])));
        }
        return bookings;
    }

    public static List<Contract> readContractToCSV(String pathFile) {
        List<Contract> contracts = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        Set<Booking> bookings = readBookingToCSV("furama/src/data/booking.csv");
        Booking booking = null;
        for (String str : strings) {
            arr = str.split(",");
            for (Booking b : bookings) {
                if (b.getBookingId().equals(arr[1])) {
                    booking = b;
                }
            }
            contracts.add(new Contract(arr[0], booking, Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), booking));
        }
        return contracts;
    }
}
