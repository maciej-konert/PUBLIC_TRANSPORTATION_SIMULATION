package zadanie;

public class Linia {
    protected Przystanek[] trasa;
    protected int[] trasaCzasDojazdu;
    protected int numerLinii;

    public Linia(Przystanek[] trasa, int[] trasaCzasDojazdu, int numerLinii) {
        this.trasa = trasa;
        this.trasaCzasDojazdu = trasaCzasDojazdu;
        this.numerLinii = numerLinii;
    }

    public Przystanek[] getTrasa() {
        return trasa;
    }

    public int getNumerLinii() {
        return numerLinii;
    }

    public int[] getTrasaCzasDojazdu() {
        return trasaCzasDojazdu;
    }

    @Override
    public String toString() {
        return "Linia nr: " + numerLinii;
    }
}
