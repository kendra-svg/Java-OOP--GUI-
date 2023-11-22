package comp.roundrock;

public class Procesador extends Componente {

    private int cantidadNucleos;

    public int getCantidadNucleos() {
        return cantidadNucleos;
    }

    public void setCantidadNucleos(int cantidadNucleos) {
        this.cantidadNucleos = cantidadNucleos;
    }

    public Procesador(int rating, String tipoComponente, int idComponente, double precio, String modelo, int cantidadNucleos) {
        super(rating, tipoComponente, idComponente, precio, modelo);
        super.setTipoComponente("Procesador");
        this.cantidadNucleos = cantidadNucleos;
    }

    @Override
    public String toString() {
        return "Tipo de componente: " + getTipoComponente() +
                "\nCantidad de Núcleos: " + getCantidadNucleos() +
                "\nPrecio: " + getPrecio() +
                "\nId Componente: " + getIdComponente() +
                "\nRating: " + getRating();


    }
}
