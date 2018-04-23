package nc.service;

import java.util.List;
import nc.dao.SegnalazioneDao;
import nc.model.Segnalazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("SegnalazioneService")
public class SegnalazioneServiceImpl implements SegnalazioneService {
    
    @Autowired
    private SegnalazioneDao dao;

    @Override
    public Segnalazione findByCodice(int codice) {
        return dao.findByCodice(codice);
    }

    @Override
    public void saveSegnalazione(Segnalazione toSave) {
        dao.saveSegnalazione(toSave);
    }
    
    public void deleteSegnalazione(int codice) {
        dao.deleteSegnalazione(codice);
    }

    @Override
    public void updateSegnalazione(Segnalazione toUpdate) {
        Segnalazione entity = dao.findByCodice(toUpdate.getCodice());
        if(entity!=null){
            entity.setData(toUpdate.getData());
            entity.setDescrizione(toUpdate.getDescrizione());
            entity.setDipendente(toUpdate.getDipendente());
        }
    }

    @Override
    public List<Segnalazione> findAll() {
        return dao.findAll();
    }
    
}
