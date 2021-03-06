package nc.service;

import java.util.List;
import nc.model.Dipendente;
import nc.model.Elaborazione;

/**
 *
 * @author riccardo
 */
public interface ElaborazioneService {
    Elaborazione findByCodice(int codice);
    void saveElaborazione(Elaborazione toSave);
    void updateElaborazione(Elaborazione toUpdate);
    List<Elaborazione> findAll();
    List<Elaborazione> findOpen(Dipendente dip);
    List<Elaborazione> findClose(Dipendente dip);
}
