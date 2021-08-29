package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CourseClassroomDAO;
import entity.CourseClassroom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseClassroomDAOImpl implements CourseClassroomDAO {
    @Override
    public boolean add(CourseClassroom courseClassroom) throws ClassNotFoundException, SQLException {
        String SQL = "Insert Into course_classroom values (?,?)";
        return CrudUtil.executeUpdate(SQL,courseClassroom.getCouId(),courseClassroom.getClaId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Delete From course_classroom Where couId=?";
        return CrudUtil.executeUpdate(SQL,id);
    }

    @Override
    public boolean update(CourseClassroom courseClassroom) throws ClassNotFoundException, SQLException {
        String SQl = "Update course_classroom set claId=? where couId=?";
        return CrudUtil.executeUpdate(SQl,courseClassroom.getClaId(),courseClassroom.getCouId());
    }

    @Override
    public CourseClassroom search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From course_classroom Where couId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL,id);
        if(rst.next()){
            return new CourseClassroom(rst.getString("couId"),rst.getString("claId"));
        }
        return null;
    }

    @Override
    public ObservableList<CourseClassroom> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From course_classroom";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<CourseClassroom> list  = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new CourseClassroom(rst.getString("couId"),rst.getString("claId")));
        }
        return list;
    }
}
