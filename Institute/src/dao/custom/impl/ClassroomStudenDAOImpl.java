package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ClassroomStudenDAO;
import entity.ClassroomStudent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassroomStudenDAOImpl implements ClassroomStudenDAO {
    @Override
    public boolean add(ClassroomStudent classroomStudent) throws ClassNotFoundException, SQLException {
        String SQL = "Insert Into classroom_student values (?,?)";
        return CrudUtil.executeUpdate(SQL,classroomStudent.getClaId(),classroomStudent.getStuId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Delete From classroom_student Where stuId=?";
        return CrudUtil.executeUpdate(SQL,id);
    }

    @Override
    public boolean update(ClassroomStudent classroomStudent) throws ClassNotFoundException, SQLException {
        String SQl = "Update classroom_student set claId=? where stuId=?";
        return CrudUtil.executeUpdate(SQl,classroomStudent.getClaId(),classroomStudent.getStuId());
    }

    @Override
    public ClassroomStudent search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From classroom_student Where stuId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL, id);
        if (rst.next()){
            return new ClassroomStudent(rst.getString("stuId"),rst.getString("claId"));
        }
        return null;
    }

    @Override
    public ObservableList<ClassroomStudent> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From classroom_student";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<ClassroomStudent> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new ClassroomStudent(rst.getString("claId"),rst.getString("stuId")));
        }
        return list;
    }
}
