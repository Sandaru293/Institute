package dto;

public class ExamResultDTO {
    private String stuId;
    private String exaId;
    private String couId;
    private String mark;

    public ExamResultDTO(){}

    public ExamResultDTO(String stuId, String exaId, String couId, String mark) {
        this.stuId = stuId;
        this.exaId = exaId;
        this.couId = couId;
        this.mark = mark;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getExaId() {
        return exaId;
    }

    public void setExaId(String exaId) {
        this.exaId = exaId;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
