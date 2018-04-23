package nc.service;

import java.util.List;
import nc.dao.NonConformitaDao;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("NonConformitaService")
public class NonConformitaServiceImpl implements NonConformitaService{
    
    @Autowired
    private NonConformitaDao dao;

    @Override
    public NonConformita findByCodice(int codice) {
        return dao.findByCodice(codice);
    }

    @Override
    public void saveNonConformita(NonConformita toSave) {
        dao.saveNonConformita(toSave);
    }

    @Override
    public void updateNonConformita(NonConformita toUpdate) {
        NonConformita entity = dao.findByCodice(toUpdate.getCodice());
        if(entity!=null){
            entity.setAzioniContenimento(toUpdate.getAzioniContenimento());
            entity.setAzioniCorrettive(toUpdate.getAzioniCorrettive());
            entity.setAzioniPreventive(toUpdate.getAzioniPreventive());
            entity.setCause(toUpdate.getCause());
            entity.setCliente(toUpdate.getCliente());
            entity.setCosto(toUpdate.getCosto());
            entity.setDataApertura(toUpdate.getDataApertura());
            entity.setDataChiusura(toUpdate.getDataChiusura());
            entity.setDescrizione(toUpdate.getDescrizione());
            entity.setDipendente(toUpdate.getDipendente());
            entity.setElaborazioni(toUpdate.getElaborazioni());
            entity.setFornitore(toUpdate.getFornitore());
            entity.setGravita(toUpdate.getGravita());
            entity.setPezziCorrelati(toUpdate.getPezziCorrelati());
            entity.setReparto(toUpdate.getReparto());
            entity.setTeam(toUpdate.getTeam());
            entity.setTipo(toUpdate.getTipo());
        }
    }

    @Override
    public List<NonConformita> findAll() {
        return dao.findAll();
    }

    @Override
    public double findCostoPerTipo(int anno, Tipo tipo) {
        return dao.findCostoPerTipo(anno, tipo);
    }

    @Override
    public double findCostoPerReparto(int anno, Reparto rep) {
        return dao.findCostoPerReparto(anno, rep);
    }

    @Override
    public double findCostoPerFornitore(int anno, Fornitore forn) {
        return dao.findCostoPerFornitore(anno, forn);
    }

    @Override
    public List<NonConformita> findAllAperte() {
        return dao.findAllAperte();
    }

    @Override
    public List<NonConformita> findAllInElaborazione() {
        return dao.findAllInElaborazione();
    }

    @Override
    public List<NonConformita> findAllChiuse() {
        return dao.findAllChiuse();
    }
    
    @Override
    public double findCostoAnnoPerMese(int mese, int anno){
        return dao.findCostoAnnoPerMese(mese, anno);
    }

    @Override
    public double findCostoNCPerAnno(int anno) {
        return dao.findCostoNCPerAnno(anno);
    }

    @Override
    public int findNumeroNCAnno(int anno) {
        return dao.findNumeroNCAnno(anno);
    }
    
}
