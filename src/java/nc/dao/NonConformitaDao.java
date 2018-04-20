package nc.dao;

import java.util.List;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;

public interface NonConformitaDao {
    NonConformita findByCodice(int codice);
    void saveNonConformita (NonConformita toSave);
    List<NonConformita> findAll();
    List<NonConformita> findAllAperte();
    List<NonConformita> findAllInElaborazione();
    List<NonConformita> findAllChiuse();
    int findCostoPerTipo(int anno, Tipo tipo);
    int findCostoPerReparto(int anno, Reparto rep);
    int findCostoPerFornitore(int anno, Fornitore forn);
}
