package ss12_java_collection_framwework.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestAge {
    public static void main(String[] args) {
        Student2 student = new Student2("Kien", 30, "HT");
        Student2 student1 = new Student2("Nam", 26, "HN");
        Student2 student2 = new Student2("Anh", 38, "HT" );
        Student2 student3 = new Student2("Tung", 38, "HT" );

        List<Student2> lists = new ArrayList<>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for(Student2 st : lists){
            System.out.println(st.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists,ageComparator);
        System.out.println("So sanh theo tuoi:");
        for(Student2 st : lists){
            System.out.println(st.toString());
        }
    }
}
