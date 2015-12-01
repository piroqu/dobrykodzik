package application.model.dtos.mobile.response.parent;

import application.model.Child;

public class ParentChildMDTOResponse implements java.io.Serializable {

    private Integer childId;
    private String name;
    private String email;
    private String phoneNumber;


    public ParentChildMDTOResponse (Child child){
        this.childId = child.getChildId();
        this.name=child.getName();
        this.email= child.getEmail();
        this.phoneNumber=child.getPhoneNumber();
    }

    @Override
    public String toString() {
        return "Child{" +
                "childId=" + childId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
