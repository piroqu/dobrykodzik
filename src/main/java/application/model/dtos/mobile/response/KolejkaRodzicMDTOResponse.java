package application.model.dtos.mobile.response;

import application.model.Queue;

import java.io.Serializable;

/**
 * Created by PiroACC on 2015-11-30.
 */
public class KolejkaRodzicMDTOResponse implements Serializable{

    private String typZadanie;
    private Integer dzieckodzieckoId;


    public KolejkaRodzicMDTOResponse(Queue queue) {
        this.typZadanie = queue.getTask().getName();
        this.dzieckodzieckoId = queue.getChild().getChildId();
    }

    public String getTypZadanie() {
        return typZadanie;
    }

    public void setTypZadanie(String typZadanie) {
        this.typZadanie = typZadanie;
    }

    public int getDzieckodzieckoId() {
        return dzieckodzieckoId;
    }

    public void setDzieckodzieckoId(int dzieckodzieckoId) {
        this.dzieckodzieckoId = dzieckodzieckoId;
    }
}
