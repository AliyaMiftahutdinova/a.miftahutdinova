package ru.kpfu.itis.group11408.Miftahutdinova.stack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Analiz primer = new Analiz(new Stack<Character>());
        System.out.println("Write the string");
        if (primer.check(sc.next())){
            System.out.println("It's okay");
        } else {
            System.out.println("Incorrect");
        }
    }
}