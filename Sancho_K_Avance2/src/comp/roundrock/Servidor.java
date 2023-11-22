package comp.roundrock;

import java.util.ArrayList;

public class Servidor extends Familia {

    public Servidor() {super.setTipoFamilia("Servidor");}

    public Servidor(String tipoFamilia, double precio, float rating, ArrayList listaComponentes) {
    }

    public String ToString(){
        return "Familia: " + setTipoFamilia() +
                "\nPrecio: " + getPrecio() +
                "\nComponentes: " + getListaComponentes() +
                "\nRating: " + getRating();
    }

    private String setTipoFamilia() {
        return getTipoFamilia();
    }
}
