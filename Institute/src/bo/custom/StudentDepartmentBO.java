package bo.custom;

import bo.SuperBO;
import dto.DepartmentDTO;
import dto.StudentDepartmentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface StudentDepartmentBO extends SuperBO {
    boolean addStudentDepartment(StudentDepartmentDTO studentDepartment)throws ClassNotFoundException, SQLException;

    ObservableList<StudentDepartmentDTO> getAllStudentDepartment()throws ClassNotFoundException, SQLException;

    StudentDepartmentDTO searchStudentDepartment(String id)throws ClassNotFoundException, SQLException;

    boolean updateStudentDepartment(StudentDepartmentDTO studentDepartment)throws ClassNotFoundException, SQLException;
}
