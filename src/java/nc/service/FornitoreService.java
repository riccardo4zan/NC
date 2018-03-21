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
    void updateFornitore(Fornitore toUpdate);
    List<Fornitore> findAll();
}
