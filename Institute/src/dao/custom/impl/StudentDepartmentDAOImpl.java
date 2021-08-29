package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDepartmentDAO;
import entity.StudentDepartment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDepartmentDAOImpl implements StudentDepartmentDAO {
    @Override
    public boolean add(StudentDepartment studentDepartment) throws ClassNotFoundException, SQLException {
        String SQL = "Insert Into student_department values (?,?,?)";
        return CrudUtil.executeUpdate(SQL,studentDepartment.getStuId(),studentDepartment.getDepId(),studentDepartment.getSalary());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Delete From student_department Where stuId=?";
        return CrudUtil.executeUpdate(SQL,id);
    }

    @Override
    public boolean update(StudentDepartment studentDepartment) throws ClassNotFoundException, SQLException {
        String SQl = "Update student_department set depId=?, salary=? where stuId=?";
        return CrudUtil.executeUpdate(SQl,studentDepartment.getDepId(),studentDepartment.getSalary(),studentDepartment.getStuId());
    }

    @Override
    public StudentDepartment search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From student_department Where stuId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL,id);
        if(rst.next()){
            return new StudentDepartment(rst.getString("stuId"),rst.getString("depId"),rst.getDouble("salary"));
        }
        return null;
    }

    @Override
    public ObservableList<StudentDepartment> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From student_department";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<StudentDepartment> list  = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new StudentDepartment(rst.getString("stuId"),rst.getString("depId"),rst.getDouble("salary")));
        }
        return list;
    }
}
