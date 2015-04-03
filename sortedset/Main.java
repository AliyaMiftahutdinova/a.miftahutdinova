package ru.kpfu.itis.group408.Miftahutdinova.Set;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    MySet<String> set = new MySet<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            set.add(sc.next());
        }
        boolean mall = true;
        while (mall){
            System.out.println(set.iterator().next());
            if (!set.iterator().hasNext())
                mall = false;
        }
    }
}
