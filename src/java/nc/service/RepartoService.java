package nc.service;

import nc.dao.*;
import java.util.List;
import nc.model.Reparto;

/**
 *
 * @author riccardo
 */
public interface RepartoService {
    Reparto findByID(int id);
    void saveReparto (Reparto toSave);
    List<Reparto> findAll();
}
