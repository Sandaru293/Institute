package dto;

public class ClassroomStudentDTO {
    private String claId;
    private String stuId;

    public ClassroomStudentDTO(){}

    public ClassroomStudentDTO(String claId, String stuId) {
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
