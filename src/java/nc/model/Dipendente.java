package nc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author riccardo
 */
@Entity
@Table(name="Dipendenti")
public class Dipendente implements Serializable {
    @Id @GeneratedValue 
    @Column(name="Matricola")
    private int matricola;
    @Column(name="Nome")
    private String nome;
    @Column(name="Cognome")
    private String cognome;
    @Column(name="Password")
    private String password;
    @Enumerated 
    @Column(name="Ruolo")
    private Ruolo ruolo;
    @ManyToOne
    @JoinColumn(name="Reparto")
    private Reparto reparto;
    @OneToMany(mappedBy = "dipendente")
    private List<Segnalazione> segnalazioni;
    @OneToMany(mappedBy="dipendente")
    private List<NonConformita> aperte;
    @OneToMany(mappedBy="dipendente")
    private List<Elaborazione> elaborazioniEffettuate;
    @ManyToMany
    @JoinTable(
            name = "CTeam",
            joinColumns = {@JoinColumn(name = "MatricolaDipendente")},
            inverseJoinColumns = {@JoinColumn(name = "CodiceNC")}
    )
    private List<NonConformita> parteTeam;

    public Dipendente() {
    }

    public int getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getPassword() {
        return password;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public List<Segnalazione> getSegnalazioni() {
        return segnalazioni;
    }

    public List<NonConformita> getAperte() {
        return aperte;
    }

    public List<Elaborazione> getElaborazioniEffettuate() {
        return elaborazioniEffettuate;
    }

    public List<NonConformita> getParteTeam() {
        return parteTeam;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public void setSegnalazioni(List<Segnalazione> segnalazioni) {
        this.segnalazioni = segnalazioni;
    }

    public void setAperte(List<NonConformita> aperte) {
        this.aperte = aperte;
    }

    public void setElaborazioniEffettuate(List<Elaborazione> elaborazioniEffettuate) {
        this.elaborazioniEffettuate = elaborazioniEffettuate;
    }

    public void setParteTeam(List<NonConformita> parteTeam) {
        this.parteTeam = parteTeam;
    }

    @Override
    public String toString() {
        return "Dipendente{" + "matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", password=" + password + ", ruolo=" + ruolo + ", reparto=" + reparto + ", segnalazioni=" + segnalazioni + ", aperte=" + aperte + ", elaborazioniEffettuate=" + elaborazioniEffettuate + ", parteTeam=" + parteTeam + '}';
    }
    
}
