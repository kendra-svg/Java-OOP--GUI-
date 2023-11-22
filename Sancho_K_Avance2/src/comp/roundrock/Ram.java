package comp.roundrock;

public class Ram extends Componente {

    private String capacidad;




    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }



    public Ram(int rating, String tipoComponente, int idComponente, double precio, String modelo, String capacidad) {
        super(rating, tipoComponente, idComponente, precio, modelo);
        super.setTipoComponente("Ram");
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Tipo de componente: " + getTipoComponente() +
                "\nModelo: " + getModelo() +
                "\nCapacidad" + getCapacidad() +
                "\nPrecio: " + getPrecio() +
                "\nId Componente: " + getIdComponente() +
                "\nRating: " + getRating();


    }
}