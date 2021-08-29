package bo.custom;

import bo.SuperBO;
import dto.TeacherDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface TeacherBO extends SuperBO {

    boolean addTeacher(TeacherDTO teacher)throws ClassNotFoundException, SQLException;

    ObservableList<TeacherDTO> getAllTeacher()throws ClassNotFoundException, SQLException;

    TeacherDTO searchTeacher(String id)throws ClassNotFoundException, SQLException;

    boolean deleteTeacher(String id)throws ClassNotFoundException, SQLException;

    boolean updateTeacher(TeacherDTO teacher)throws ClassNotFoundException, SQLException;
}
