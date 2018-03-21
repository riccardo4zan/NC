package nc.service;

import java.util.List;
import nc.model.Pezzo;

/**
 *
 * @author riccardo
 */
public interface PezzoService {
    Pezzo findByCodice(int codice);
    void savePezzo (Pezzo toSave);
    void updatePezzo(Pezzo toUpdate);
    List<Pezzo> findAll();
}
