package nc.service;

import java.util.List;
import nc.model.Dipendente;

/**
 *
 * @author riccardo
 */
public interface DipendenteService {
    Dipendente findByMatricola(int matricola);
    void saveDipendente (Dipendente toSave);
    List<Dipendente> findAll();
}
