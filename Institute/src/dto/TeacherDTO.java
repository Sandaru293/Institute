package dto;

public class TeacherDTO {
    private String teaId;
    private String teaName;
    private String teaTelNo;
    private String teaEmail;

    public TeacherDTO(String text, String txtTeaIdText){

    }

    public TeacherDTO(String teaId, String teaName, String teaTelNo, String teaEmail) {
        this.teaId = teaId;
        this.teaName = teaName;
        this.teaTelNo = teaTelNo;
        this.teaEmail = teaEmail;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaTelNo() {
        return teaTelNo;
    }

    public void setTeaTelNo(String teaTelNo) {
        this.teaTelNo = teaTelNo;
    }

    public String getTeaEmail() {
        return teaEmail;
    }

    public void setTeaEmail(String teaEmail) {
        this.teaEmail = teaEmail;
    }
}
