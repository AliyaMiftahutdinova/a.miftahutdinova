package ru.kpfu.itis.group11408.Miftahutdinova.bank;

import java.util.Random;

public class Client {

    private double cash;
    private long id;
    private int[] action;

    public Client(long id){
        this.cash = 10000;
        this.id = id;
        this.action = new int[2];
        for (int i : action) if (Math.random() > 0.5) action[i] = 1;
    }

    public Client(double cash, long id){
        this.cash = cash;
        this.id = id;
        this.action = new int[2];
        for (int i : action) if (Math.random() > 0.5) action[i] = 1;
    }

    public int[] getAction() {
        return action;
    }

    public double getMoney(){
        double cash = createSum();
        this.cash += cash;
        return cash;
    }

    public double putMoney(){
        double cash = createSum();
        if(cash <= this.cash) {
            this.cash -= cash;
            return cash;
        }else return 0;
    }

    public long getId() {
        return id;
    }

    private double createSum(){
        Random random = new Random();
        switch (random.nextInt(6)){
            case 0:
                return 100;
            case 1:
                return 500;
            case 2:
                return 700;
            case 3:
                return 800;
            case 4:
                return 1000;
            case 5:
                return 1500;
            default:
                return 0;
        }
    }
}
