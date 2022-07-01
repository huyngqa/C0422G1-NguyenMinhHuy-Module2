package util;

import model.Booking;
import model.Customer;
import model.Employee;
import model.Facility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WriteFurama {
    private static void writeObjectToCSV(List<String> strings, String pathFile, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < strings.size(); i++) {
                bufferedWriter.write(strings.get(i));
                bufferedWriter.newLine();
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

    public static void writeCustomerToCSV(List<Customer> customers, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (Customer customer : customers) {
            strings.add(customer.getInformationToCSV());
        }
        writeObjectToCSV(strings, pathFile, append);
    }

    public static void writeEmployeeToCSV(List<Employee> employees, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (Employee employee : employees) {
            strings.add(employee.getInformationToCSV());
        }
        writeObjectToCSV(strings, pathFile, append);
    }

    public static void writeFacilityToCSV(Map<Facility, Integer> facilityMap, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        Set<Facility> set = facilityMap.keySet(); 
        for (Facility facility : set) {
            strings.add(facility.getInformationToCSV() + "," + facilityMap.get(facility));
        }
        writeObjectToCSV(strings, pathFile, append);
    }

    public static void writeBookingToCSV(Set<Booking> bookings, String pathFile, boolean append) {
        List<String> strings = new ArrayList<>();
        for (Booking booking : bookings) {
            strings.add(booking.getInformationToCSV());
        }
        writeObjectToCSV(strings, pathFile, append);
    }
}
