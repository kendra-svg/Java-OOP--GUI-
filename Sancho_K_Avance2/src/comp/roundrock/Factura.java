package comp.roundrock;

public class Factura {
    private int idFactura;
    private Computadora Computadora;
    private double totalFactura;

    public Factura(int idFactura, comp.roundrock.Computadora computadora, double totalFactura) {
        this.idFactura = idFactura;
        Computadora = computadora;
        this.totalFactura = totalFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public comp.roundrock.Computadora getComputadora() {
        return Computadora;
    }

    public void setComputadora(comp.roundrock.Computadora computadora) {
        Computadora = computadora;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", Computadora=" + Computadora +
                ", totalFactura=" + totalFactura +
                '}';
    }
}

