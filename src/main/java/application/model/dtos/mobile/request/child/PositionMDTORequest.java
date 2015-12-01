package application.model.dtos.mobile.request.child;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by PiroACC on 2015-11-27.
 */
public class PositionMDTORequest implements Serializable {

    private double longitude;
    private double latitude;
    private Date creationDate;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}