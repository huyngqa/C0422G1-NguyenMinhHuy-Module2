package common;

import model.Person;
import util.Read;

import java.util.List;

public class CheckException {
    public static void checkExistPersonById(String personId, String pathFile)  {
        List<Person> people = Read.readPersonToCSV(pathFile);
        if(people.isEmpty()) {
            return;
        }
        boolean flag = false;
        for (Person person: people) {
            if (person.getPersonId().equals(personId)) {
                flag = true;
                break;
            }
        }
        if(flag) {
            try {
                throw new DuplicatePersonalRecordException("Mã định danh đã tồn tại.");
            } catch (DuplicatePersonalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
