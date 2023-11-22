package comp.roundrock.DAO.Memory;

import comp.roundrock.Componente;
import comp.roundrock.DAO.ComponenteDAO;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ComponenteDAOMemoria implements ComponenteDAO {

    private ComponenteDAO componenteDAO;
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
        System.out.println("Antes de agregar");
        if (componente != null && componente.getIdComponente() == 0) {
            componente.setIdComponente(obtenerSiguienteID());
        }

        if (componente != null && !getComponentes().containsKey(componente.getIdComponente())) {
            getComponentes().put(componente.getIdComponente(), componente);
            System.out.println("Componente agregado: " + componente.getIdComponente());
            imprimirEstado();
        } else {
            System.out.println("Componente no agregado (ID duplicado): " + componente.getIdComponente());
        }

        System.out.println("Despues de agregar");
    }
    public void getEstado() {
        imprimirEstado();
    }
    public void imprimirEstado() {
        System.out.println("Estado actual de ComponenteDAOMemoria:");
        for (Componente c : componentes.values()) {
            System.out.println(c);
        }
    }

    @Override
    public List<Componente> obtenerListaComponentes() {
        /*List<Componente> listaComponentes = new ArrayList<>((getComponentes()).values());*/
        List<Componente> listaComponentes = componenteDAO.obtenerListaComponentes();

        // Agrega un mensaje de registro para verificar la lista
        System.out.println("Número de componentes en la lista: " + listaComponentes.size());
        imprimirEstado();
        return listaComponentes;

        /*return new ArrayList<>((getComponentes()).values());*/
    }
}
