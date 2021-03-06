package nc.service;

import java.util.List;
import nc.model.Tipo;

/**
 *
 * @author riccardo
 */
public interface TipoService {
    Tipo findByNome(String nome);
    void saveTipo (Tipo toSave);
    void updateTipo(Tipo toUpdate);
    List<Tipo> findAll();
}
