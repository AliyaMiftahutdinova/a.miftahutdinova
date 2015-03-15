package ru.kpfu.itis.group11408.Miftahutdinova.interface;

public class Ship extends Transport{

    private String deadweight;
    private String displacement;

    protected void setDeadweight(double deadweight){
        this.deadweight = ("Deadweight: " + deadweight + ".");
    }

    protected void setDisplacement(double displacement){
        this.displacement = ("Displacement: " + displacement + " ton.");
    }

    protected String getCharacteristicsShip(){
        return (deadweight + "\n" + displacement + "\n");
    }

}
