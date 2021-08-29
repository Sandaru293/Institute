package bo.custom.impl;

import bo.custom.ExamResultBO;
import dao.DAOFactory;
import dao.custom.ExamResultDAO;
import dto.ExamDTO;
import dto.ExamResultDTO;
import entity.Exam;
import entity.ExamResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ExamResultBOImpl implements ExamResultBO {
    ExamResultDAO er = (ExamResultDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXAMRESULT);

    @Override
    public boolean addExamResult(ExamResultDTO examResult) throws ClassNotFoundException, SQLException {
        ExamResult exre = new ExamResult(examResult.getStuId(),examResult.getExaId(),examResult.getCouId(),examResult.getMark());
        return er.add(exre);
    }

    @Override
    public ObservableList<ExamResultDTO> getAllExamResult() throws ClassNotFoundException, SQLException {
        ObservableList<ExamResult>examResults = er.getAll();
        ObservableList<ExamResultDTO> list = FXCollections.observableArrayList();
        for (ExamResult er : examResults){
            list.add(new ExamResultDTO(er.getStuId(),er.getExaId(),er.getCouId(),er.getMark()));
        }
        return list;
    }

    @Override
    public ExamResultDTO searchExamResult(String id) throws ClassNotFoundException, SQLException {
        ExamResult exre = er.search(id);
        return new ExamResultDTO(exre.getStuId(),exre.getExaId(),exre.getCouId(),exre.getMark());
    }

    @Override
    public boolean updateExamResult(ExamResultDTO examResult) throws ClassNotFoundException, SQLException {
        ExamResult exre = new ExamResult(examResult.getStuId(),examResult.getExaId(),examResult.getCouId(),examResult.getMark());
        return er.update(exre);
    }
}
