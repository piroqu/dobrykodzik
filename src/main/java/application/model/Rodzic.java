package application.model;
// Generated 2015-11-23 23:39:49 by Hibernate Tools 4.0.0.Final

import application.model.dtos.mobile.RodzicMDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rodzic generated by hbm2java
 */
@Entity
@Table(name = "rodzic", catalog = "praca_schema")
public class Rodzic implements java.io.Serializable {

    private Integer rodzicId;
    private Date dataUtworzenia;
    private String haslo;
    private String imie;
    private boolean status;
    private String email;
    private String numerTelefonu;
    private Set<RodzicDziecko> rodzicDzieckos = new HashSet<RodzicDziecko>(0);

    public Rodzic() {
    }

    public Rodzic(RodzicMDTO rodzicMDTO) {
		this.dataUtworzenia = rodzicMDTO.getDataUtworzenia();
        this.imie = rodzicMDTO.getImie();
        this.haslo = rodzicMDTO.getHaslo();
        this.status = rodzicMDTO.isStatus();
        this.email = rodzicMDTO.getEmail();
        this.numerTelefonu = rodzicMDTO.getNumerTelefonu();

    }

    public Rodzic(Date dataUtworzenia, String haslo, boolean status, String email, String numerTelefonu) {
        this.dataUtworzenia = dataUtworzenia;
        this.haslo = haslo;
        this.status = status;
        this.email = email;
        this.numerTelefonu = numerTelefonu;
    }

    public Rodzic(Date creationDate, String haslo, boolean status, String email, String numerTelefonu,
                  Set<RodzicDziecko> rodzicDzieckos) {
        this.dataUtworzenia = creationDate;
        this.haslo = haslo;
        this.status = status;
        this.email = email;
        this.numerTelefonu = numerTelefonu;
        this.rodzicDzieckos = rodzicDzieckos;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "rodzic_id", unique = true, nullable = false)
    public Integer getRodzicId() {
        return this.rodzicId;
    }

    public void setRodzicId(Integer rodzicId) {
        this.rodzicId = rodzicId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_utworzenia", nullable = false, length = 19)
    public Date getDataUtworzenia() {
        return this.dataUtworzenia;
    }

    public void setDataUtworzenia(Date creationDate) {
        this.dataUtworzenia = creationDate;
    }

    @Column(name = "haslo", nullable = false)
    public String getHaslo() {
        return this.haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Column(name = "imie", nullable = false)
    public String getImie() {
        return this.imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "numer_telefonu", nullable = false, length = 20)
    public String getNumerTelefonu() {
        return this.numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rodzic")
    public Set<RodzicDziecko> getRodzicDzieckos() {
        return this.rodzicDzieckos;
    }

    public void setRodzicDzieckos(Set<RodzicDziecko> rodzicDzieckos) {
        this.rodzicDzieckos = rodzicDzieckos;
    }

}
