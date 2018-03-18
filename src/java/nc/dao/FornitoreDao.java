package nc.dao;

import java.util.List;
import nc.model.Fornitore;

/**
 *
 * @author riccardo
 */
public interface FornitoreDao {
    Fornitore findByPiva(String piva);
    void saveFornitore (Fornitore toSave);
    List<Fornitore> findAll();
}
