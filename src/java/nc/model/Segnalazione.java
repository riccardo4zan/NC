package nc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    private int Codice;
    @Column(nullable = false)
    private String Descrizione;
    @Column(nullable = false)
    private Date Data;
    @ManyToOne
    @JoinColumn(name = "MatricolaDipendente")
    private Dipendente Dipendente;

    public Segnalazione() {
    }

    public int getCodice() {
        return Codice;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public Date getData() {
        return Data;
    }

    public Dipendente getDipendente() {
        return Dipendente;
    }

    public void setCodice(int Codice) {
        this.Codice = Codice;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public void setDipendente(Dipendente Dipendente) {
        this.Dipendente = Dipendente;
    }

    @Override
    public String toString() {
        return "Segnalazione{" + "Codice=" + Codice + ", Descrizione=" + Descrizione + ", Data=" + Data + ", Dipendente=" + Dipendente + '}';
    }
    
    
}
