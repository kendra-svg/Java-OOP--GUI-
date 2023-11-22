package comp.roundrock;

import java.util.List;

public class Familia {


    private String tipoFamilia;


     private int idFamilia;

     private List listaComponentes;

     private float rating;

     private double precio;


//    public Familia(String tipoFamilia, int idFamilia) {
//        this.tipoFamilia = tipoFamilia;
//
//        this.idFamilia = idFamilia;
//    }
//
//    public String getTipoFamilia() {
//        return tipoFamilia;
//    }
//
//    public void setTipoFamilia(String tipoFamilia) {
//        this.tipoFamilia = tipoFamilia;
//    }
//
//
//    public int getIdFamilia() {
//        return idFamilia;
//    }
//
//    public void setIdFamilia(int idFamilia) {
//        this.idFamilia = idFamilia;
//    }

    public Familia(String tipoFamilia, int idFamilia, List listaComponentes, float rating, double precio) {
        this.tipoFamilia = tipoFamilia;
        this.idFamilia = idFamilia;
        this.listaComponentes = listaComponentes;
        this.rating = rating;
        this.precio = precio;
    }

    public Familia() {

    }

    public String getTipoFamilia() {
        return tipoFamilia;
    }

    public void setTipoFamilia(String tipoFamilia) {
        this.tipoFamilia = tipoFamilia;
    }

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public List getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(List listaComponentes) {
        this.listaComponentes = listaComponentes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Familia{" +
                "tipoFamilia='" + tipoFamilia + '\'' +
                ", idFamilia=" + idFamilia +
                ", listaComponentes=" + listaComponentes +
                ", rating=" + rating +
                ", precio=" + precio +
                '}';
    }
}
