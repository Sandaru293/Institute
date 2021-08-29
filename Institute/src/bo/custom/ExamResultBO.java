package bo.custom;

import bo.SuperBO;
import dto.ExamDTO;
import dto.ExamResultDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ExamResultBO extends SuperBO {

    boolean addExamResult(ExamResultDTO examResult)throws ClassNotFoundException, SQLException;

    ObservableList<ExamResultDTO> getAllExamResult()throws ClassNotFoundException, SQLException;

    ExamResultDTO searchExamResult(String id)throws ClassNotFoundException, SQLException;

    boolean updateExamResult(ExamResultDTO examResult)throws ClassNotFoundException, SQLException;
}
