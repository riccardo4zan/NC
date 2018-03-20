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
    @Column(name="Nome")
    private String nome;
    @Column(name="Descrizione")
    private String descrizione;
    @OneToMany(mappedBy="tipo")
    private List<NonConformita> listaNC;

    public Tipo() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<NonConformita> getListaNC() {
        return listaNC;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setListaNC(List<NonConformita> listaNC) {
        this.listaNC = listaNC;
    }

    @Override
    public String toString() {
        return "Tipo{" + "nome=" + nome + ", descrizione=" + descrizione + ", listaNC=" + listaNC + '}';
    }
    
}
