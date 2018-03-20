package nc.service;

import nc.dao.*;
import java.util.List;
import nc.model.Elaborazione;

/**
 *
 * @author riccardo
 */
public interface ElaborazioneService {
    Elaborazione findByCodice(String codice);
    void saveElaborazione (Elaborazione toSave);
    List<Elaborazione> findAll();
}
