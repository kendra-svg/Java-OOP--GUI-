package comp.roundrock;

import java.util.ArrayList;

public class Sobremesa extends Familia{

    private String subFamilia;
    public Sobremesa(){
        super.setTipoFamilia("Sobremesa");
    }

    public Sobremesa(String tipoFamilia, ArrayList listaComponentes, double precio, float rating, String subFamilia) {
    }

    public String ToString(){
        return "Familia: " + setTipoFamilia() +
                "\nPrecio: " + getPrecio() +
                "\nComponentes: " + getListaComponentes() +
                "\nSub Familia: " + subFamilia +
                "\nRating: " + getRating();
    }

    private String setTipoFamilia() {
        return getTipoFamilia();
    }
}
