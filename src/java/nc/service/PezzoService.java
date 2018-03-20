package nc.service;

import nc.dao.*;
import java.util.List;
import nc.model.Pezzo;

/**
 *
 * @author riccardo
 */
public interface PezzoService {
    Pezzo findByCodice(int codice);
    void savePezzo (Pezzo toSave);
    List<Pezzo> findAll();
}
