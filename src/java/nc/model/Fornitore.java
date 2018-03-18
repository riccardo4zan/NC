package nc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author riccardo
 */
@Entity
@Table(name="Fornitori")
public class Fornitore implements Serializable { 
    @Id
    private int Piva;
    @Column(nullable = false)
    private int Nome;
    @OneToMany(mappedBy="Fornitore")
    private List<NonConformita> NonConformitaCorrelate;

    public Fornitore() {
    }

    public int getPiva() {
        return Piva;
    }

    public int getNome() {
        return Nome;
    }

    public List<NonConformita> getNonConformitaCorrelate() {
        return NonConformitaCorrelate;
    }

    public void setPiva(int Piva) {
        this.Piva = Piva;
    }

    public void setNome(int Nome) {
        this.Nome = Nome;
    }

    public void setNonConformitaCorrelate(List<NonConformita> NonConformitaCorrelate) {
        this.NonConformitaCorrelate = NonConformitaCorrelate;
    }

    @Override
    public String toString() {
        return "Fornitore{" + "Piva=" + Piva + ", Nome=" + Nome + ", NonConformitaCorrelate=" + NonConformitaCorrelate + '}';
    }
    
}
