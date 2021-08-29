package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface RegisterBO extends SuperBO {
    StudentDTO searchStudent(String id)throws ClassNotFoundException, SQLException, SQLException;

    ObservableList<StudentDTO> getAllStudent()throws ClassNotFoundException, SQLException, SQLException;
}
