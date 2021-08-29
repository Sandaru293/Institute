package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.DepartmentDAO;
import entity.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public boolean add(Department department) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Department department) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Department search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Department Where depId=?";
        ResultSet rst = CrudUtil.executeQuery(SQL, id);
        if (rst.next()){
            return new Department(rst.getString("depId"),rst.getString("depName"));
        }
        return null;
    }

    @Override
    public ObservableList<Department> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Department";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Department> list  = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Department(rst.getString("depId"),rst.getString("depName")));
        }
        return list;
    }
}
