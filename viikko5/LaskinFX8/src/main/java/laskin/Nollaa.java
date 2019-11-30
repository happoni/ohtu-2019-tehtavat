package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    Sovelluslogiikka sovellus;
    TextField syotekentta;
    TextField tuloskentta;
    Button undo;
    int tulos;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.undo = undo;
        this.tulos = 0;
    }

    @Override
    public void suorita() {
        tulos = sovellus.tulos();
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
    }

}
