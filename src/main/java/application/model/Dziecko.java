package application.model;
// Generated 2015-11-27 15:23:14 by Hibernate Tools 4.3.1.Final

import application.helper.DateParser;
import application.model.dtos.mobile.request.DzieckoMDTORequest;

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
 * Dziecko generated by hbm2java
 */
@Entity
@Table(name = "dziecko", catalog = "praca_schema")
public class Dziecko implements java.io.Serializable {

	private Integer dzieckoId;
	private Date dataUtworzenia;
	private String haslo;
	private boolean status;
	private String imie;
	private Set<Pozycja> pozycjas = new HashSet<Pozycja>(0);
	private Set<RodzicDziecko> rodzicDzieckos = new HashSet<RodzicDziecko>(0);

	public Dziecko() {
	}

	public Dziecko(DzieckoMDTORequest dzieckoMDTORequest){
		this.dataUtworzenia= DateParser.getCurrentParsedDate();
		this.haslo= dzieckoMDTORequest.getHaslo();
		this.status= dzieckoMDTORequest.isStatus();
		this.imie= dzieckoMDTORequest.getImie();
	}

	public Dziecko(Date dataUtworzenia, String haslo, boolean status, String imie) {
		this.dataUtworzenia = dataUtworzenia;
		this.haslo = haslo;
		this.status = status;
		this.imie = imie;
	}

	public Dziecko(Date dataUtworzenia, String haslo, boolean status, String imie, Set<Pozycja> pozycjas,
			Set<RodzicDziecko> rodzicDzieckos) {
		this.dataUtworzenia = dataUtworzenia;
		this.haslo = haslo;
		this.status = status;
		this.imie = imie;
		this.pozycjas = pozycjas;
		this.rodzicDzieckos = rodzicDzieckos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "dziecko_id", unique = true, nullable = false)
	public Integer getDzieckoId() {
		return this.dzieckoId;
	}

	public void setDzieckoId(Integer dzieckoId) {
		this.dzieckoId = dzieckoId;
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

	@Column(name = "imie", nullable = false)
	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dziecko")
	public Set<Pozycja> getPozycjas() {
		return this.pozycjas;
	}

	public void setPozycjas(Set<Pozycja> pozycjas) {
		this.pozycjas = pozycjas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dziecko")
	public Set<RodzicDziecko> getRodzicDzieckos() {
		return this.rodzicDzieckos;
	}

	public void setRodzicDzieckos(Set<RodzicDziecko> rodzicDzieckos) {
		this.rodzicDzieckos = rodzicDzieckos;
	}

}
