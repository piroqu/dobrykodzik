package application.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by PiroACC on 2015-11-14.
 */
@Entity
@Table(name = "pokemon", schema = "", catalog = "myschema")
public class PokemonEntity implements Serializable {
    private int idpokemon;
    private String name;

    @Id
    @Column(name = "idpokemon", nullable = false, insertable = true, updatable = true)
    public int getIdpokemon() {
        return idpokemon;
    }

    public void setIdpokemon(int idpokemon) {
        this.idpokemon = idpokemon;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonEntity that = (PokemonEntity) o;

        if (idpokemon != that.idpokemon) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpokemon;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
