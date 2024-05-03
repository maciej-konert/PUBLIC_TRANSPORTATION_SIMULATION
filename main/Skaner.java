package main;

import zadanie.LiniaTramwajowa;
import zadanie.Pasazer;
import zadanie.Przystanek;
import zadanie.Tramwaj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Skaner {

    private static Scanner sc = new Scanner(System.in);

    private static void wczytajPrzystanki() {
        int ilePrzystankow = Integer.parseInt(sc.nextLine());
        Przystanek[] przystanki = new Przystanek[ilePrzystankow];

        for (int i = 0; i < ilePrzystankow; i++) {
            przystanki[i] = new Przystanek(sc.nextLine());
        }

        Symulacja.setPrzystanki(przystanki);
    }

    private static void stworzPasazerow() {
         int ilePasazerow = Integer.parseInt(sc.nextLine());
         Pasazer[] pasazerowie = new Pasazer[ilePasazerow];

         for (int i = 0; i < ilePasazerow; i++) {
             pasazerowie[i] = new Pasazer(Losowanie.wylosujPrzystanek(), i + 1);
         }

         Symulacja.setPasazerowie(pasazerowie);
    }

    private static void wczytajLinieTramwajowe() {
        int ileLinii = Integer.parseInt(sc.nextLine()), nrTramwaju = 0;
        LiniaTramwajowa[] linie = new LiniaTramwajowa[ileLinii];

        for (int i = 0; i < ileLinii; i++) {
            int liczbaTramwajow = Integer.parseInt(sc.next());
            int dlugoscTrasy = Integer.parseInt(sc.next());
            Tramwaj[] tramwaje = new Tramwaj[liczbaTramwajow];
            Przystanek[] przystanki = new Przystanek[dlugoscTrasy];
            int[] trasaCzasDojazdu = new int[dlugoscTrasy];

            for (int j = 0; j < dlugoscTrasy; j++) {
                String nazwaPrzystanku = sc.next();
                int czasDojazdu = Integer.parseInt(sc.next());

                for (Przystanek p : Symulacja.getPrzystanki()) {
                    if (p.getNazwa().equals(nazwaPrzystanku)) {
                        przystanki[j] = p;
                    }
                }

                trasaCzasDojazdu[j] = czasDojazdu;
            }
            linie[i] = new LiniaTramwajowa(przystanki, trasaCzasDojazdu, i);

            for (int k = 0; k < liczbaTramwajow; k++) {
                tramwaje[k] = new Tramwaj(nrTramwaju, linie[i]);
                nrTramwaju++;
            }
            linie[i].setTramwaje(tramwaje);
            sc.nextLine();
        }
        Symulacja.setLinie(linie);
    }

    private static void wypiszWczytane() {
        System.out.println(Symulacja.getDniSymulacji());
        System.out.println(Symulacja.getPojemnoscPrzystanku());

        Przystanek[] przystanki = Symulacja.getPrzystanki();
        System.out.println(przystanki.length);
        for (Przystanek przystanek : przystanki) {
            System.out.println(przystanek.getNazwa());
        }

        System.out.println(Symulacja.getPasazerowie().length);
        System.out.println(Symulacja.getPojemnoscTramwaju());

        LiniaTramwajowa[] linieTramwajowe = Symulacja.getLinieTramwajowe();
        System.out.println(linieTramwajowe.length);
        for (LiniaTramwajowa linia : linieTramwajowe) {
            System.out.print(linia.getTramwaje().length + " ");
            System.out.print(linia.getTrasa().length + " ");

            for (int j = 0; j < linia.getTrasa().length; j++) {
                System.out.print(linia.getTrasa()[j].getNazwa() + " ");
                System.out.print(linia.getTrasaCzasDojazdu()[j] + " ");
            }
            System.out.println();
        }


    }

    public static void wczytajDane() {
        int dniSymulacji = Integer.parseInt(sc.nextLine());
        int pojemnoscPrzystanku = Integer.parseInt(sc.nextLine());

        wczytajPrzystanki();
        stworzPasazerow();

        int pojemnoscTramwajow = Integer.parseInt(sc.nextLine());
        Symulacja.setSymulacjaInts(dniSymulacji, pojemnoscPrzystanku, pojemnoscTramwajow);

        wczytajLinieTramwajowe();

        wypiszWczytane();
    }
}
