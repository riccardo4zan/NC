package nc.dao;

import java.util.List;
import nc.model.Dipendente;

/**
 *
 * @author riccardo
 */
public interface DipendenteDao {
    Dipendente findByMatricola(int matricola);
    void saveDipendente (Dipendente toSave);
    List<Dipendente> findAll();
}
