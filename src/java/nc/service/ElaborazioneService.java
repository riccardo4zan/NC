package nc.service;

import java.util.List;
import nc.model.Elaborazione;

/**
 *
 * @author riccardo
 */
public interface ElaborazioneService {
    Elaborazione findByCodice(int codice);
    void saveElaborazione (Elaborazione toSave);
    List<Elaborazione> findAll();
}
