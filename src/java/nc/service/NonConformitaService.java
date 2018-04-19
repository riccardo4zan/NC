package nc.service;

import java.sql.Date;
import java.util.List;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;

public interface NonConformitaService {
    NonConformita findByCodice(int codice);
    void saveNonConformita (NonConformita toSave);
    void updateNonConformita(NonConformita toUpdate);
    List<NonConformita> findAll();
    List<NonConformita> findAllAperte();
    List<NonConformita> findAllInElaborazione();
    List<NonConformita> findAllChiuse();
    int findCostoPerTipo(Date anno, Tipo tipo);
    int findCostoPerReparto(Date anno, Reparto rep);
    int findCostoPerFornitore(Date anno, Fornitore forn);
}
