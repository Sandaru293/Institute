package bo.custom.impl;

import bo.custom.ExamBO;
import dao.DAOFactory;
import dao.custom.ExamDAO;
import dto.ExamDTO;
import entity.Exam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ExamBOImpl implements ExamBO {
    ExamDAO e = (ExamDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAM);

    @Override
    public ObservableList<ExamDTO> getAllExam() throws ClassNotFoundException, SQLException {
        ObservableList<Exam> exams = e.getAll();
        ObservableList<ExamDTO> list = FXCollections.observableArrayList();
        for(Exam e : exams){
            list.add(new ExamDTO(e.getExaId(),e.getExaName(),e.getStart_date()));
        }
        return list;
    }

    @Override
    public ExamDTO searchExam(String id) throws ClassNotFoundException, SQLException {
        Exam exa = e.search(id);
        return new ExamDTO(exa.getExaId(),exa.getExaName(),exa.getStart_date());
    }

    @Override
    public boolean addExam(ExamDTO exam) throws ClassNotFoundException, SQLException {
        Exam exa = new Exam(exam.getExaId(),exam.getExaName(),exam.getStart_date());
        return e.add(exa);
    }

    @Override
    public boolean deleteExam(String id) throws ClassNotFoundException, SQLException {
        return e.delete(id);
    }

    @Override
    public boolean updateExam(ExamDTO exam) throws ClassNotFoundException, SQLException {
        Exam exa = new Exam(exam.getExaId(),exam.getExaName(),exam.getStart_date());
        return e.update(exa);
    }
}
