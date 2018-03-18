package nc.dao;

import java.util.List;
import nc.model.NonConformita;

/**
 *
 * @author riccardo
 */
public interface NonConformitaDao {
    NonConformita findByCodice(int codice);
    void saveNonConformita (NonConformita toSave);
    List<NonConformita> findAll();
}
