package entity;

public class Payment {
    private String payId;
    private String couId;
    private String regId;
    private String stuId;

    public Payment(){}

    public Payment(String payId, String couId, String regId, String stuId) {
        this.payId = payId;
        this.couId = couId;
        this.regId = regId;
        this.stuId = stuId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }
}
