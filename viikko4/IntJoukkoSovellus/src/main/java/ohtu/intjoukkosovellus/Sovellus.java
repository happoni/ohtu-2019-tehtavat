package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    public static void main(String[] args) {
        Logiikka logiikka = new Logiikka();
        Scanner lukija = new Scanner(System.in);
        UI ui = new UI(lukija, logiikka);
        ui.kaynnista();
    }
}
