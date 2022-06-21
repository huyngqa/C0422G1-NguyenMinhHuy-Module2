package ss12_java_collection_framwework.practice;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student2> {

    @Override
    public int compare(Student2 o1, Student2 o2) {
        if(o1.getAge() > o2.getAge()){
            return 1;
        }else if(o1.getAge() == o2.getAge()){
            return 0;
        }else{
            return -1;
        }
    }
}
