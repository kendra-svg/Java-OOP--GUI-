package comp.roundrock;

import java.util.List;

public class Computadora {

    private List listaComponentes;
    private String familia;
    private int rating;
    private int idComputadora;
    private double precio;
    //private Usuario usuario;

    private String nombreComputadora;

    public Computadora(List listaComponentes, String familia, int rating, int idComputadora, double precio, String nombreComputadora ) {
        this.listaComponentes = listaComponentes;
        this.familia = familia;
        this.rating = rating;
        this.idComputadora = idComputadora;
        this.precio = precio;
        this.nombreComputadora = nombreComputadora;
        //this.usuario = usuario;
    }

    public Computadora() {
    }

    public List getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(List listaComponentes) {
        this.listaComponentes = listaComponentes;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }


    public String getNombreComputadora() {
        return nombreComputadora;
    }

    public void setNombreComputadora(String nombreComputadora) {
        this.nombreComputadora = nombreComputadora;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "listaComponentes=" + listaComponentes +
                ", familia='" + familia + '\'' +
                ", rating=" + rating +
                ", idComputadora=" + idComputadora +
                ", precio=" + precio/* +
                ", usuario=" + usuario +
                '}'*/;
    }
}