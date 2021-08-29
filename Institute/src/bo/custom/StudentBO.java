package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface StudentBO extends SuperBO {
    boolean addStudent(StudentDTO student)throws ClassNotFoundException, SQLException;

    boolean deleteStudent(String id)throws ClassNotFoundException, SQLException;

    StudentDTO searchStudent(String id)throws ClassNotFoundException, SQLException;

    ObservableList<StudentDTO> getAllStudent()throws ClassNotFoundException, SQLException;

    boolean updateStudent(StudentDTO student)throws ClassNotFoundException, SQLException;
}
