package zdarzenia;

import zadanie.Pasazer;
import zadanie.Przystanek;

public class PowrotDoDomu extends Zdarzenie {
    private final Przystanek naJakiPrzystanek;
    private final Pasazer ktoPrzyszedl;

    public PowrotDoDomu(int dzien, int minuta, Przystanek naJakiPrzystanek, Pasazer ktoPrzyszedl) {
        super(dzien, minuta);
        this.naJakiPrzystanek = naJakiPrzystanek;
        this.ktoPrzyszedl = ktoPrzyszedl;
    }

    @Override
    public void przetworzZdarzenie() {}

    @Override
    public String toString() {
        return super.toString() + "Pasażer " + ktoPrzyszedl.getIndeksPasazera() +
                " wrócił do domu z przystanku " + naJakiPrzystanek.getNazwa() +
                " z powodu braku miejsc.";
    }
}
