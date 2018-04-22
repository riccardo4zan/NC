package nc.dao;

import java.util.List;
import nc.model.Segnalazione;

/**
 *
 * @author riccardo
 */
public interface SegnalazioneDao {
    Segnalazione findByCodice(int codice);
    void saveSegnalazione (Segnalazione toSave);
    void deleteSegnalazione(int codice);
    List<Segnalazione> findAll();
}
