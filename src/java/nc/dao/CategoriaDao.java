package nc.dao;

import java.util.List;
import nc.model.Categoria;

/**
 *
 * @author riccardo
 */
public interface CategoriaDao {
    Categoria findByCodice(int codice);
    void saveCategoria(Categoria toSave);
    List<Categoria> findAllCategorie();
}
