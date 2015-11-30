package application.model;
// Generated 2015-11-30 11:42:17 by Hibernate Tools 4.3.1.Final

import application.model.dtos.mobile.request.RodzicMDTORequest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Rodzic generated by hbm2java
 */
@Entity
@Table(name = "rodzic", catalog = "praca_schema", uniqueConstraints = @UniqueConstraint(columnNames = "email") )
public class Rodzic implements java.io.Serializable {

	private Integer rodzicId;
	private Date dataUtworzenia;
	private String haslo;
	private boolean status;
	private String email;
	private String numerTelefonu;
	private String imie;
	private Set<Dziecko> dzieckos = new HashSet<Dziecko>(0);
	private Set<Kolejka> kolejkas = new HashSet<Kolejka>(0);

	public Rodzic() {
	}

	public Rodzic(RodzicMDTORequest rodzicMDTORequest) {
		this.dataUtworzenia = rodzicMDTORequest.getDataUtworzenia();
		this.imie = rodzicMDTORequest.getImie();
		this.haslo = rodzicMDTORequest.getHaslo();
		this.status = rodzicMDTORequest.isStatus();
		this.email = rodzicMDTORequest.getEmail();
		this.numerTelefonu = rodzicMDTORequest.getNumerTelefonu();

	}


	public Rodzic(Date dataUtworzenia, String haslo, boolean status, String email, String numerTelefonu, String imie) {
		this.dataUtworzenia = dataUtworzenia;
		this.haslo = haslo;
		this.status = status;
		this.email = email;
		this.numerTelefonu = numerTelefonu;
		this.imie = imie;
	}

	public Rodzic(Date dataUtworzenia, String haslo, boolean status, String email, String numerTelefonu, String imie,
			Set<Dziecko> dzieckos, Set<Kolejka> kolejkas) {
		this.dataUtworzenia = dataUtworzenia;
		this.haslo = haslo;
		this.status = status;
		this.email = email;
		this.numerTelefonu = numerTelefonu;
		this.imie = imie;
		this.dzieckos = dzieckos;
		this.kolejkas = kolejkas;
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

	public void setDataUtworzenia(Date dataUtworzenia) {
		this.dataUtworzenia = dataUtworzenia;
	}

	@Column(name = "haslo", nullable = false)
	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "email", unique = true, nullable = false)
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

	@Column(name = "imie", nullable = false)
	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rodzic_dziecko", catalog = "praca_schema", joinColumns = {
			@JoinColumn(name = "rodzicrodzic_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "dzieckodziecko_id", nullable = false, updatable = false) })
	public Set<Dziecko> getDzieckos() {
		return this.dzieckos;
	}

	public void setDzieckos(Set<Dziecko> dzieckos) {
		this.dzieckos = dzieckos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rodzic")
	public Set<Kolejka> getKolejkas() {
		return this.kolejkas;
	}

	public void setKolejkas(Set<Kolejka> kolejkas) {
		this.kolejkas = kolejkas;
	}

}
