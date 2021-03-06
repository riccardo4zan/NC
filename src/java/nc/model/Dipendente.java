package nc.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @Enumerated(EnumType.STRING) 
    @ManyToOne
    @JoinColumn(name="Reparto")
    private Reparto reparto;
    @OneToMany(fetch=FetchType.EAGER,mappedBy = "dipendente")
    private Set<Segnalazione> segnalazioni;
    @OneToMany(fetch=FetchType.EAGER,mappedBy="dipendente")
    private Set<NonConformita> aperte;
    @OneToMany(fetch=FetchType.EAGER,mappedBy="dipendente")
    private Set<Elaborazione> elaborazioniEffettuate;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "CTeam",
            joinColumns = {@JoinColumn(name = "MatricolaDipendente")},
            inverseJoinColumns = {@JoinColumn(name = "CodiceNC")}
    )
    private Set<NonConformita> parteTeam;
    @OneToOne
    @JoinColumn(name="Username")
    private User user;

    public Dipendente() {
    }

    public Dipendente(int matricola) {
        this.matricola = matricola;
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
    
    public Reparto getReparto() {
        return reparto;
    }

    public Set<Segnalazione> getSegnalazioni() {
        return segnalazioni;
    }

    public Set<NonConformita> getAperte() {
        return aperte;
    }

    public Set<Elaborazione> getElaborazioniEffettuate() {
        return elaborazioniEffettuate;
    }

    public Set<NonConformita> getParteTeam() {
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

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public void setSegnalazioni(Set<Segnalazione> segnalazioni) {
        this.segnalazioni = segnalazioni;
    }

    public void setAperte(Set<NonConformita> aperte) {
        this.aperte = aperte;
    }

    public void setElaborazioniEffettuate(Set<Elaborazione> elaborazioniEffettuate) {
        this.elaborazioniEffettuate = elaborazioniEffettuate;
    }

    public void setParteTeam(Set<NonConformita> parteTeam) {
        this.parteTeam = parteTeam;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Dipendente{" + "matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", reparto=" + reparto + ", segnalazioni=" + segnalazioni + ", aperte=" + aperte + ", elaborazioniEffettuate=" + elaborazioniEffettuate + ", parteTeam=" + parteTeam + ", user=" + user + '}';
    }

}
