package comp.roundrock.DAO.Memory;


import comp.roundrock.Computadora;
import comp.roundrock.DAO.ComputadoraDAO;

import java.util.Hashtable;


import java.util.Hashtable;

public class ComputadoraDAOMemoria implements ComputadoraDAO {

    private Hashtable<Integer, Computadora> computadoras =null;

    private static int siguiente = 1;


    public ComputadoraDAOMemoria() {
        setComputadoras(new Hashtable<>());
    }

    protected int obtenerSiguienteID() {
        return siguiente++;
    }

        protected Hashtable<Integer, Computadora> getComputadoras() {
        return computadoras;
    }


    public void setComputadoras(Hashtable<Integer, Computadora> computadoras) {
        this.computadoras = computadoras;
    }


    @Override
    public void agregar(Computadora computadora) {
        if (computadora != null && computadora.getIdComputadora() == 0) {
            computadora.setIdComputadora(obtenerSiguienteID());
        }

        if (computadora != null && !getComputadoras().containsKey(computadora.getIdComputadora())) {
            getComputadoras().put(computadora.getIdComputadora(),computadora);
        }

    }
}
