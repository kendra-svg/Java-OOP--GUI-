package comp.roundrock;

public class Almacenamiento extends Componente {

    private String categoria;

    private String capacidad;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }


    public Almacenamiento(int rating, String tipoComponente, int idComponente, double precio, String modelo, String categoria, String capacidad) {
        super(rating, tipoComponente, idComponente, precio, modelo);
        super.setTipoComponente("Almacenamiento");
        this.categoria = categoria;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Tipo de componente: " + getTipoComponente() +
                "\nCategoría: " + getCategoria() +
                "\nCapacidad: " + getCapacidad() +
                "\nPrecio: " + getPrecio() +
                "\nId Componente: " + getIdComponente() +
                "\nRating: " + getRating();


    }
}
