package ru.kpfu.itis.group11408.Miftahutdinova.comparator;

import java.lang.Math;
import java.lang.String;
import java.lang.System;
import java.util.Scanner;

public class Student {
    private int grade;
    private int year;
    private String name;

    public void setGrade(int grade){
        this.grade = grade;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getGrade(){
        return grade;
    }

    public int getYear(){
        return year;
    }

    public String getName(){
        return name;
    }

    public static void print(Student [] array, String sortname){
        System.out.println("======" + sortname + "======");
        for(int i = 0; i < array.length; i++){
            System.out.println("Name: " + array[i].name + "\n" + "Age: " + array[i].year + "\n" + "Grade:" + array[i].grade);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student [] array = new Student[7];
        for(int i = 0; i < array.length; i++){
            array[i] = new Student();
            array[i].setGrade(((int) (Math.random() * 100)));
            array[i].setName(sc.nextLine());
            array[i].setYear(((int) ((Math.random() * 6) + 18)));
        }
        StudentHelper st = new StudentHelper();
        print(st.getGradeComparator(array), "Sort by grade");
        print(st.getYearComparator(array), "Sort by age");
        print(st.getNameComparator(array), "Sort by name");
    }

}
