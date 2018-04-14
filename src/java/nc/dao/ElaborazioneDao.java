package nc.dao;

import java.util.List;
import nc.model.Dipendente;
import nc.model.Elaborazione;

/**
 *
 * @author riccardo
 */
public interface ElaborazioneDao {
    Elaborazione findByCodice(int codice);
    void saveElaborazione (Elaborazione toSave);
    List<Elaborazione> findAll();
    List<Elaborazione> findOpen(Dipendente dip);
    List<Elaborazione> findClose(Dipendente dip);
}
