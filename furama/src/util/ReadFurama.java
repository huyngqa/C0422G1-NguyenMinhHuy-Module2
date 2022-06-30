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


    public static List<Customer> readCustomerToCSV(String pathFile) {
        List<Customer> customers = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        for (int i = 0; i < strings.size(); i++) {
            arr = strings.get(i).split(",");
            customers.add(new Customer(arr[0], arr[1], LocalDate.parse(arr[2]), arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]));
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
        String name = "";
        for (String str : strings) {
            arr = str.split(",");
            name = arr[0].substring(0, 4);
            if (name.contains("SVVL")) {
                facilityMap.put(new Villa(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], Double.parseDouble(arr[7]), Integer.parseInt(arr[8])), Integer.parseInt(arr[9]));
            } else if (name.contains("SVHO")) {
                facilityMap.put(new House(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], Byte.parseByte(arr[7])), Integer.parseInt(arr[8]));
            } else {
                facilityMap.put(new Room(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6]), Integer.parseInt(arr[7]));
            }
        }
        return facilityMap;
    }

    public static Set<Booking> readBookingToCSV(String pathFile) {
        Set<Booking> bookings = new TreeSet<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] arr;
        List<Customer> customers = readCustomerToCSV("furama/src/data/customer.csv");
        Map<Facility, Integer> facilityMap = readFacilityToCSV("furama/src/data/facility.csv");
        Set<Facility> set = facilityMap.keySet();
        Customer customer = null;
        Facility facility = null;
        for (String str : strings) {
            arr = str.split(",");
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getPersonId().equals(arr[3]))
                    customer = customers.get(i);
            }
            for (Facility f : set) {
                if (f.getFacilityId().equals(arr[4]))
                    facility = f;
            }
            bookings.add(new Booking(arr[0], LocalDate.parse(arr[1]), LocalDate.parse(arr[2]), customer, facility));
        }
        return bookings;
    }
}
