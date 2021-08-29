package entity;

public class StudentDepartment {
    private String stuId;
    private String depId;
    private Double salary;

    public StudentDepartment(){}

    public StudentDepartment(String stuId, String depId, Double salary) {
        this.stuId = stuId;
        this.depId = depId;
        this.salary = salary;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
