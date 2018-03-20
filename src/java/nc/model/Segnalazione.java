package nc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author riccardo
 */
@Entity
@Table(name="Segnalazioni")
public class Segnalazione implements Serializable {
    @Id @GeneratedValue
    @Column(name="Codice")
    private int codice;
    @Column(name="Descrizione")
    private String descrizione;
    @Column(name="Data")
    private Date data;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "MatricolaDipendente")
    private Dipendente dipendente;

    public Segnalazione() {
    }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Date getData() {
        return data;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    @Override
    public String toString() {
        return "Segnalazione{" + "codice=" + codice + ", descrizione=" + descrizione + ", data=" + data + ", dipendente=" + dipendente + '}';
    }
    
}
