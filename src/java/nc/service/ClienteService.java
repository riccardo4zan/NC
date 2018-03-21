package nc.service;

import java.util.List;
import nc.model.Cliente;

/**
 *
 * @author riccardo
 */
public interface ClienteService {
    Cliente findByPiva(String piva);
    void saveCliente(Cliente toSave);
    void updateCliente(Cliente toUpdate);
    List<Cliente> findAllClienti();
}