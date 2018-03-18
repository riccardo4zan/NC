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
    private int Matricola;
    @Column(nullable = false)
    private String Nome;
    @Column(nullable = false)
    private String Cognome;
    @Column(nullable = false)
    private String Password;
    @Column(nullable = false)
    @Enumerated
    private Ruolo Ruolo;
    @ManyToOne
    @JoinColumn(name="Reparto")
    private Reparto Reparto;
    @OneToMany(mappedBy = "Dipendente")
    private List<Segnalazione> Segnalazioni;
    @OneToMany(mappedBy="Dipendente")
    private List<NonConformita> Aperte;
    @OneToMany(mappedBy="Dipendente")
    private List<Elaborazione> ElaborazioniEffettuate;
    @ManyToMany
    @JoinTable(
            name = "CTeam",
            joinColumns = {@JoinColumn(name = "MatricolaDipendente")},
            inverseJoinColumns = {@JoinColumn(name = "CodiceNC")}
    )
    private List<NonConformita> ParteTeam;

    public Dipendente() {
    }

    public int getMatricola() {
        return Matricola;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public String getPassword() {
        return Password;
    }

    public Ruolo getRuolo() {
        return Ruolo;
    }

    public Reparto getReparto() {
        return Reparto;
    }

    public List<Segnalazione> getSegnalazioni() {
        return Segnalazioni;
    }

    public List<NonConformita> getAperte() {
        return Aperte;
    }

    public List<Elaborazione> getElaborazioniEffettuate() {
        return ElaborazioniEffettuate;
    }

    public List<NonConformita> getParteTeam() {
        return ParteTeam;
    }

    public void setMatricola(int Matricola) {
        this.Matricola = Matricola;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setCognome(String Cognome) {
        this.Cognome = Cognome;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setRuolo(Ruolo Ruolo) {
        this.Ruolo = Ruolo;
    }

    public void setReparto(Reparto Reparto) {
        this.Reparto = Reparto;
    }

    public void setSegnalazioni(List<Segnalazione> Segnalazioni) {
        this.Segnalazioni = Segnalazioni;
    }

    public void setAperte(List<NonConformita> Aperte) {
        this.Aperte = Aperte;
    }

    public void setElaborazioniEffettuate(List<Elaborazione> ElaborazioniEffettuate) {
        this.ElaborazioniEffettuate = ElaborazioniEffettuate;
    }

    public void setParteTeam(List<NonConformita> ParteTeam) {
        this.ParteTeam = ParteTeam;
    }

    @Override
    public String toString() {
        return "Dipendente{" + "Matricola=" + Matricola + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Password=" + Password + ", Ruolo=" + Ruolo + ", Reparto=" + Reparto + ", Segnalazioni=" + Segnalazioni + ", Aperte=" + Aperte + ", ElaborazioniEffettuate=" + ElaborazioniEffettuate + ", ParteTeam=" + ParteTeam + '}';
    }
    
}
