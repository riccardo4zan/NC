package nc.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author riccardo
 */
@Entity
public class NonConformita implements Serializable {
    @Id @GeneratedValue
    private int Codice;
    @Column(nullable = false)
    @Enumerated
    private Stato Stato;
    @Column(nullable = false)
    private String Descrizione;
    @Column(nullable = false)
    private String AzioniContenimento;
    private String AzioniCorrettive;
    private String AzioniPreventive;
    @Column(nullable = false)
    private Date DataApertura;
    private Date DataChiusura;
    @Column(nullable = false)
    private String Cause;
    private int Gravita;
    private double Costo;
    @ManyToOne
    @JoinColumn(name="Tipo")
    private Tipo Tipo;
    @ManyToOne
    @JoinColumn(name="PivaFornitore")
    private Fornitore Fornitore;
    @ManyToOne
    @JoinColumn(name="PivaCliente")
    private Cliente Cliente;
    @ManyToOne
    @JoinColumn(name="IDReparto")
    private Reparto Reparto;
    @ManyToOne
    @JoinColumn(name="MatricolaDipendente")
    private Dipendente Dipendente;
    @OneToMany(mappedBy="NonConformita")
    private List<Elaborazione> Elaborazioni; 
    @ManyToMany(mappedBy="PezziNC")
    private List<Pezzo> PezziCorrelati;
    @ManyToMany(mappedBy="ParteTeam")
    private List<Dipendente> Team;

    public NonConformita() {
    }

    public int getCodice() {
        return Codice;
    }

    public Stato getStato() {
        return Stato;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public String getAzioniContenimento() {
        return AzioniContenimento;
    }

    public String getAzioniCorrettive() {
        return AzioniCorrettive;
    }

    public String getAzioniPreventive() {
        return AzioniPreventive;
    }

    public Date getDataApertura() {
        return DataApertura;
    }

    public Date getDataChiusura() {
        return DataChiusura;
    }

    public String getCause() {
        return Cause;
    }

    public int getGravita() {
        return Gravita;
    }

    public double getCosto() {
        return Costo;
    }

    public Tipo getTipo() {
        return Tipo;
    }

    public Fornitore getFornitore() {
        return Fornitore;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public Reparto getReparto() {
        return Reparto;
    }

    public Dipendente getDipendente() {
        return Dipendente;
    }

    public List<Elaborazione> getElaborazioni() {
        return Elaborazioni;
    }

    public List<Pezzo> getPezziCorrelati() {
        return PezziCorrelati;
    }

    public List<Dipendente> getTeam() {
        return Team;
    }

    public void setCodice(int Codice) {
        this.Codice = Codice;
    }

    public void setStato(Stato Stato) {
        this.Stato = Stato;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    public void setAzioniContenimento(String AzioniContenimento) {
        this.AzioniContenimento = AzioniContenimento;
    }

    public void setAzioniCorrettive(String AzioniCorrettive) {
        this.AzioniCorrettive = AzioniCorrettive;
    }

    public void setAzioniPreventive(String AzioniPreventive) {
        this.AzioniPreventive = AzioniPreventive;
    }

    public void setDataApertura(Date DataApertura) {
        this.DataApertura = DataApertura;
    }

    public void setDataChiusura(Date DataChiusura) {
        this.DataChiusura = DataChiusura;
    }

    public void setCause(String Cause) {
        this.Cause = Cause;
    }

    public void setGravita(int Gravita) {
        this.Gravita = Gravita;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    public void setTipo(Tipo Tipo) {
        this.Tipo = Tipo;
    }

    public void setFornitore(Fornitore Fornitore) {
        this.Fornitore = Fornitore;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public void setReparto(Reparto Reparto) {
        this.Reparto = Reparto;
    }

    public void setDipendente(Dipendente Dipendente) {
        this.Dipendente = Dipendente;
    }

    public void setElaborazioni(List<Elaborazione> Elaborazioni) {
        this.Elaborazioni = Elaborazioni;
    }

    public void setPezziCorrelati(List<Pezzo> PezziCorrelati) {
        this.PezziCorrelati = PezziCorrelati;
    }

    public void setTeam(List<Dipendente> Team) {
        this.Team = Team;
    }

    @Override
    public String toString() {
        return "NonConformita{" + "Codice=" + Codice + ", Stato=" + Stato + ", Descrizione=" + Descrizione + ", AzioniContenimento=" + AzioniContenimento + ", AzioniCorrettive=" + AzioniCorrettive + ", AzioniPreventive=" + AzioniPreventive + ", DataApertura=" + DataApertura + ", DataChiusura=" + DataChiusura + ", Cause=" + Cause + ", Gravita=" + Gravita + ", Costo=" + Costo + ", Tipo=" + Tipo + ", Fornitore=" + Fornitore + ", Cliente=" + Cliente + ", Reparto=" + Reparto + ", Dipendente=" + Dipendente + ", Elaborazioni=" + Elaborazioni + ", PezziCorrelati=" + PezziCorrelati + ", Team=" + Team + '}';
    }
    
    
}
