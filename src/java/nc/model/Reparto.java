package nc.model;

import java.io.Serializable;
import java.util.Set;
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
    private Set<Dipendente> dipendentiReparto;
    @OneToMany(mappedBy="reparto")
    private Set<NonConformita> nonConformitaCorrelate;

    public Reparto() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<Dipendente> getDipendentiReparto() {
        return dipendentiReparto;
    }

    public Set<NonConformita> getNonConformitaCorrelate() {
        return nonConformitaCorrelate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDipendentiReparto(Set<Dipendente> dipendentiReparto) {
        this.dipendentiReparto = dipendentiReparto;
    }

    public void setNonConformitaCorrelate(Set<NonConformita> nonConformitaCorrelate) {
        this.nonConformitaCorrelate = nonConformitaCorrelate;
    }

    @Override
    public String toString() {
        return "Reparto{" + "id=" + id + ", nome=" + nome + ", dipendentiReparto=" + dipendentiReparto + ", nonConformitaCorrelate=" + nonConformitaCorrelate + '}';
    }
    
}
