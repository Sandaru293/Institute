package bo.custom;

import bo.SuperBO;
import dto.CourseClassroomDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CourseClassroomBO extends SuperBO {
    boolean addCourseClassroom(CourseClassroomDTO courseClassroom)throws ClassNotFoundException, SQLException;

    ObservableList<CourseClassroomDTO> getAllCourseClassroom()throws ClassNotFoundException, SQLException;

    CourseClassroomDTO searchCourseClassroom(String id)throws ClassNotFoundException, SQLException;

    boolean deletecourseClassroom(String id)throws ClassNotFoundException, SQLException;

    boolean updatecourseClassroom(CourseClassroomDTO courseClassroom)throws ClassNotFoundException, SQLException;
}
