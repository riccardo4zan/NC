package nc.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author riccardo
 */
@Entity
@Table(name="Pezzi")
public class Pezzo implements Serializable {
    @Id @GeneratedValue
    @Column(name="Codice")
    private int codice;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Categoria")
    private Categoria categoria;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="PezzoNC",
            joinColumns = {@JoinColumn(name = "CodicePezzo")},
            inverseJoinColumns = {@JoinColumn(name = "CodiceNC")}
    )
    private Set<NonConformita> pezziNC;

    public Pezzo() {
    }

    public int getCodice() {
        return codice;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Set<NonConformita> getPezziNC() {
        return pezziNC;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPezziNC(Set<NonConformita> pezziNC) {
        this.pezziNC = pezziNC;
    }

    @Override
    public String toString() {
        return "Pezzo{" + "codice=" + codice + ", categoria=" + categoria + ", pezziNC=" + pezziNC + '}';
    }
    
}
