package nc.dao;

import java.util.List;
import nc.model.Dipendente;

/**
 *
 * @author riccardo
 */
public interface DipendenteDao {
    Dipendente findByMatricola(String matricola);
    void saveDipendente (Dipendente toSave);
    List<Dipendente> findAll();
}
