package dto;

public class DepartmentDTO {
    private String depId;
    private String depName;

    public DepartmentDTO(){}

    public DepartmentDTO(String depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
