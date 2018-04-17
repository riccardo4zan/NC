package nc.dao;

import java.sql.Date;
import java.util.List;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;

/**
 *
 * @author riccardo
 */
public interface NonConformitaDao {
    NonConformita findByCodice(int codice);
    void saveNonConformita (NonConformita toSave);
    List<NonConformita> findAll();
    List<NonConformita> findAllAperte();
    int findCostoPerTipo(Date anno, Tipo tipo);
    int findCostoPerReparto(Date anno, Reparto rep);
    int findCostoPerFornitore(Date anno, Fornitore forn);
}
