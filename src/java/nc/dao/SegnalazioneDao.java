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
    List<Segnalazione> findAll();
}
