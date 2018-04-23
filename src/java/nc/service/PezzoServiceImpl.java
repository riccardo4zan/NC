package nc.service;

import java.util.List;
import nc.dao.PezzoDao;
import nc.model.Pezzo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("PezzoService")
public class PezzoServiceImpl implements PezzoService {
    
    @Autowired
    private PezzoDao dao;

    @Override
    public Pezzo findByCodice(int codice) {
        return dao.findByCodice(codice);
    }

    @Override
    public void savePezzo(Pezzo toSave) {
        dao.savePezzo(toSave);
    }

    @Override
    public void updatePezzo(Pezzo toUpdate) {
        Pezzo entity = dao.findByCodice(toUpdate.getCodice());
        if(entity!=null){
            entity.setCategoria(toUpdate.getCategoria());
            entity.setPezziNC(toUpdate.getPezziNC());
        }        
    }

    @Override
    public List<Pezzo> findAll() {
        return dao.findAll();
    }
    
}
