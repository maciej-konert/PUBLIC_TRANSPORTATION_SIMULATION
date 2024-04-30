package zadanie;

public abstract class Pojazd {

    private int numerBoczny;
    private Linia linia;
    protected Pasazer[] listaPasazerow;
    protected int indeksWstawienia;

    public Pojazd(int numerBoczny, Linia linia) {
        this.numerBoczny = numerBoczny;
        this.linia = linia;
        this.listaPasazerow = new Pasazer[Symulacja.pojemnoscTramwaju];
        this.indeksWstawienia = 0;
    }
}
