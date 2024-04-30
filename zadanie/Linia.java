package zadanie;

public class Linia {
    private int dlugoscTrasy;
    private Przystanek[] trasa;
    private int[] trasaCzasDojazdu;

    public Linia(Przystanek[] trasa, int[] trasaCzasDojazdu, int dlugoscTrasy) {
        this.trasa = trasa;
        this.dlugoscTrasy = dlugoscTrasy;
        this.trasaCzasDojazdu = trasaCzasDojazdu;
    }
}
