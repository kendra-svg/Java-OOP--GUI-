package comp.roundrock.Controller;
import comp.roundrock.Computadora;
import comp.roundrock.DAO.ComputadoraDAO;
import comp.roundrock.DAO.Memory.ComputadoraDAOMemoria;
import comp.roundrock.View.Vista;
import java.util.List;

import comp.roundrock.Usuario;

public class ComputadoraControllador {

    private ComputadoraDAO commputadoraDAO;

    private Vista vista;

    public ComputadoraControllador(ComputadoraDAO commputadoraDAO, Vista vista) {
        this.commputadoraDAO = commputadoraDAO;
        this.vista = vista;
    }

    public void registrarComputadora() {
        Computadora nuevaComputadora = vista.capturarNuevaComputadora();
        commputadoraDAO.agregar(nuevaComputadora);
    }


}
