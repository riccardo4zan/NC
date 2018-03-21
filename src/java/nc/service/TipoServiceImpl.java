package nc.service;

import java.util.List;
import nc.dao.TipoDao;
import nc.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("TipoService")
public class TipoServiceImpl implements TipoService{
    
    @Autowired
    private TipoDao dao;

    @Override
    public Tipo findByNome(String nome) {
        return dao.findByNome(nome);
    }

    @Override
    public void saveTipo(Tipo toSave) {
        dao.saveTipo(toSave);
    }

    @Override
    public void updateTipo(Tipo toUpdate) {
        Tipo entity = dao.findByNome(toUpdate.getNome());
        if(entity!=null){
            entity.setDescrizione(entity.getDescrizione());
            entity.setListaNC(entity.getListaNC());
        }
    }

    @Override
    public List<Tipo> findAll() {
        return dao.findAll();
    }
    
}
