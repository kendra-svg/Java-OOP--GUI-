package comp.roundrock;

public class TarjetaMadre extends Componente {



    private String chipset;



    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }


    public TarjetaMadre(int rating, String tipoComponente, int idComponente, double precio, String modelo, String chipset) {
        super(rating, tipoComponente, idComponente, precio, modelo);
        super.setTipoComponente("Tarjeta Madre");
        this.chipset = chipset;
    }

    @Override
    public String toString() {
        return "Tipo de componente: " + getTipoComponente() +
                "\nModelo: " + getModelo() +
                "\nChipset: " + getChipset() +
                "\nPrecio: " + getPrecio() +
                "\nId Componente: " + getIdComponente() +
                "\nRating: " + getRating();


    }
}
