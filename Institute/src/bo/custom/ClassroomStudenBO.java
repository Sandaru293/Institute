package bo.custom;

import bo.SuperBO;
import dto.ClassroomStudentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ClassroomStudenBO extends SuperBO {
    boolean addClassroomStudent(ClassroomStudentDTO classroomStudent)throws ClassNotFoundException, SQLException;

    ObservableList<ClassroomStudentDTO> getAllClassroomStudent()throws ClassNotFoundException, SQLException;

    boolean deleteclassroomStuden(String id)throws ClassNotFoundException, SQLException;

    boolean updateClassroomStudent(ClassroomStudentDTO classroomStudent)throws ClassNotFoundException, SQLException;

    ClassroomStudentDTO searchClassroomStudent(String id)throws ClassNotFoundException, SQLException;
}
