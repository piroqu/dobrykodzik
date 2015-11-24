package application.model.dtos;

import application.model.Dziecko;

import java.util.Date;

/**
 * Created by PiroACC on 2015-11-24.
 */
public class DzieckoDTO implements java.io.Serializable{
    private Integer dzieckoId;
    private Date dataUtworzenia;
    private String haslo;

    public void setDzieckoId(Integer dzieckoId) {
        this.dzieckoId = dzieckoId;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getDzieckoId() {

        return dzieckoId;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public boolean isStatus() {
        return status;
    }

    public String getHaslo() {
        return haslo;
    }

    private boolean status;

    public DzieckoDTO(Dziecko dziecko) {
        this.dzieckoId = dziecko.getDzieckoId();
        this.dataUtworzenia = dziecko.getDataUtworzenia();
        this.haslo=dziecko.getHaslo();
        this.status=dziecko.isStatus();
    }
}
