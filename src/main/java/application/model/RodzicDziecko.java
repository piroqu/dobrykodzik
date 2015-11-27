package application.model;
// Generated 2015-11-27 15:23:14 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RodzicDziecko generated by hbm2java
 */
@Entity
@Table(name = "rodzic_dziecko", catalog = "praca_schema")
public class RodzicDziecko implements java.io.Serializable {

	private RodzicDzieckoId id;
	private Dziecko dziecko;
	private Rodzic rodzic;
	private Set<Kolejka> kolejkas = new HashSet<Kolejka>(0);

	public RodzicDziecko() {
	}

	public RodzicDziecko(RodzicDzieckoId id, Dziecko dziecko, Rodzic rodzic) {
		this.id = id;
		this.dziecko = dziecko;
		this.rodzic = rodzic;
	}

	public RodzicDziecko(RodzicDzieckoId id, Dziecko dziecko, Rodzic rodzic, Set<Kolejka> kolejkas) {
		this.id = id;
		this.dziecko = dziecko;
		this.rodzic = rodzic;
		this.kolejkas = kolejkas;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "rodzicrodzicId", column = @Column(name = "rodzicrodzic_id", nullable = false) ),
			@AttributeOverride(name = "dzieckodzieckoId", column = @Column(name = "dzieckodziecko_id", nullable = false) ) })
	public RodzicDzieckoId getId() {
		return this.id;
	}

	public void setId(RodzicDzieckoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dzieckodziecko_id", nullable = false, insertable = false, updatable = false)
	public Dziecko getDziecko() {
		return this.dziecko;
	}

	public void setDziecko(Dziecko dziecko) {
		this.dziecko = dziecko;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rodzicrodzic_id", nullable = false, insertable = false, updatable = false)
	public Rodzic getRodzic() {
		return this.rodzic;
	}

	public void setRodzic(Rodzic rodzic) {
		this.rodzic = rodzic;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rodzicDziecko")
	public Set<Kolejka> getKolejkas() {
		return this.kolejkas;
	}

	public void setKolejkas(Set<Kolejka> kolejkas) {
		this.kolejkas = kolejkas;
	}

}
