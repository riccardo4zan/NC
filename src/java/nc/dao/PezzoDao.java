package nc.dao;

import java.util.List;
import nc.model.Pezzo;

/**
 *
 * @author riccardo
 */
public interface PezzoDao {
    Pezzo findByCodice(int codice);
    void savePezzo (Pezzo toSave);
    List<Pezzo> findAll();
    int findMaxID();
}
