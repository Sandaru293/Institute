package entity;

public class Exam {
    private String exaId;
    private String exaName;
    private String start_date;

    public Exam(){}

    public Exam(String exaId, String exaName, String start_date) {
        this.exaId = exaId;
        this.exaName = exaName;
        this.start_date = start_date;
    }

    public String getExaId() {
        return exaId;
    }

    public void setExaId(String exaId) {
        this.exaId = exaId;
    }

    public String getExaName() {
        return exaName;
    }

    public void setExaName(String exaName) {
        this.exaName = exaName;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
}
