package nc.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categorie")
public class Categoria implements Serializable {    
    @Id @GeneratedValue
    @Column(name="Codice")
    private int codice;
    @Column(name="Descrizione")
    private String descrizione;
    @OneToMany(fetch=FetchType.EAGER,mappedBy="categoria")
    private Set<Pezzo> pezzi;

    public Categoria() {
    }

    public Categoria(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Set<Pezzo> getPezzi() {
        return pezzi;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPezzi(Set<Pezzo> pezzi) {
        this.pezzi = pezzi;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codice=" + codice + ", descrizione=" + descrizione + ", pezzi=" + pezzi + '}';
    }
    
}
