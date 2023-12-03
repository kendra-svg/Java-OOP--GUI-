package comp.roundrock;

import java.util.ArrayList;

public class Portable extends Familia{

    private String subFamilia;

    public String getSubFamilia() {
        return subFamilia;
    }

    public void setSubFamilia(String subFamilia) {
        this.subFamilia = subFamilia;
    }

    private String duracionBateria;
    //private float peso;
    //public Portable(){
        //super.setTipoFamilia("Portable");
    //}

    public Portable(String tipoFamilia, double precio, int rating, ArrayList listaComponentes, String subFamilia, int idFamilia) {
        super(tipoFamilia, idFamilia, listaComponentes, rating, precio);
        this.subFamilia = subFamilia;
        // Asigna otros valores específicos de Portable si es necesario
    }



    //public Portable(String tipoFamilia, double precio, int rating, ArrayList listaComponentes, String subFamilia /*, float peso*/) {

    //}



    public String ToString(){
        return "Familia: " + setTipoFamilia() +
                "\nPrecio: " + getPrecio() +
                "\nComponentes: " + getListaComponentes() +
                "\nSub Familia: " + subFamilia  +/*
                "\nPeso: " + peso +*/
                "\nRating: " + getRating();
    }

    private String setTipoFamilia() {
        return getTipoFamilia();
    }


}
