package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ExamDAO;
import entity.Exam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamDAOImpl implements ExamDAO {
    @Override
    public boolean add(Exam exam) throws ClassNotFoundException, SQLException {
        String SQL = "Insert Into Exam values (?,?,?)";
        return CrudUtil.executeUpdate(SQL,exam.getExaId(),exam.getExaName(),exam.getStart_date());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Delete From Exam Where exaId=?";
        return CrudUtil.executeUpdate(SQL,id);
    }

    @Override
    public boolean update(Exam exam) throws ClassNotFoundException, SQLException {
        String SQl = "Update Exam set exaName=?, start_date=? where exaId=?";
        return CrudUtil.executeUpdate(SQl,exam.getExaName(),exam.getStart_date(),exam.getExaId());
    }

    @Override
    public Exam search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Exam Where exaId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL, id);
        if (rst.next()){
            return new Exam(rst.getString("exaId"),rst.getString("exaName"),rst.getString("start_date"));
        }
        return null;
    }

    @Override
    public ObservableList<Exam> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Exam";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Exam> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Exam(rst.getString("exaId"),rst.getString("exaName"),rst.getString("start_date")));
        }
        return list;
    }
}
