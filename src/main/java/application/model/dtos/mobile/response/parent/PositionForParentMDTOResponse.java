package application.model.dtos.mobile.response.parent;

import application.helper.DateParser;
import application.model.Position;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by PiroACC on 2015-11-27.
 */
public class PositionForParentMDTOResponse implements Serializable {

    private double longitude;
    private double latitude;
    private String creationDate;

    public PositionForParentMDTOResponse(Position position){
        this.longitude=position.getLongitude();
        this.latitude=position.getLatitude();
        Date toParse = position.getCreationDate();
        this.creationDate= DateParser.parseDateToString(toParse);
    }

    @Override
    public String toString() {
        return "PositionMDTORequest{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}