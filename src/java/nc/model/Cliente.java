package nc.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clienti")
public class Cliente implements Serializable {
    @Id
    @Column(name="Piva")
    private String piva;
    @Column(name="Nome")
    private String nome;
    @OneToMany(fetch=FetchType.EAGER,mappedBy="cliente")
    private Set<NonConformita> nonConformitaCorrelate;

    public Cliente() {
    }

    public Cliente(String piva, String nome) {
        this.piva = piva;
        this.nome = nome;
    }

    public String getPiva() {
        return piva;
    }

    public String getNome() {
        return nome;
    }

    public Set<NonConformita> getNonConformitaCorrelate() {
        return nonConformitaCorrelate;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNonConformitaCorrelate(Set<NonConformita> nonConformitaCorrelate) {
        this.nonConformitaCorrelate = nonConformitaCorrelate;
    }

    @Override
    public String toString() {
        return "Cliente{" + "piva=" + piva + ", nome=" + nome + ", nonConformitaCorrelate=" + nonConformitaCorrelate + '}';
    }
    
}
