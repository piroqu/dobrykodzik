package application.model.dtos.mobile.response;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by PiroACC on 2015-11-29.
 */
public class PozycjaMDTOResponse implements Serializable {
    private Integer pozycjaId;
    private double dlugoscGeograficzna;
    private double szerokoscGeograficzna;
    private Date czas;

    public PozycjaMDTOResponse() {
    }

    @Override
    public String toString() {
        return "PozycjaMDTOResponse{" +
                "pozycjaId=" + pozycjaId +
                ", dlugoscGeograficzna=" + dlugoscGeograficzna +
                ", szerokoscGeograficzna=" + szerokoscGeograficzna +
                ", czas=" + czas +
                '}';
    }

    public PozycjaMDTOResponse(Integer pozycjaId, double dlugoscGeograficzna, double szerokoscGeograficzna, Date czas) {
        this.pozycjaId = pozycjaId;
        this.dlugoscGeograficzna = dlugoscGeograficzna;
        this.szerokoscGeograficzna = szerokoscGeograficzna;
        this.czas = czas;
    }

    public Integer getPozycjaId() {
        return pozycjaId;
    }

    public void setPozycjaId(Integer pozycjaId) {
        this.pozycjaId = pozycjaId;
    }

    public double getDlugoscGeograficzna() {
        return dlugoscGeograficzna;
    }

    public void setDlugoscGeograficzna(double dlugoscGeograficzna) {
        this.dlugoscGeograficzna = dlugoscGeograficzna;
    }

    public double getSzerokoscGeograficzna() {
        return szerokoscGeograficzna;
    }

    public void setSzerokoscGeograficzna(double szerokoscGeograficzna) {
        this.szerokoscGeograficzna = szerokoscGeograficzna;
    }

    public Date getCzas() {
        return czas;
    }

    public void setCzas(Date czas) {
        this.czas = czas;
    }
}
