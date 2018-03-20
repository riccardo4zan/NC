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
    @Column(name="Piva")
    private int piva;
    @Column(name="Nome")
    private int nome;
    @OneToMany(mappedBy="fornitore")
    private List<NonConformita> nonConformitaCorrelate;

    public Fornitore() {
    }

    public int getPiva() {
        return piva;
    }

    public int getNome() {
        return nome;
    }

    public List<NonConformita> getNonConformitaCorrelate() {
        return nonConformitaCorrelate;
    }

    public void setPiva(int piva) {
        this.piva = piva;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public void setNonConformitaCorrelate(List<NonConformita> nonConformitaCorrelate) {
        this.nonConformitaCorrelate = nonConformitaCorrelate;
    }

    @Override
    public String toString() {
        return "Fornitore{" + "piva=" + piva + ", nome=" + nome + ", nonConformitaCorrelate=" + nonConformitaCorrelate + '}';
    }
    
}
