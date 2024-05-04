package zadanie;

import main.Symulacja;

public abstract class Pojazd {

    private int numerBoczny;
    private Linia linia;
    protected Pasazer[] listaPasazerow;
    protected int indeksWstawienia;

    public Pojazd(int numerBoczny, Linia linia) {
        this.numerBoczny = numerBoczny;
        this.linia = linia;
        this.indeksWstawienia = 0;
    }

    public int getNumerBoczny() {
        return numerBoczny;
    }

    public Linia getLinia() {
        return linia;
    }
}
