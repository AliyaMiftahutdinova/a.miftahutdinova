package ru.kpfu.itis.group11408.Miftahutdinova.comparator;

import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Comparator;


public class StudentHelper {
    public Student [] getGradeComparator(Student [] array) {
        class StudentGrade implements Comparator<Student> {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getGrade() > o2.getGrade()){
                    return 1;
                }else if(o1.getGrade() < o2.getGrade()){
                    return -1;
                }else {
                    return 0;
                }
            }
        }
        Arrays.sort(array, new StudentGrade());
        return array;
    }
    public Student [] getYearComparator(Student [] array) {
        class StudentYear implements Comparator <Student> {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getYear() > o2.getYear()){
                    return 1;
                }else if(o1.getYear() < o2.getYear()){
                    return -1;
                }else {
                    return 0;
                }
            }
        }
        Arrays.sort(array, new StudentYear());
        return array;
    }
    public Student [] getNameComparator(Student [] array) {
        class StudentName implements Comparator<Student> {
            @Override
            public int compare(Student o1, Student o2) {
                String str1 = o1.getName(); 
                String str2 = o2.getName();
                return str1.compareTo(str2);
            }
        }
        Arrays.sort(array, new StudentName());
        return array;
    }
}