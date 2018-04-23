package nc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Elaborazioni")
public class Elaborazione implements Serializable {
    
    @Id @GeneratedValue
    @Column(name="Codice")
    private int codice;
    
    @Column(name="Descrizione")
    private String descrizione;
    
    @Column(name="DataInizio")
    private String dataInizio;
    
    @Column(name="DataFine")
    private String dataFine;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="MatricolaDipendente")
    private Dipendente dipendente;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CodiceNC")
    private NonConformita nonConformita;

    public Elaborazione() {
    }

    public Elaborazione(String descrizione, String dataInizio, Dipendente dipendente, NonConformita nonConformita) {
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dipendente = dipendente;
        this.nonConformita = nonConformita;
    }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public String getDataFine() {
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

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(String dataFine) {
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
