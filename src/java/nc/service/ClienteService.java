package nc.service;

import nc.dao.*;
import java.util.List;
import nc.model.Cliente;

/**
 *
 * @author riccardo
 */
public interface ClienteService {
    Cliente findByPiva(String piva);
    void saveCliente(Cliente toSave);
    List<Cliente> findAllClienti();
}