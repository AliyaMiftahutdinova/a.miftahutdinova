package ru.kpfu.itis.group11408.Miftahutdinova.interface;

public class CruiseShip extends Ship implements MilitaryTypeProvider{

    private String passengers;

    public CruiseShip(double speed, String measure, String brand, double weight,
                      double deadweight, double displacement, int passengers){
        setSpeed(speed, measure);
        setBrand(brand);
        setWeight(weight);
        setDeadweight(deadweight);
        setDisplacement(displacement);
        maxPassengers(passengers);
    }

    private void maxPassengers(int passengers){
        this.passengers = ("Max passengers: " + passengers + "." + "\n");
    }

    private String amountPassengers(){
        return passengers;
    }

    public int getMilitaryType(boolean type){
        if(type){
            return MILITARY;
        }
        return PACIFIC;
    }

    public static void main(String [] args){
        CruiseShip Titanic = new CruiseShip(23, "knot", "Olympic", 46328, 8000 ,52310, 2556);
        System.out.print(Titanic.getCharacteristicsTransport());
        System.out.print(Titanic.getCharacteristicsShip());
        System.out.print(Titanic.amountPassengers());
        System.out.print(Titanic.militaryType(Titanic.getMilitaryType(false)));
    }
}
