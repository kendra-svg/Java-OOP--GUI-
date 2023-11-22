package comp.roundrock.Controller;
import comp.roundrock.Componente;
import comp.roundrock.DAO.ComponenteDAO;
import comp.roundrock.Usuario;
import comp.roundrock.View.Vista;
import java.util.List;
import comp.roundrock.Utilitarios.Utils;
public class ComponenteControlador {
    private ComponenteDAO componenteDAO;

    private Vista vista;

    public ComponenteControlador(ComponenteDAO componenteDAO, Vista vista) {
        this.componenteDAO = componenteDAO;
        this.vista = vista;
    }

    public void registrarComponente() {
        Componente nuevoComponente = vista.capturarNuevoComponente();
        componenteDAO.agregar(nuevoComponente);
    }

    public void listarComponente() {
        List<Componente> componentes = componenteDAO.obtenerListaComponentes();
        vista.listarComponente(componentes);

    }


}







