package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class UI {

    private final Scanner lukija;
    private final Logiikka logiikka;

    public UI(Scanner lukija, Logiikka logiikka) {
        this.lukija = lukija;
        this.logiikka = logiikka;
    }

    public void kaynnista() {
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        menu();
    }

    public void menu() {
        while (true) {
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
            System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
            String luettu = lukija.nextLine();

            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                tulosta("A");
            } else if (luettu.equalsIgnoreCase("B")) {
                tulosta("B");
            } else if (luettu.equalsIgnoreCase("C")) {
                tulosta("C");
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento!");
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
        }

    }

    private void lisaa() {
        String joukko = kysyJoukko();
        int luku = kysyLuku();
        logiikka.lisaa(joukko, luku);
    }

    private int kysyLuku() {
        System.out.println("Anna luku:");
        return lukija.nextInt();
    }

    private String kysyJoukko() {
        System.out.println("Anna joukko:");
        return lukija.nextLine();
    }

    private void poista() {
        String joukko = kysyJoukko();
        int luku = kysyLuku();
        logiikka.poista(joukko, luku);
    }

    private void kuuluu() {
        String joukko = kysyJoukko();
        int luku = kysyLuku();
        logiikka.kuuluu(joukko, luku);
    }

    private void yhdiste() {
        String joukko1 = kysyJoukko();
        String joukko2 = kysyJoukko();
        logiikka.yhdiste(joukko1, joukko2);
    }

    private void leikkaus() {
        String joukko1 = kysyJoukko();
        String joukko2 = kysyJoukko();
        logiikka.leikkaus(joukko1, joukko2);
    }

    private void erotus() {
        String joukko1 = kysyJoukko();
        String joukko2 = kysyJoukko();
        logiikka.erotus(joukko1, joukko2);
    }

    private void tulosta(String joukko) {
        logiikka.tulosta(joukko);
    }
}
