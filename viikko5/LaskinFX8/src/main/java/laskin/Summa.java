package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    TextField syotekentta;
    TextField tuloskentta;
    Sovelluslogiikka sovellus;
    Button undo;
    int tulos;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.sovellus = sovellus;
        this.undo = undo;
        this.tulos = 0;
    }

    @Override
    public void suorita() {        
        tulos = sovellus.tulos();
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
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
