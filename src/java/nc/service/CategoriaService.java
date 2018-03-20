package nc.service;

import nc.dao.*;
import java.util.List;
import nc.model.Categoria;

/**
 *
 * @author riccardo
 */
public interface CategoriaService {
    Categoria findByCodice(String codice);
    void saveCategoria(Categoria toSave);
    List<Categoria> findAllCategorie();
}
