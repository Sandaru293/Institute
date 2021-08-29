package entity;

public class Student {
    private String stuId;
    private String stuName;
    private String bod;
    private String address;
    private String stuEmail;
    private String stuTelNo;

    public Student(){

    }

    public Student(String stuId, String stuName, String bod, String address, String stuEmail, String stuTelNo) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.bod = bod;
        this.address = address;
        this.stuEmail = stuEmail;
        this.stuTelNo = stuTelNo;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuTelNo() {
        return stuTelNo;
    }

    public void setStuTelNo(String stuTelNo) {
        this.stuTelNo = stuTelNo;
    }
}
