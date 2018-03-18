package nc.dao;

import java.util.List;
import nc.model.Cliente;

/**
 *
 * @author riccardo
 */
public interface ClienteDao {
    Cliente findByPiva(String piva);
    void saveCliente(Cliente toSave);
    List<Cliente> findAllClienti();
}