package nc.service;

import java.util.List;
import nc.model.Segnalazione;

/**
 *
 * @author riccardo
 */
public interface SegnalazioneService {
    Segnalazione findByCodice(int codice);
    void saveSegnalazione (Segnalazione toSave);
    List<Segnalazione> findAll();
}
