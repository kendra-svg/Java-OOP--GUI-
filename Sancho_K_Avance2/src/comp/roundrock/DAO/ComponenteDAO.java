package comp.roundrock.DAO;

import comp.roundrock.Componente;

import java.util.List;

public interface ComponenteDAO {

    void agregar(Componente componente);

    List<Componente> obtenerListaComponentes();
}
