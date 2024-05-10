package zadanie;

public abstract class Pojazd {
    protected final int numerBoczny;
    protected final Linia linia;
    protected Pasazer[] listaPasazerow;
    protected int indeksWstawieniaPasazera;

    public Pojazd(int numerBoczny, Linia linia) {
        this.numerBoczny = numerBoczny;
        this.linia = linia;
        this.indeksWstawieniaPasazera = 0;
    }

    public int getNumerBoczny() {
        return numerBoczny;
    }

    public Pasazer[] getListaPasazerow() {
        return listaPasazerow;
    }

    public int getIndeksWstawieniaPasazera() {
        return indeksWstawieniaPasazera;
    }

    public Linia getLinia() {
        return linia;
    }

    protected int wolneMiejscaWPojezdzie() {
        return listaPasazerow.length - indeksWstawieniaPasazera;
    }

    @Override
    public String toString() {
        return "Pojazd linii: " + linia.getNumerLinii() +
                " o numerze " + numerBoczny;
    }
}
