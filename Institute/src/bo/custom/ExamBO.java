package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;
import dto.ExamDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ExamBO extends SuperBO {
    ObservableList<ExamDTO> getAllExam()throws ClassNotFoundException, SQLException;

    ExamDTO searchExam(String id)throws ClassNotFoundException, SQLException;

    boolean addExam(ExamDTO exam)throws ClassNotFoundException, SQLException;

    boolean deleteExam(String id)throws ClassNotFoundException, SQLException;

    boolean updateExam(ExamDTO exam)throws ClassNotFoundException, SQLException;
}
