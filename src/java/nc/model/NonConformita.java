package nc.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
    @Column(name="Codice")
    private int codice;
    @Enumerated(EnumType.STRING)
    @Column(name="Stato")
    private Stato stato;
    @Column(name="Descrizione")
    private String descrizione;
    @Column(name="AzioniContenimento")
    private String azioniContenimento;
    @Column(name="AzioniCorrettive")
    private String azioniCorrettive;
    @Column(name="AzioniPreventive")
    private String azioniPreventive;
    @Column(name="DataApertura")
    private Date dataApertura;
    @Column(name="DataChiusura")
    private Date dataChiusura;
    @Column(name="Cause")
    private String cause;
    @Column(name="Gravita")
    private int gravita;
    @Column(name="Costo")
    private double costo;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Tipo")
    private Tipo tipo;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PivaFornitore")
    private Fornitore fornitore;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PivaCliente")
    private Cliente cliente;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDReparto")
    private Reparto reparto;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="MatricolaDipendente")
    private Dipendente dipendente;
    @OneToMany(fetch=FetchType.EAGER,mappedBy="nonConformita")
    private Set<Elaborazione> elaborazioni; 
    @ManyToMany(fetch=FetchType.EAGER,mappedBy="pezziNC")
    private Set<Pezzo> pezziCorrelati;
    @ManyToMany(fetch=FetchType.EAGER,mappedBy="parteTeam")
    private Set<Dipendente> team;

    public NonConformita() {
    }

    public int getCodice() {
        return codice;
    }

    public Stato getStato() {
        return stato;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getAzioniContenimento() {
        return azioniContenimento;
    }

    public String getAzioniCorrettive() {
        return azioniCorrettive;
    }

    public String getAzioniPreventive() {
        return azioniPreventive;
    }

    public Date getDataApertura() {
        return dataApertura;
    }

    public Date getDataChiusura() {
        return dataChiusura;
    }

    public String getCause() {
        return cause;
    }

    public int getGravita() {
        return gravita;
    }

    public double getCosto() {
        return costo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public Set<Elaborazione> getElaborazioni() {
        return elaborazioni;
    }

    public Set<Pezzo> getPezziCorrelati() {
        return pezziCorrelati;
    }

    public Set<Dipendente> getTeam() {
        return team;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setAzioniContenimento(String azioniContenimento) {
        this.azioniContenimento = azioniContenimento;
    }

    public void setAzioniCorrettive(String azioniCorrettive) {
        this.azioniCorrettive = azioniCorrettive;
    }

    public void setAzioniPreventive(String azioniPreventive) {
        this.azioniPreventive = azioniPreventive;
    }

    public void setDataApertura(Date dataApertura) {
        this.dataApertura = dataApertura;
    }

    public void setDataChiusura(Date dataChiusura) {
        this.dataChiusura = dataChiusura;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setGravita(int gravita) {
        this.gravita = gravita;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public void setElaborazioni(Set<Elaborazione> elaborazioni) {
        this.elaborazioni = elaborazioni;
    }

    public void setPezziCorrelati(Set<Pezzo> pezziCorrelati) {
        this.pezziCorrelati = pezziCorrelati;
    }

    public void setTeam(Set<Dipendente> team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "NonConformita{" + "codice=" + codice + ", stato=" + stato + ", descrizione=" + descrizione + ", azioniContenimento=" + azioniContenimento + ", azioniCorrettive=" + azioniCorrettive + ", azioniPreventive=" + azioniPreventive + ", dataApertura=" + dataApertura + ", dataChiusura=" + dataChiusura + ", cause=" + cause + ", gravita=" + gravita + ", costo=" + costo + ", tipo=" + tipo + ", fornitore=" + fornitore + ", cliente=" + cliente + ", reparto=" + reparto + ", dipendente=" + dipendente + ", elaborazioni=" + elaborazioni + ", pezziCorrelati=" + pezziCorrelati + ", team=" + team + '}';
    }

}
