package nc.service;

import java.util.List;
import nc.model.Categoria;

/**
 *
 * @author riccardo
 */
public interface CategoriaService {
    Categoria findByCodice(int codice);
    void saveCategoria(Categoria toSave);
    void updateCategoria(Categoria toUpdate);
    List<Categoria> findAllCategorie();
}
