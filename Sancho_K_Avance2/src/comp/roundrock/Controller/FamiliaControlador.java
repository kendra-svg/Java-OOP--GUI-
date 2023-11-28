package comp.roundrock.Controller;
import comp.roundrock.DAO.FamiliaDAO;
import comp.roundrock.Familia;
import comp.roundrock.View.Vista;

import java.util.List;

public class FamiliaControlador {

    private FamiliaDAO familiaDAO;

    private Vista vista;

    public FamiliaControlador(FamiliaDAO familiaDAO, Vista vista) {
        this.familiaDAO = familiaDAO;
        this.vista = vista;
    }

//    public void registraFamilia() {
//        Familia nuevaFamilia = vista.capturarNuevaFamilia();
//        familiaDAO.agregar(nuevaFamilia);
//    }

//    public void listarFamilia() {
//        List<Familia> familias = familiaDAO.obtenerListaFamilias();
//        vista.listarFamilia(familias);
//    }

}
