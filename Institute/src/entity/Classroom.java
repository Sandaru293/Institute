package entity;

public class Classroom {
    private String claId;
    private String teaId;

    public Classroom(){}

    public Classroom(String claId, String teaId) {
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
