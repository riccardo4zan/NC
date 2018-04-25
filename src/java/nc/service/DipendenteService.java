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
    void updateDipendente(Dipendente toUpdate);
    List<Dipendente> findAll();
    List<Dipendente> findAllOperaiReparto(int reparto);
     List<Dipendente> findAllSenzaManager();
}
