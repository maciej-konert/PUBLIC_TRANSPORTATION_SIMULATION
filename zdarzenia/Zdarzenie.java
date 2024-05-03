package zdarzenia;

public abstract class Zdarzenie implements Comparable<Zdarzenie> {

    protected int dzien;
    protected int minuta;

    public Zdarzenie(int dzien, int minuta) {
        this.dzien = dzien;
        this.minuta = minuta;
    }

    private static String zamienNaGodzine(int minuty) {
        int godzina = minuty / 60;
        String zeroGodzina = ((godzina < 10) ? "0" : "");
        String zeroMinuta = ((minuty - (godzina * 60) < 10) ? "0" : "");
        return zeroGodzina + godzina + ":" + zeroMinuta + (minuty - (godzina * 60));
    }

    @Override
    public String toString() {
        return dzien + ", " + zamienNaGodzine(minuta) + ": ";
    }

    @Override
    public int compareTo(Zdarzenie zdarzenie) {
        if (this.dzien == zdarzenie.dzien)
            return this.minuta - zdarzenie.minuta;
        else
            return this.dzien - zdarzenie.dzien;
    }
}
