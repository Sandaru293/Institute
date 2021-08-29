package entity;

public class ClassroomStudent {
    private String claId;
    private String stuId;

    public ClassroomStudent(){}

    public ClassroomStudent(String claId, String stuId) {
        this.claId = claId;
        this.stuId = stuId;
    }

    public String getClaId() {
        return claId;
    }

    public void setClaId(String claId) {
        this.claId = claId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }
}
