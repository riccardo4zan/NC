package nc.dao;

import java.util.List;
import nc.model.Elaborazione;

/**
 *
 * @author riccardo
 */
public interface ElaborazioneDao {
    Elaborazione findByCodice(int codice);
    void saveElaborazione (Elaborazione toSave);
    List<Elaborazione> findAll();
}
