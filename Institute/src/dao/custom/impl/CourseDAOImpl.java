package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CourseDAO;
import entity.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean add(Course course) throws ClassNotFoundException, SQLException {
        String SQL = "Insert Into Course values (?,?,?)";
        return CrudUtil.executeUpdate(SQL,course.getCouId(),course.getCouName(),course.getFee());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Delete From Course Where couId=?";
        return CrudUtil.executeUpdate(SQL,id);
    }

    @Override
    public boolean update(Course course) throws ClassNotFoundException, SQLException {
        String SQl = "Update Course set couName=? , fee=? where couId=?";
        return CrudUtil.executeUpdate(SQl,course.getCouName(),course.getFee(),course.getCouId());
    }

    @Override
    public Course search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Course Where couId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL,id);
        if (rst.next()){
            return new Course(rst.getString("couId"),rst.getString("couName"),rst.getDouble("fee"));
        }
        return null;
    }

    @Override
    public ObservableList<Course> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Course";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Course> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Course(rst.getString("couId"),rst.getString("couName"),rst.getDouble("fee")));
        }
        return list;
    }
}
