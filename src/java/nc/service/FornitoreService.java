package nc.service;

import java.util.List;
import nc.model.Fornitore;

/**
 *
 * @author riccardo
 */
public interface FornitoreService {
    Fornitore findByPiva(String piva);
    void saveFornitore (Fornitore toSave);
    List<Fornitore> findAll();
}
