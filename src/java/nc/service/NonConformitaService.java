package nc.service;

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
    List<NonConformita> findAllApertePerReparto(Reparto rep);
    List<NonConformita> findAllInElaborazionePerReparto(Reparto rep);
    List<NonConformita> findAllChiusePerReparto(Reparto rep);
    double findCostoPerTipo(int anno, Tipo tipo);
    double findCostoPerReparto(int anno, Reparto rep);
    double findCostoPerFornitore(int anno, Fornitore forn);
    double findCostoAnnoPerMese(int mese, int anno);
    double findCostoNCPerAnno(int anno);
    int findNumeroNCAnno(int anno);
    String findTipoNCProblematico();
    int findNumeroNCPerReparto(int anno, int codice);
    int findNumeroNCReparti(int anno);
    int findNumeroNCClienti(int anno);
    int findNumeroNCFornitori(int anno);
    int findNumAnnoPerMese(int mese, int anno);
}
