package comp.roundrock;

public class Componente {

    private int rating;

    private String tipoComponente;

    //private int capacidad;

    private int idComponente;

    //private String categoria;

    private double precio;

    private String modelo;


    public Componente(int rating, String tipoComponente, int idComponente, double precio, String modelo) {
        this.rating = rating;
        this.tipoComponente = tipoComponente;
        //this.capacidad = capacidad;
        this.idComponente = idComponente;
        //this.categoria = categoria;
        this.precio = precio;
        this.modelo = modelo;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    //public int getCapacidad() {
    //return capacidad;
    // }

    //public void setCapacidad(int capacidad) {
    // this.capacidad = capacidad;
    //}

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    //public String getCategoria() {
    //return categoria;
    // }//

    //public void setCategoria(String categoria) {
    //this.categoria = categoria;
    //}//

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }




    @Override
    public String toString() {
        return "Componente{" +
                "rating=" + rating +
                ", tipoComponente='" + tipoComponente + '\'' +
                //", capacidad=" + capacidad +
                ", idComponente=" + idComponente +
                //", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                '}';
    }
}