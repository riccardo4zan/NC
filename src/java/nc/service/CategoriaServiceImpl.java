package nc.service;

import java.util.List;
import nc.dao.CategoriaDao;
import nc.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("CategoriaService")
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao dao;

    @Override
    public Categoria findByCodice(int codice) {
        return dao.findByCodice(codice);
    }

    @Override
    public void saveCategoria(Categoria toSave) {
        dao.saveCategoria(toSave);
    }

    @Override
    public void updateCategoria(Categoria toUpdate) {
        Categoria entity = dao.findByCodice(toUpdate.getCodice());
        if(entity!=null){
            entity.setDescrizione(toUpdate.getDescrizione());
            entity.setPezzi(toUpdate.getPezzi());
        }
    }

    @Override
    public List<Categoria> findAllCategorie() {
        return dao.findAllCategorie();
    }
    
}
