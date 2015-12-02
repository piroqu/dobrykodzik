package application.model.dtos.mobile.request.common;

/**
 * Created by PiroACC on 2015-12-02.
 */
public class RegistrationResponse {

    String response;

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "response='" + response + '\'' +
                '}';
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
