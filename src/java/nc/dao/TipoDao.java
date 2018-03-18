package nc.dao;

import java.util.List;
import nc.model.Tipo;

/**
 *
 * @author riccardo
 */
public interface TipoDao {
    Tipo findByNome(String nome);
    void saveTipo (Tipo toSave);
    List<Tipo> findAll();
}
