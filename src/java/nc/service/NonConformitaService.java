package nc.service;

import java.sql.Date;
import java.util.List;
import nc.model.NonConformita;
import nc.model.Tipo;

/**
 *
 * @author riccardo
 */
public interface NonConformitaService {
    NonConformita findByCodice(int codice);
    void saveNonConformita (NonConformita toSave);
    void updateNonConformita(NonConformita toUpdate);
    List<NonConformita> findAll();
    int findCostoPerTipo(Date anno, Tipo tipo);
}
