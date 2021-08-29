package dto;

import entity.Classroom;

public class ClassroomDTO {
    private String claId;
    private String teaId;

    public ClassroomDTO(){}

    public ClassroomDTO(String claId, String teaId) {
        this.claId = claId;
        this.teaId = teaId;
    }

    public String getClaId() {
        return claId;
    }

    public void setClaId(String claId) {
        this.claId = claId;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }


}
