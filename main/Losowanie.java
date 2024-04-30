package main;

import java.util.Random;

public class Losowanie {
    public static final int godzinaPasazerOD = 6;
    public static final int getGodzinaPasazerDO = 12;

    public static int losuj(int dolna, int gorna) {
        Random r = new Random();
        return r.nextInt(dolna, gorna + 1);
    }

    /**
     * @return minuta wyjscia liczona od godziny mozliwego wyjscia pasazera.
     */
    public static int kiedyWyjscZDomu() {

    }
}
