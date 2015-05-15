package ru.kpfu.itis.group11408.Miftahutdinova.bank;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(100000);
        for (int i = 0; i < 30; i++) bank.addClient(i * 1000);
        bank.start();
    }
}
