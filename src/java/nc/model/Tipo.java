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
@Table(name="Tipi")
public class Tipo implements Serializable {
    @Id
    private String Nome;
    @Column(nullable = false)
    private String Descrizione;
    @OneToMany(mappedBy="Tipo")
    private List<NonConformita> ListaNC;

    public Tipo() {
    }

    public String getNome() {
        return Nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public List<NonConformita> getListaNC() {
        return ListaNC;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    public void setListaNC(List<NonConformita> ListaNC) {
        this.ListaNC = ListaNC;
    }

    @Override
    public String toString() {
        return "Tipo{" + "Nome=" + Nome + ", Descrizione=" + Descrizione + ", ListaNC=" + ListaNC + '}';
    }
    
}
