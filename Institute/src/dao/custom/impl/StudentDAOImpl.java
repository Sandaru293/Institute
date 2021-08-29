package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDAO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO{
    @Override
    public boolean add(Student student) throws ClassNotFoundException, SQLException {
        String SQL = "Insert into Student Values (?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(SQL,student.getStuId(),student.getStuName(),student.getBod(),student.getAddress(),student.getStuEmail(),student.getStuTelNo());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Delete from Student where stuId=?";
        return CrudUtil.executeUpdate(SQL,id);
    }

    @Override
    public boolean update(Student student) throws ClassNotFoundException, SQLException {
        String SQL = "Update Student set stuName=?, bod=?, Address=?, stuEmail=?, stuTelNo=? where stuId=?";
        return CrudUtil.executeUpdate(SQL,student.getStuName(),student.getBod(),student.getAddress(),student.getStuEmail(),student.getStuTelNo(),student.getStuId());
    }

    @Override
    public Student search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * from Student where stuId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL, id);
        if (rst.next()){
            return new Student(rst.getString("stuId"),rst.getString("stuName"),rst.getString("bod"),rst.getString("address"),rst.getString("stuEmail"),rst.getString("stuTelNo"));
        }
        return null;
    }

    @Override
    public ObservableList<Student> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * from Student";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Student> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Student(rst.getString("stuId"),rst.getString("stuName"),rst.getString("bod"),rst.getString("address"),rst.getString("stuEmail"),rst.getString("stuTelNo")));
        }
        return list;
    }
}
