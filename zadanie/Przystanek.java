package zadanie;

public class Przystanek {
    private String nazwa;
    private int pojemnosc;
    private int indeksOstatniejOsoby;
    private Pasazer[] listaCzekajacych;

    public Przystanek(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
}
