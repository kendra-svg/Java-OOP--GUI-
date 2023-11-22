package comp.roundrock.DAO.Memory;

import comp.roundrock.Componente;
import comp.roundrock.DAO.ComponenteDAO;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ComponenteDAOMemoria implements ComponenteDAO {
    private Hashtable<Integer, Componente> componentes = null;

    private static int siguiente = 1;


    public ComponenteDAOMemoria() {
        setComponentes(new Hashtable<>());
    }

    protected int obtenerSiguienteID() {
        return siguiente++;
    }

    protected Hashtable<Integer, Componente> getComponentes() {
        return componentes;
    }


    public void setComponentes(Hashtable<Integer, Componente> componentes) {
        this.componentes = componentes;
    }
    @Override
    public void agregar(Componente componente) {
        if (componente != null && componente.getIdComponente() == 0) {
            componente.setIdComponente(obtenerSiguienteID());
        }

        if (componente != null && !getComponentes().containsKey(componente.getIdComponente())) {
            getComponentes().put(componente.getIdComponente(), componente);
        }
    }

    @Override
    public List<Componente> obtenerListaComponentes() {
        return new ArrayList<>((getComponentes()).values());
    }
}
