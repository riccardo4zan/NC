package nc.service;

import java.util.List;
import nc.dao.DipendenteDao;
import nc.model.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("DipendenteService")
public class DipendenteServiceImpl implements DipendenteService{
    
    @Autowired
    DipendenteDao dao;

    @Override
    public Dipendente findByMatricola(int matricola) {
        return dao.findByMatricola(matricola);
    }

    @Override
    public void saveDipendente(Dipendente toSave) {
        dao.saveDipendente(toSave);
    }

    @Override
    public void updateDipendente(Dipendente toUpdate) {
        Dipendente entity = dao.findByMatricola(toUpdate.getMatricola());
        if(entity!=null){
            entity.setAperte(toUpdate.getAperte());
            entity.setCognome(toUpdate.getCognome());
            entity.setElaborazioniEffettuate(toUpdate.getElaborazioniEffettuate());
            entity.setNome(toUpdate.getNome());
            entity.setParteTeam(toUpdate.getParteTeam());
            entity.setReparto(toUpdate.getReparto());
            entity.setSegnalazioni(toUpdate.getSegnalazioni());
        }
    }

    @Override
    public List<Dipendente> findAll() {
        return dao.findAll();
    }
    
    public List<Dipendente> findAllOperaiReparto(int reparto) {
        return dao.findAllOperaiReparto(reparto);
    }
     public List<Dipendente> findAllSenzaManager(){
         return dao.findAllSenzaManager();
     }
     public List<Dipendente> findAllLiberi(int codice){
         return dao.findAllLiberi(codice);
     }
}
