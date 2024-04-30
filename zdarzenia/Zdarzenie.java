package zdarzenia;

public abstract class Zdarzenie {

    protected int dzien;
    protected int minuta;

    public Zdarzenie(int dzien, int minuta) {
        this.dzien = dzien;
        this.minuta = minuta;
    }
}
