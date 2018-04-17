package nc.dao;

import java.sql.Date;
import java.util.List;
import nc.model.NonConformita;
import nc.model.Tipo;

/**
 *
 * @author riccardo
 */
public interface NonConformitaDao {
    NonConformita findByCodice(int codice);
    void saveNonConformita (NonConformita toSave);
    List<NonConformita> findAll();
    int findCostoPerTipo(Date anno, Tipo tipo);
}
