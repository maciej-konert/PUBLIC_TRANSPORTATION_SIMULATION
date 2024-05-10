package main;

import zadanie.Przystanek;
import zadanie.Tramwaj;

import java.util.Random;

public class Losowanie {
    private static final int godzinaPasazerOD = 6;
    private static final int getGodzinaPasazerDO = 12;

    public static int losuj(int dolna, int gorna) {
        Random r = new Random();
        return r.nextInt(dolna, gorna + 1);
    }

    /**
     * @return Minuta wyjscia liczona od polnocy.
     */
    public static int kiedyWyjscZDomu() {
        return losuj(godzinaPasazerOD * 60, getGodzinaPasazerDO * 60);
    }

    public static Przystanek naKtoryPrzystanek(Tramwaj tramwaj) {
        int dlugoscTrasy = tramwaj.getLinia().getTrasa().length,
                jakDalekoJestT = tramwaj.getIlePrzejechalPrzystankow() % (dlugoscTrasy * 2);
        Przystanek[] trasa = tramwaj.getLinia().getTrasa();

        if (tramwaj.getCzyStartowalZPoczatku())
            if (jakDalekoJestT > dlugoscTrasy)
                return trasa[losuj(0, 2 * dlugoscTrasy - jakDalekoJestT - 1)];
            else
                return trasa[losuj(jakDalekoJestT, dlugoscTrasy - 1)];
        else
            if (jakDalekoJestT > dlugoscTrasy)
                return trasa[losuj(2 * dlugoscTrasy - jakDalekoJestT, dlugoscTrasy - 1)];
            else
                return trasa[losuj(0, dlugoscTrasy - jakDalekoJestT - 1)];

    }

    public static Przystanek wylosujPrzystanek() {
        int len = Symulacja.getPrzystanki().length;
        return Symulacja.getPrzystanki()[losuj(0, len - 1)];
    }
}

