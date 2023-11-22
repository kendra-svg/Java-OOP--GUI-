package comp.roundrock;

public class TarjetaVideo extends Componente {


    private int cantidadVentiladores;

    public int getCantidadVentiladores() {
        return cantidadVentiladores;
    }

    public void setCantidadVentiladores(int cantidadVentiladores) {
        this.cantidadVentiladores = cantidadVentiladores;
    }


    public TarjetaVideo(int rating, String tipoComponente, int idComponente, double precio, String modelo, int cantidadVentiladores) {
        super(rating, tipoComponente, idComponente, precio, modelo);
        this.cantidadVentiladores = cantidadVentiladores;
        super.setTipoComponente("Tarjeta de Video");
    }



    @Override
    public String toString() {
        return "Tipo de componente: " + getTipoComponente() +
                "\nModelo: " + getModelo() +
                "\nPrecio: " + getPrecio() +
                "\nId Componente: " + getIdComponente() +
                "\nRating: " + getRating();


    }

}