package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CourseBO extends SuperBO {

    boolean addCourse(CourseDTO course)throws ClassNotFoundException, SQLException;

    CourseDTO searchCourse(String id)throws ClassNotFoundException, SQLException;

    ObservableList<CourseDTO> getAllCourse()throws ClassNotFoundException, SQLException;

    boolean deleteCourse(String id)throws ClassNotFoundException, SQLException;

    boolean updateCourse(CourseDTO course)throws ClassNotFoundException, SQLException;
}
