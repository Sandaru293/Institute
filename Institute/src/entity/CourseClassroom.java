package entity;

public class CourseClassroom {
    private String couId;
    private String claId;

    public CourseClassroom(){}

    public CourseClassroom(String couId, String claId) {
        this.couId = couId;
        this.claId = claId;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getClaId() {
        return claId;
    }

    public void setClaId(String claId) {
        this.claId = claId;
    }
}
