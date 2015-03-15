package ru.kpfu.itis.group11408.Miftahutdinova.interface;

public class Boing extends Plane implements MilitaryTypeProvider {

    public Boing(double speed, String measure, String brand, double weight, double streamlining, double wingspan){
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
        Boing Boing747 = new Boing(955, "km/h", "Boening", 163, 40, 59.6);
        System.out.print(Boing747.getCharacteristicsTransport());
        System.out.print(Boing747.streamlining());
        System.out.print(Boing747.wingspan());
        System.out.print(Boing747.militaryType(Boing747.getMilitaryType(false)));
    }

}
