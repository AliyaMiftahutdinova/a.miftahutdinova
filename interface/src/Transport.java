package ru.kpfu.itis.group11408.Miftahutdinova.interface;

public class Transport{

    private String speed;
    private String brand;
    private String weight;

    protected void setSpeed(double speed, String measure){
        this.speed = ("Max speed: " + speed + " " + measure + ".");
    }

    protected void setBrand(String brand){
        this.brand = ("Class: " + brand + ".");
    }

    protected void setWeight(double weight){
        this.weight = ("Weight: " + weight + ".");
    }

    protected String getCharacteristicsTransport(){
        return (speed + "\n" + brand + "\n" + weight + "\n");
    }

    protected String militaryType(int type){
        if(type > 0){
           return ("Type: Military");
        }
        return ("Type: Pacific");
    }
}