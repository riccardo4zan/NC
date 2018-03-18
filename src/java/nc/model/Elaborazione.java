package nc.model;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="Elaborazioni")
public class Elaborazione implements Serializable {
    @Id @GeneratedValue
    private int Codice;
    @Column(nullable = false)
    private String Descrizione;
    @Column(nullable = false)
    private Date DataInizio;
    private Date DataFine;
    @ManyToOne
    @JoinColumn(name="MatricolaDipendente")
    private Dipendente Dipendente;
    @ManyToOne
    @JoinColumn(name="CodiceNC")
    private NonConformita NonConformita;

    public Elaborazione() {
    }

    public int getCodice() {
        return Codice;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public Date getDataInizio() {
        return DataInizio;
    }

    public Date getDataFine() {
        return DataFine;
    }

    public Dipendente getDipendente() {
        return Dipendente;
    }

    public NonConformita getNonConformita() {
        return NonConformita;
    }

    public void setCodice(int Codice) {
        this.Codice = Codice;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    public void setDataInizio(Date DataInizio) {
        this.DataInizio = DataInizio;
    }

    public void setDataFine(Date DataFine) {
        this.DataFine = DataFine;
    }

    public void setDipendente(Dipendente Dipendente) {
        this.Dipendente = Dipendente;
    }

    public void setNonConformita(NonConformita NonConformita) {
        this.NonConformita = NonConformita;
    }

    @Override
    public String toString() {
        return "Elaborazione{" + "Codice=" + Codice + ", Descrizione=" + Descrizione + ", DataInizio=" + DataInizio + ", DataFine=" + DataFine + ", Dipendente=" + Dipendente + ", NonConformita=" + NonConformita + '}';
    }
    
}
