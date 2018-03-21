package nc.service;

import java.util.List;
import nc.dao.RepartoDao;
import nc.model.Reparto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("RepartoService")
public class RepartoServiceImpl implements RepartoService {
    
    @Autowired
    private RepartoDao dao;

    @Override
    public Reparto findByID(int id) {
        return dao.findByID(id);
    }

    @Override
    public void saveReparto(Reparto toSave) {
        dao.saveReparto(toSave);
    }

    @Override
    public void updateReparto(Reparto toUpdate) {
        Reparto entity = dao.findByID(toUpdate.getId());
        if(entity!=null){
            entity.setDipendentiReparto(entity.getDipendentiReparto());
            entity.setNome(entity.getNome());
            entity.setNonConformitaCorrelate(entity.getNonConformitaCorrelate());
        }
    }

    @Override
    public List<Reparto> findAll() {
        return dao.findAll();
    }
    
}
