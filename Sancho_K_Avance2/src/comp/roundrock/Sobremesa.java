package comp.roundrock;

import java.util.ArrayList;

public class Sobremesa extends Familia{

    private String subFamilia;

    public String getSubFamilia() {
        return subFamilia;
    }

    public void setSubFamilia(String subFamilia) {
        this.subFamilia = subFamilia;
    }

    //public Sobremesa(){
       // super.setTipoFamilia("Sobremesa");
   // }

   // public Sobremesa(String tipoFamilia, ArrayList listaComponentes, double precio, float rating, String subFamilia) {
    //}

    public Sobremesa(String tipoFamilia, double precio, int rating, ArrayList listaComponentes, String subFamilia, int idFamilia) {
        super(tipoFamilia, idFamilia, listaComponentes, rating, precio);
        this.subFamilia = subFamilia;
        // Asigna otros valores específicos de Sobremesa si es necesario
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
