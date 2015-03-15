package ru.kpfu.itis.group11408.Miftahutdinova.interface;

public class Fighter extends Plane implements MilitaryTypeProvider{

    public Fighter(double speed, String measure, String brand, double weight, double streamlining, double wingspan){
        setSpeed(speed, measure);
        setWeight(weight);
        setBrand(brand);
        setWingspan(wingspan);
        setStreamlining(streamlining);
    }

    public int getMilitaryType(boolean type){
        if(type){
            return MILITARY;
        }
        return PACIFIC;
    }

    public static void main(String [] args){
        Fighter F17 = new Fighter(993, "km/h", "Nighthawk", 13.380, 5, 13.2);
        System.out.print(F17.getCharacteristicsTransport());
        System.out.print(F17.streamlining());
        System.out.print(F17.wingspan());
        System.out.print(F17.militaryType(F17.getMilitaryType(true)));
    }

}
