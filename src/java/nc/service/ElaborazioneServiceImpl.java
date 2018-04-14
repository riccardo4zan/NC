package nc.service;

import java.util.List;
import nc.dao.ElaborazioneDao;
import nc.model.Dipendente;
import nc.model.Elaborazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("ElaborazioneService")
public class ElaborazioneServiceImpl implements ElaborazioneService{
    
    @Autowired
    private ElaborazioneDao dao;

    @Override
    public Elaborazione findByCodice(int codice) {
        return dao.findByCodice(codice);
    }

    @Override
    public void saveElaborazione(Elaborazione toSave) {
        dao.saveElaborazione(toSave);
    }

    @Override
    public void updateElaborazione(Elaborazione toUpdate) {
        Elaborazione entity = dao.findByCodice(toUpdate.getCodice());
        if(entity!=null){
            entity.setDataInizio(entity.getDataInizio());
            entity.setDataFine(entity.getDataFine());
            entity.setDescrizione(entity.getDescrizione());
            entity.setDipendente(entity.getDipendente());
            entity.setNonConformita(entity.getNonConformita());
        }
    }

    @Override
    public List<Elaborazione> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Elaborazione> findOpen(Dipendente dip) {
        return dao.findOpen(dip);
    }

    @Override
    public List<Elaborazione> findClose(Dipendente dip) {
        return dao.findClose(dip);
    }
    
}
