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
    @Column(name="ID")
    private int id;
    @Column(name="Nome")
    private String nome;
    @OneToMany(mappedBy="reparto")
    private List<Dipendente> dipendentiReparto;
    @OneToMany(mappedBy="reparto")
    private List<NonConformita> nonConformitaCorrelate;

    public Reparto() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Dipendente> getDipendentiReparto() {
        return dipendentiReparto;
    }

    public List<NonConformita> getNonConformitaCorrelate() {
        return nonConformitaCorrelate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDipendentiReparto(List<Dipendente> dipendentiReparto) {
        this.dipendentiReparto = dipendentiReparto;
    }

    public void setNonConformitaCorrelate(List<NonConformita> nonConformitaCorrelate) {
        this.nonConformitaCorrelate = nonConformitaCorrelate;
    }

    @Override
    public String toString() {
        return "Reparto{" + "id=" + id + ", nome=" + nome + ", dipendentiReparto=" + dipendentiReparto + ", nonConformitaCorrelate=" + nonConformitaCorrelate + '}';
    }
    
}
