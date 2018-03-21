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
    void updateSegnalazione(Segnalazione toUpdate);
    List<Segnalazione> findAll();
}
