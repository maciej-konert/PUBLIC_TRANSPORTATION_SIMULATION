package zadanie;

import main.Symulacja;

public class Tramwaj extends Pojazd {

    public Tramwaj(int numerBoczny, Linia linia) {
        super(numerBoczny, linia);
        this.listaPasazerow = new Pasazer[Symulacja.getPojemnoscTramwaju()];
    }
}
