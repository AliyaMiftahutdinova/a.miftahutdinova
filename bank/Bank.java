package ru.kpfu.itis.group11408.Miftahutdinova.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank extends Thread{

    private List<Client> clientList;
    private double cash;
    private long id;
    private Bankomat first;
    private Bankomat second;

    public Bank(){
        this.cash = 5000000;
        this.clientList = new ArrayList<>();
        this.id = 0;
        this.first = new Bankomat(40100, this);
        this.second = new Bankomat(this);
    }

    public Bank(double cash){
        this.cash = cash;
        this.clientList = new ArrayList<>();
        this.id = 0;
        this.first = new Bankomat(40100, this);
        this.second = new Bankomat(30050, this);
    }

    public void addClient(double cash){
        Client newClient = new Client(cash, id++);
        clientList.add(newClient);
        switch ((int)(Math.random() * 2)){
            case 0:
                first.addToQueue(newClient);
                break;
            case 1:
                second.addToQueue(newClient);
                break;
        }
    }

    public void removeClient(Client client){
        for (int i = 0; i < clientList.size(); i++) {
            if(client.getId() == clientList.get(i).getId()) clientList.remove(i);
        }
    }

    public boolean hasClient(Client client){
        for (Client ClientList : clientList) if (client.getId() == ClientList.getId()) return true;
        return false;
    }

    public synchronized double getMoney() {
        if ((this.cash - 40000) > 0) {
            this.cash -= 40000;
            return 40000;
        }else {
            stop();
            return 0;
        }
    }

    public synchronized void addMoney(double cash){
        this.cash += cash;
    }

    public void startBankomats(){
        this.first.start();
        this.second.start();
    }

    public void stopRun(){
        this.first.interrupt();
        this.second.interrupt();
    }

    public void printCash(){
        System.out.println(this.cash);
    }

    @Override
    public void run() {
        startBankomats();
        while (!first.isSleep() && !second.isSleep()); //printCash();
        stopRun();
        printCash();
    }
}
