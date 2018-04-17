package nc.service;

import java.sql.Date;
import java.util.List;
import nc.dao.NonConformitaDao;
import nc.model.Fornitore;
import nc.model.NonConformita;
import nc.model.Reparto;
import nc.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
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
            entity.setAzioniContenimento(entity.getAzioniContenimento());
            entity.setAzioniCorrettive(entity.getAzioniCorrettive());
            entity.setAzioniPreventive(entity.getAzioniPreventive());
            entity.setCause(entity.getCause());
            entity.setCliente(entity.getCliente());
            entity.setCosto(entity.getCosto());
            entity.setDataApertura(entity.getDataApertura());
            entity.setDataChiusura(entity.getDataChiusura());
            entity.setDescrizione(entity.getDescrizione());
            entity.setDipendente(entity.getDipendente());
            entity.setElaborazioni(entity.getElaborazioni());
            entity.setFornitore(entity.getFornitore());
            entity.setGravita(entity.getGravita());
            entity.setPezziCorrelati(entity.getPezziCorrelati());
            entity.setReparto(entity.getReparto());
            entity.setTeam(entity.getTeam());
            entity.setTipo(entity.getTipo());
        }
    }

    @Override
    public List<NonConformita> findAll() {
        return dao.findAll();
    }

    @Override
    public int findCostoPerTipo(Date anno, Tipo tipo) {
        return dao.findCostoPerTipo(anno, tipo);
    }

    @Override
    public int findCostoPerReparto(Date anno, Reparto rep) {
        return dao.findCostoPerReparto(anno, rep);
    }

    @Override
    public int findCostoPerFornitore(Date anno, Fornitore forn) {
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
    
}
