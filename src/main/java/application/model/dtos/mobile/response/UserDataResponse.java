package application.model.dtos.mobile.response;

import application.helper.DateParser;
import application.model.Child;
import application.model.Parent;

import java.util.Date;

/**
 * Created by PiroACC on 2015-11-30.
 */
public class UserDataResponse {

    private Integer id;
    private String name;
    private String creation_date;
    private String email;
    private String role;

    public UserDataResponse() {

    }
    @Override
    public String toString() {
        return "UserDataResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creation_date=" + creation_date +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDataResponse(Parent parent) {
        this.id = parent.getParentId();
        this.name = parent.getName();
        this.creation_date = DateParser.parseDateToString(parent.getCreationDate());
        this.email = parent.getEmail();
    }

    public UserDataResponse(Child child) {
        this.id = child.getChildId();
        this.name = child.getName();
        this.creation_date = DateParser.parseDateToString(child.getCreationDate());
        this.email = child.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
