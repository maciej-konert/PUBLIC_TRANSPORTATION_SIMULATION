package zdarzenia;

public abstract class Zdarzenie {
    protected int dzien;
    protected int minuta;

    public Zdarzenie(int dzien, int minuta) {
        this.dzien = dzien;
        this.minuta = minuta;
    }

    public int getMinuta() {
        return minuta;
    }

    private static String zamienNaGodzine(int minuty) {
        int godzina = minuty / 60;
        String zeroGodzina = ((godzina < 10) ? "0" : "");
        String zeroMinuta = ((minuty - (godzina * 60) < 10) ? "0" : "");
        return zeroGodzina + godzina + ":" + zeroMinuta + (minuty - (godzina * 60));
    }

    public abstract void przetworzZdarzenie();

    @Override
    public String toString() {
        return dzien + ", " + zamienNaGodzine(minuta) + ": ";
    }
}
