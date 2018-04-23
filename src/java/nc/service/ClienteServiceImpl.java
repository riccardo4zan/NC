package nc.service;

import java.util.List;
import nc.dao.ClienteDao;
import nc.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author riccardo
 */
@Transactional
@Service("ClienteService")
public class ClienteServiceImpl implements ClienteService {
 
    @Autowired
    private ClienteDao dao;

    @Override
    public Cliente findByPiva(String piva) {
        return dao.findByPiva(piva);
    }

    @Override
    public void saveCliente(Cliente toSave) {
        dao.saveCliente(toSave);
    }

    @Override
    public void updateCliente(Cliente toUpdate) {
        Cliente entity = dao.findByPiva(toUpdate.getPiva());
        if(entity!=null){
            entity.setNome(toUpdate.getNome());
            entity.setNonConformitaCorrelate(toUpdate.getNonConformitaCorrelate());
        }
    }

    @Override
    public List<Cliente> findAll() {
        return dao.findAllClienti();
    }
}
