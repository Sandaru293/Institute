package entity;

public class Course {
    private String couId;
    private String couName;
    private Double fee;

    public Course(){}

    public Course(String couId, String couName, Double fee) {
        this.couId = couId;
        this.couName = couName;
        this.fee = fee;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
