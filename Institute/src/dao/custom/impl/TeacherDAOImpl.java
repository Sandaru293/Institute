package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.TeacherDAO;
import entity.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public boolean add(Teacher teacher) throws ClassNotFoundException, SQLException {
        String SQL = "Insert Into Teacher values (?,?,?,?)";
        return CrudUtil.executeUpdate(SQL,teacher.getTeaId(),teacher.getTeaName(),teacher.getTeaTelNo(),teacher.getTeaEmail());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Delete From Teacher Where teaId=?";
        return CrudUtil.executeUpdate(SQL,id);
    }

    @Override
    public boolean update(Teacher teacher) throws ClassNotFoundException, SQLException {
        String SQl = "Update Teacher set teaName=?, teaTelNo=?, teaEmail=? where teaId=?";
        return CrudUtil.executeUpdate(SQl,teacher.getTeaName(),teacher.getTeaTelNo(),teacher.getTeaEmail(),teacher.getTeaId());
    }

    @Override
    public Teacher search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Teacher Where teaId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL, id);
        if (rst.next()){
            return new Teacher(rst.getString("teaId"),rst.getString("teaName"),rst.getString("teaTelNo"),rst.getString("teaEmail"));
        }
        return null;
    }

    @Override
    public ObservableList<Teacher> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Teacher";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Teacher> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Teacher(rst.getString("teaId"),rst.getString("teaName"),rst.getString("teaTelNo"),rst.getString("teaEmail")));
        }
        return list;
    }
}
