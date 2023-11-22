package comp.roundrock;

import java.util.ArrayList;

public class Escolar extends Familia{
    public Escolar() {
        super.setTipoFamilia("Escolar");}

    public Escolar(String tipoFamilia, ArrayList listaComponentes, double precio, float rating) {
    }


    public String toString() {
        return "Familia: " + getTipoFamilia() +
                "\nPrecio: " + getPrecio() +
                "\nComponentes: " + getListaComponentes() +
                "\nRating: " + getRating();
    }

}
