package ru.kpfu.itis.group11408.Miftahutdinova.bank;

import java.util.LinkedList;
import java.util.Queue;

public class Bankomat extends Thread{

    private Queue<Client> queue;
    private double cash;
    private Bank bank;
    private boolean sleep;

    public Bankomat(Bank bank){
        this.queue = new LinkedList<>();
        this.cash = 20000;
        this.bank = bank;
        this.sleep = false;
    }

    public Bankomat(double cash, Bank bank){
        this.queue = new LinkedList<>();
        this.cash = cash;
        this.bank = bank;
        this.sleep = false;
    }

    public void addToQueue(Client client){
        queue.add(client);
    }

    public void putMoney(Client client){
        double sum = client.putMoney();
        cash += sum;
        if(this.cash > 50000) cash -= 20000;
        bank.addMoney(20000);
    }

    public void getMoney(Client client){
        double sum = client.getMoney();
        if(sum > this.cash) cash += bank.getMoney();
        cash -= sum;
    }

    public boolean isSleep(){
        return sleep;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            sleep = false;
            Client client = queue.poll();
            if(bank.hasClient(client)) {
                int[] actions = client.getAction();
                for (int i : actions) {
                    switch (actions[i]) {
                        case 0:
                            putMoney(client);
                            break;
                        case 1:
                            getMoney(client);
                            break;
                    }
                }
            }
            while (queue.isEmpty()) {
                try {
                    sleep = true;
                    sleep(5000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        }
    }
}
