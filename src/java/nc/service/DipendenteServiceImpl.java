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
            entity.setAperte(entity.getAperte());
            entity.setCognome(entity.getCognome());
            entity.setElaborazioniEffettuate(entity.getElaborazioniEffettuate());
            entity.setNome(entity.getNome());
            entity.setParteTeam(entity.getParteTeam());
            entity.setPassword(entity.getPassword());
            entity.setReparto(entity.getReparto());
            entity.setRuolo(entity.getRuolo());
            entity.setSegnalazioni(entity.getSegnalazioni());
        }
    }

    @Override
    public List<Dipendente> findAll() {
        return dao.findAll();
    }
    
}
