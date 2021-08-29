package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ExamResultDAO;
import entity.ExamResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamResultDAOImpl implements ExamResultDAO {
    @Override
    public boolean add(ExamResult examResult) throws ClassNotFoundException, SQLException {
        String SQL = "Insert Into exam_result values (?,?,?,?)";
        return CrudUtil.executeUpdate(SQL,examResult.getStuId(),examResult.getExaId(),examResult.getCouId(),examResult.getMark());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(ExamResult examResult) throws ClassNotFoundException, SQLException {
        String SQl = "Update exam_result set exaId=?, couId=?, mark=? where stuId=?";
        return CrudUtil.executeUpdate(SQl,examResult.getExaId(),examResult.getCouId(),examResult.getMark(),examResult.getStuId());
    }

    @Override
    public ExamResult search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From exam_result Where stuId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL, id);
        if (rst.next()){
            return new ExamResult(rst.getString("stuId"),rst.getString("exaId"),rst.getString("couId"),rst.getString("mark"));
        }
        return null;
    }

    @Override
    public ObservableList<ExamResult> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From exam_result";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<ExamResult> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new ExamResult(rst.getString("stuId"),rst.getString("exaId"),rst.getString("couId"),rst.getString("mark")));
        }
        return list;
    }
}
