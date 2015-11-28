package application.model.dtos.mobile.response;

public class DzieckoMDTOResponse implements java.io.Serializable {

    private Integer dzieckoId;

    public Integer getDzieckoId() {
        return dzieckoId;
    }

    public void setDzieckoId(Integer dzieckoId) {
        this.dzieckoId = dzieckoId;
    }

    @Override
    public String toString() {
        return "DzieckoMDTOR{" +
                "dzieckoId=" + dzieckoId +
                '}';
    }
}
