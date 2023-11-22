package comp.roundrock.DAO;

import comp.roundrock.Computadora;
import comp.roundrock.Familia;
import java.util.List;

public interface FamiliaDAO {

    void agregar(Familia familia);


    List<Familia> obtenerListaFamilias();
}
