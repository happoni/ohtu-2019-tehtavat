package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    TextField syotekentta;
    TextField tuloskentta;
    Sovelluslogiikka sovellus;
    Button undo;
    int tulos;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.undo = undo;
        this.tulos = 0;
    }

    @Override
    public void suorita() {
        tulos = sovellus.tulos();
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
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
