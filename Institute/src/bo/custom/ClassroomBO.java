package bo.custom;

import bo.SuperBO;
import dto.ClassroomDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ClassroomBO extends SuperBO {
    boolean addClassroom(ClassroomDTO classroom)throws ClassNotFoundException, SQLException;

    ClassroomDTO searchClassroom(String id)throws ClassNotFoundException, SQLException;

    ObservableList<ClassroomDTO> getAllClassroom()throws ClassNotFoundException, SQLException;

    boolean deleteClassroom(String id)throws ClassNotFoundException, SQLException;

    boolean updateClassroom(ClassroomDTO classroom)throws ClassNotFoundException, SQLException;
}
