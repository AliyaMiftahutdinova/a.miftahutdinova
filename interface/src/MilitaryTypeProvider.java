package ru.kpfu.itis.group11408.Miftahutdinova.interface;

public interface MilitaryTypeProvider {

    final static int MILITARY = 1;
    final static int PACIFIC = 0;

    public int getMilitaryType(boolean type);

}
