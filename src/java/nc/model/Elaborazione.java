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
    @Column(name="Codice")
    private int codice;
    @Column(name="Descrizione")
    private String descrizione;
    @Column(name="DataInizio")
    private Date dataInizio;
    @Column(name="DataFine")
    private Date dataFine;
    @ManyToOne
    @JoinColumn(name="MatricolaDipendente")
    private Dipendente dipendente;
    @ManyToOne
    @JoinColumn(name="CodiceNC")
    private NonConformita nonConformita;

    public Elaborazione() {
    }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public NonConformita getNonConformita() {
        return nonConformita;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public void setNonConformita(NonConformita nonConformita) {
        this.nonConformita = nonConformita;
    }

    @Override
    public String toString() {
        return "Elaborazione{" + "codice=" + codice + ", descrizione=" + descrizione + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", dipendente=" + dipendente + ", nonConformita=" + nonConformita + '}';
    }

}
