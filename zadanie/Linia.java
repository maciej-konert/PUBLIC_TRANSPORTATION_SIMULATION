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

    public void setTrasa(Przystanek[] trasa) {
        this.trasa = trasa;
    }

    public void setTrasaCzasDojazdu(int[] trasaCzasDojazdu) {
        this.trasaCzasDojazdu = trasaCzasDojazdu;
    }

    public int[] getTrasaCzasDojazdu() {
        return trasaCzasDojazdu;
    }

}
