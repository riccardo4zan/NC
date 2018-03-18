package nc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author riccardo
 */
@Entity
@Table(name="Reparti")
public class Reparto implements Serializable {
    @Id @GeneratedValue
    private int ID;
    @Column(nullable = false)
    private String Nome;
    @OneToMany(mappedBy="Reparto")
    private List<Dipendente> DipendentiReparto;
    @OneToMany(mappedBy="Reparto")
    private List<NonConformita> NonConformitaCorrelate;

    public Reparto() {
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return Nome;
    }

    public List<Dipendente> getDipendentiReparto() {
        return DipendentiReparto;
    }

    public List<NonConformita> getNonConformitaCorrelate() {
        return NonConformitaCorrelate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setDipendentiReparto(List<Dipendente> DipendentiReparto) {
        this.DipendentiReparto = DipendentiReparto;
    }

    public void setNonConformitaCorrelate(List<NonConformita> NonConformitaCorrelate) {
        this.NonConformitaCorrelate = NonConformitaCorrelate;
    }

    @Override
    public String toString() {
        return "Reparto{" + "ID=" + ID + ", Nome=" + Nome + ", DipendentiReparto=" + DipendentiReparto + ", NonConformitaCorrelate=" + NonConformitaCorrelate + '}';
    }
    
}
