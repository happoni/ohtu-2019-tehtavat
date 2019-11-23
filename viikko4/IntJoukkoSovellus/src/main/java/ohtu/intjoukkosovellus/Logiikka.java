package ohtu.intjoukkosovellus;

public class Logiikka {

    IntJoukko joukkoA, joukkoB, joukkoC, apujoukko;

    public Logiikka() {
        joukkoA = new IntJoukko();
        joukkoB = new IntJoukko();
        joukkoC = new IntJoukko();
        apujoukko = null;
    }

    public IntJoukko selvitaJoukko(String nimi) {
        if (nimi.equals("A")) {
            return joukkoA;
        } else if (nimi.equals("B")) {
            return joukkoB;
        } else if (nimi.equals("C")) {
            return joukkoC;
        }
        return null;
    }

    public boolean lisaa(String joukko, int luku) {
        return selvitaJoukko(joukko).lisaa(luku);
    }

    public boolean poista(String joukko, int luku) {
        return selvitaJoukko(joukko).poista(luku);
    }

    public boolean kuuluu(String joukko, int luku) {
        return selvitaJoukko(joukko).kuuluu(luku);
    }

    public IntJoukko yhdiste(String joukko1, String joukko2) {
        IntJoukko ekaJoukko = selvitaJoukko(joukko1);
        IntJoukko tokaJoukko = selvitaJoukko(joukko2);

        IntJoukko x = new IntJoukko();
        int[] aTaulu = ekaJoukko.toIntArray();
        int[] bTaulu = tokaJoukko.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        x.toString();
        return x;
    }

    public IntJoukko leikkaus(String joukko1, String joukko2) {
        IntJoukko ekaJoukko = selvitaJoukko(joukko1);
        IntJoukko tokaJoukko = selvitaJoukko(joukko2);

        IntJoukko y = new IntJoukko();
        int[] aTaulu = ekaJoukko.toIntArray();
        int[] bTaulu = tokaJoukko.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        y.toString();
        return y;
    }

    public IntJoukko erotus(String joukko1, String joukko2) {
        IntJoukko ekaJoukko = selvitaJoukko(joukko1);
        IntJoukko tokaJoukko = selvitaJoukko(joukko2);

        IntJoukko z = new IntJoukko();
        int[] aTaulu = ekaJoukko.toIntArray();
        int[] bTaulu = tokaJoukko.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }

        z.toString();
        return z;
    }

    public void tulosta(String joukko) {
        selvitaJoukko(joukko).toString();
    }
}
