package nc.service;

import nc.dao.*;
import java.util.List;
import nc.model.Tipo;

/**
 *
 * @author riccardo
 */
public interface TipoService {
    Tipo findByNome(String nome);
    void saveTipo (Tipo toSave);
    List<Tipo> findAll();
}
