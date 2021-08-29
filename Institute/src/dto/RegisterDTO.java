package dto;

public class RegisterDTO {
    private String regId;
    private String couId;
    private String date;

    public RegisterDTO(){}

    public RegisterDTO(String regId, String couId, String date) {
        this.regId = regId;
        this.couId = couId;
        this.date = date;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
