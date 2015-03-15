package ru.kpfu.itis.group11408.Miftahutdinova.interface;

public class Plane extends Transport{

    private String streamlining;
    private String wingspan;

    protected void setStreamlining(double streamlining){
        this.streamlining = ("Streamlining: " + streamlining + ".");
    }

    protected String streamlining(){
        return (streamlining + "\n");
    }

    protected void setWingspan(double wingspan) {
        this.wingspan = ("Wingspan:  " + wingspan + ".");
    }

    protected String wingspan() {
        return (wingspan + "\n");
    }


}
