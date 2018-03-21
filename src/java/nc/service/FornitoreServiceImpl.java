package nc.service;

import java.util.List;
import nc.dao.FornitoreDao;
import nc.model.Fornitore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("FornitoreService")
public class FornitoreServiceImpl implements FornitoreService {
    
    @Autowired
    private FornitoreDao dao;

    @Override
    public Fornitore findByPiva(String piva) {
        return dao.findByPiva(piva);
    }

    @Override
    public void saveFornitore(Fornitore toSave) {
        dao.saveFornitore(toSave);
    }

    @Override
    public void updateFornitore(Fornitore toUpdate) {
        Fornitore entity = dao.findByPiva(toUpdate.getPiva());
        if(entity!=null){
            entity.setNome(entity.getNome());
            entity.setNonConformitaCorrelate(entity.getNonConformitaCorrelate());
        }
    }

    @Override
    public List<Fornitore> findAll() {
        return dao.findAll();
    }
    
}
