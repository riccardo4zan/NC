package nc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
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
    private int Codice;
    @ManyToOne
    @JoinColumn(name="Categoria")
    private Categoria Categoria;
    @ManyToMany
    @JoinTable(
            name="PezzoNC",
            joinColumns = {@JoinColumn(name = "CodicePezzo")},
            inverseJoinColumns = {@JoinColumn(name = "CodiceNC")}
    )
    private List<NonConformita> PezziNC;

    public Pezzo() {
    }

    public int getCodice() {
        return Codice;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public List<NonConformita> getPezziNC() {
        return PezziNC;
    }

    public void setCodice(int Codice) {
        this.Codice = Codice;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public void setPezziNC(List<NonConformita> PezziNC) {
        this.PezziNC = PezziNC;
    }
    
}
