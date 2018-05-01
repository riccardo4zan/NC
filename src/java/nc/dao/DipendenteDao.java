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
    List<Dipendente> findAllOperaiReparto(int reparto);
    List<Dipendente> findAllSenzaManager();
    List<Dipendente> findAllLiberi(int codice);
}
