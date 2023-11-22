package comp.roundrock.DAO.Memory;

import comp.roundrock.Computadora;
import comp.roundrock.DAO.FamiliaDAO;
import comp.roundrock.Familia;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class FamiliaDAOMemoria implements FamiliaDAO {

    private Hashtable <Integer, Familia> familias = null;

    private static int siguiente =1;

    public FamiliaDAOMemoria() {setFamilia(new Hashtable<>());}

    protected int obtenerSiguienteID() {
        return siguiente++;
    }

    protected Hashtable<Integer, Familia> getFamilia() {return familias;}

    public void setFamilia(Hashtable<Integer, Familia> familias) {this.familias = familias;}


    @Override
    public void agregar(Familia familia) {
        if (familia != null && familia.getIdFamilia()==0) {
            familia.setIdFamilia(obtenerSiguienteID());
        }

        if(familia!= null && !getFamilia().containsKey(familia.getIdFamilia())) {
            getFamilia().put(familia.getIdFamilia(), familia);
        }

    }

    @Override
    public List<Familia> obtenerListaFamilias() { return new ArrayList<>((getFamilia()).values());}

}
