package ru.kpfu.itis.group11408.Miftahutdinova.interface;

public class AircraftCarrier extends Ship implements MilitaryTypeProvider{

    private String planes;

    public AircraftCarrier(double speed, String measure, String brand, double weight,
                      double deadweight, double displacement, int planes){
        setSpeed(speed, measure);
        setBrand(brand);
        setWeight(weight);
        setDeadweight(deadweight);
        setDisplacement(displacement);
        maxPlanes(planes);
    }

    private void maxPlanes(int planes){
        this.planes = ("Max amount planes: " + planes + "." + "\n");
    }

    private String amountPlanes(){
        return planes;
    }

    public int getMilitaryType(boolean type){
        if(type){
            return MILITARY;
        }
        return PACIFIC;
    }

    public static void main(String [] args ){
        AircraftCarrier Nimitz = new AircraftCarrier(30, "knot", "Nimitz", 70000, 20000, 106000, 85);
        System.out.print(Nimitz.getCharacteristicsShip());
        System.out.print(Nimitz.getCharacteristicsTransport());
        System.out.print(Nimitz.amountPlanes());
        System.out.print(Nimitz.militaryType(Nimitz.getMilitaryType(true)));
    }
}
