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
@Table(name="Categorie")
public class Categoria implements Serializable {    
    @Id @GeneratedValue
    private int Codice;
    @Column(nullable = false)
    private String Descrizione;
    @OneToMany(mappedBy="Categoria")
    private List<Pezzo> Pezzi;

    public Categoria() {
    }

    public int getCodice() {
        return Codice;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public List<Pezzo> getPezzi() {
        return Pezzi;
    }

    public void setCodice(int Codice) {
        this.Codice = Codice;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    public void setPezzi(List<Pezzo> Pezzi) {
        this.Pezzi = Pezzi;
    }

    @Override
    public String toString() {
        return "Categoria{" + "Codice=" + Codice + ", Descrizione=" + Descrizione + ", Pezzi=" + Pezzi + '}';
    }
        
}
