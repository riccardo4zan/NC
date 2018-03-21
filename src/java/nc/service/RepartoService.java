package nc.service;

import java.util.List;
import nc.model.Reparto;

/**
 *
 * @author riccardo
 */
public interface RepartoService {
    Reparto findByID(int id);
    void saveReparto (Reparto toSave);
    void updateReparto(Reparto toUpdate);
    List<Reparto> findAll();
}
