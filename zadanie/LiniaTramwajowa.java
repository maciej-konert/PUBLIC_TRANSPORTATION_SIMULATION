package zadanie;

public class LiniaTramwajowa extends Linia {

    private Tramwaj[] tramwaje;

    public LiniaTramwajowa(Przystanek[] trasa, int[] trasaCzasDojazdu, int nrLinii) {
        super(trasa, trasaCzasDojazdu, nrLinii);
    }

    public Tramwaj[] getTramwaje() {
        return tramwaje;
    }

    public void setTramwaje(Tramwaj[] tramwaje) {
        this.tramwaje = tramwaje;
    }
}
