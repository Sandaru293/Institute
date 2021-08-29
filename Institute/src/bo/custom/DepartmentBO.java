package bo.custom;

import bo.SuperBO;
import dto.DepartmentDTO;
import dto.ExamDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface DepartmentBO extends SuperBO {
    DepartmentDTO searchDepartment(String id)throws ClassNotFoundException, SQLException;

    ObservableList<DepartmentDTO> getAllDepartment()throws ClassNotFoundException, SQLException;
}
