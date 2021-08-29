package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ClassroomDAO;
import entity.Classroom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassroomDAOImpl implements ClassroomDAO {
    @Override
    public boolean add(Classroom classroom) throws ClassNotFoundException, SQLException {
        String SQL = "Insert Into Classroom values (?,?)";
        return CrudUtil.executeUpdate(SQL,classroom.getClaId(),classroom.getTeaId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Delete From Classroom Where claId=?";
        return CrudUtil.executeUpdate(SQL,id);
    }

    @Override
    public boolean update(Classroom classroom) throws ClassNotFoundException, SQLException {
        String SQl = "Update Classroom set teaId=? where claId=?";
        return CrudUtil.executeUpdate(SQl,classroom.getTeaId(),classroom.getClaId());
    }

    @Override
    public Classroom search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Classroom Where claId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL, id);
        if (rst.next()){
            return new Classroom(rst.getString("claId"),rst.getString("teaId"));
        }
        return null;
    }

    @Override
    public ObservableList<Classroom> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Classroom";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Classroom> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Classroom(rst.getString("claId"),rst.getString("teaId")));
        }
        return list;
    }
}
